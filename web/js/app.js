import { store } from './store/StateStore.js';
import { renderHome } from './views/HomeView.js';
import { renderReader } from './views/ReaderView.js';
import { renderModals } from './views/Modals.js';

let deferredInstallPrompt = null;

function initApp() {
  const root = document.getElementById('app-root');
  if (!root) return;

  // Subscribe to reactive store
  store.subscribe(state => {
    updateThemeAttribute(state.themeMode);
    render(root, state);
  });

  // Setup Service Worker for offline PWA capability
  registerServiceWorker();

  // Listen for PWA Install Prompt
  window.addEventListener('beforeinstallprompt', e => {
    e.preventDefault();
    deferredInstallPrompt = e;
    showInstallPromptBanner();
  });

  // Keyboard navigation for reader (ArrowLeft/ArrowRight)
  window.addEventListener('keydown', e => {
    const state = store.getState();
    if (state.currentView !== 'reader' || state.activeModal) return;

    if (e.key === 'ArrowRight') {
      store.nextPage();
    } else if (e.key === 'ArrowLeft') {
      store.previousPage();
    }
  });

  // Initial Render
  updateThemeAttribute(store.getState().themeMode);
  render(root, store.getState());

  // Attach Global Event Delegation
  attachEventListeners(root);
}

function updateThemeAttribute(theme) {
  document.documentElement.setAttribute('data-theme', theme);
  const themeColorMeta = document.querySelector('meta[name="theme-color"]');
  if (themeColorMeta) {
    const colors = {
      light: '#0B3B24',
      sepia: '#8B5E3C',
      night: '#0A120E'
    };
    themeColorMeta.setAttribute('content', colors[theme] || '#0B3B24');
  }
}

function render(container, state) {
  let mainContent = '';
  if (state.currentView === 'home') {
    mainContent = renderHome(state);
  } else {
    mainContent = renderReader(state);
  }

  const modalsContent = renderModals(state);
  container.innerHTML = `
    ${mainContent}
    ${modalsContent}
  `;

  // Scroll reader page to top on page change
  if (state.currentView === 'reader') {
    const readerCanvas = container.querySelector('.reader-canvas');
    if (readerCanvas) {
      readerCanvas.scrollTop = 0;
    }
  }
}

function attachEventListeners(container) {
  container.addEventListener('click', e => {
    // 1. Chapter Card Click
    const chapterCard = e.target.closest('.chapter-card');
    if (chapterCard) {
      const chapterId = parseInt(chapterCard.getAttribute('data-chapter-id'), 10);
      store.openReader(chapterId, 0);
      return;
    }

    // 2. Search Result Click
    const resultCard = e.target.closest('.search-result-card');
    if (resultCard) {
      const chapterId = parseInt(resultCard.getAttribute('data-chapter-id'), 10);
      const pageIndex = parseInt(resultCard.getAttribute('data-page-index'), 10);
      store.openReader(chapterId, pageIndex);
      return;
    }

    // 3. Resume Reading Card
    if (e.target.closest('#card-resume-reading') || e.target.closest('#btn-resume-action')) {
      store.resumeReading();
      return;
    }

    // 4. Clear Search Button
    if (e.target.closest('#btn-clear-search')) {
      store.clearSearch();
      return;
    }

    // 5. Header Theme Toggle Button
    if (e.target.closest('#btn-theme-toggle') || e.target.closest('#btn-dock-theme')) {
      store.cycleTheme();
      return;
    }

    // 6. Open Bookmarks Button
    if (e.target.closest('#btn-open-bookmarks')) {
      store.openModal('bookmarks');
      return;
    }

    // 7. Open Settings Button
    if (e.target.closest('#btn-open-settings') || e.target.closest('#btn-reader-settings')) {
      store.openModal('settings');
      return;
    }

    // 8. Reader Back Button
    if (e.target.closest('#btn-reader-back') || e.target.closest('#btn-back-home')) {
      store.navigateToHome();
      return;
    }

    // 9. Reader Bookmark Button
    if (e.target.closest('#btn-reader-bookmark')) {
      store.toggleBookmark();
      return;
    }

    // 10. Reader Prev Page
    if (e.target.closest('#btn-prev-page')) {
      store.previousPage();
      return;
    }

    // 11. Reader Next Page
    if (e.target.closest('#btn-next-page') || e.target.closest('#btn-next-chapter')) {
      store.nextPage();
      return;
    }

    // 12. Font Steppers
    if (e.target.closest('#btn-font-dec')) {
      store.decreaseFontSize();
      return;
    }
    if (e.target.closest('#btn-font-inc')) {
      store.increaseFontSize();
      return;
    }

    // 13. English Reference Toggle (Reader Dock)
    if (e.target.closest('#btn-toggle-en')) {
      store.toggleEnglish();
      return;
    }

    // 14. Close Modal (Backdrop or Close Icon or Done Button)
    if (
      e.target.id === 'modal-backdrop' ||
      e.target.closest('#btn-close-modal') ||
      e.target.closest('#btn-done-settings')
    ) {
      store.closeModal();
      return;
    }

    // 15. Theme Chips inside Settings
    const themeChip = e.target.closest('.theme-chip');
    if (themeChip) {
      const mode = themeChip.getAttribute('data-theme');
      if (mode) store.setTheme(mode);
      return;
    }

    // 16. Bookmark jump in bookmarks list
    const bmDetails = e.target.closest('.bookmark-details');
    if (bmDetails) {
      const chId = parseInt(bmDetails.getAttribute('data-jump-chapter'), 10);
      const pgIdx = parseInt(bmDetails.getAttribute('data-jump-page'), 10);
      store.openReader(chId, pgIdx);
      return;
    }

    // 17. Bookmark delete
    const bmDelete = e.target.closest('.btn-delete-bm');
    if (bmDelete) {
      const id = bmDelete.getAttribute('data-delete-id');
      if (id) store.removeBookmark(id);
      return;
    }

    // 18. Toggle English Row in Settings
    if (e.target.closest('#row-toggle-en') && !e.target.closest('.switch')) {
      store.toggleEnglish();
      return;
    }
  });

  // Input Events (Search & Font Slider)
  container.addEventListener('input', e => {
    if (e.target.id === 'search-input') {
      store.search(e.target.value);
    } else if (e.target.id === 'settings-font-slider') {
      store.setFontSize(parseFloat(e.target.value));
    }
  });

  // Switch Toggle change
  container.addEventListener('change', e => {
    if (e.target.id === 'switch-show-english') {
      store.toggleEnglish();
    }
  });
}

function registerServiceWorker() {
  if ('serviceWorker' in navigator) {
    window.addEventListener('load', () => {
      navigator.serviceWorker
        .register('./sw.js')
        .then(reg => {
          console.log('Ar-Raheeq PWA ServiceWorker registered:', reg.scope);
        })
        .catch(err => {
          console.warn('ServiceWorker registration skipped or failed:', err);
        });
    });
  }
}

function showInstallPromptBanner() {
  if (!deferredInstallPrompt) return;
  // If an install banner already exists, do not recreate
  if (document.getElementById('pwa-install-banner')) return;

  const banner = document.createElement('div');
  banner.id = 'pwa-install-banner';
  banner.className = 'install-banner animate-slide-up';
  banner.innerHTML = `
    <div class="install-banner-content">
      <img src="./assets/icon-192.png" alt="Ar-Raheeq Icon" class="install-icon" />
      <div class="install-texts">
        <strong>Install Ar-Raheeq Web App</strong>
        <span>Read offline anytime from your home screen</span>
      </div>
    </div>
    <div class="install-actions">
      <button id="btn-pwa-dismiss" class="btn-text">Dismiss</button>
      <button id="btn-pwa-install" class="btn-primary-small">Install</button>
    </div>
  `;

  document.body.appendChild(banner);

  document.getElementById('btn-pwa-install')?.addEventListener('click', async () => {
    if (deferredInstallPrompt) {
      deferredInstallPrompt.prompt();
      const choice = await deferredInstallPrompt.userChoice;
      if (choice.outcome === 'accepted') {
        banner.remove();
      }
      deferredInstallPrompt = null;
    }
  });

  document.getElementById('btn-pwa-dismiss')?.addEventListener('click', () => {
    banner.remove();
  });
}

// Initialize on DOMContentLoaded
if (document.readyState === 'loading') {
  document.addEventListener('DOMContentLoaded', initApp);
} else {
  initApp();
}
