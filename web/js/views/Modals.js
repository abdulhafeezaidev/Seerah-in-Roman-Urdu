import { store } from '../store/StateStore.js';

export function renderModals(state) {
  let modalContent = '';
  if (state.activeModal === 'settings') {
    modalContent = renderSettings(state);
  } else if (state.activeModal === 'bookmarks') {
    modalContent = renderBookmarks(state);
  }

  const toastHtml = state.toastMessage ? `
    <div class="toast-snackbar animate-fade-in">
      <span>${escapeHtml(state.toastMessage)}</span>
    </div>
  ` : '';

  return `
    ${modalContent}
    ${toastHtml}
  `;
}

function renderSettings(state) {
  return `
    <div class="modal-backdrop" id="modal-backdrop">
      <div class="modal-card animate-scale-up" role="dialog" aria-modal="true" aria-labelledby="settings-title">
        <div class="modal-header">
          <div class="modal-title-group">
            <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="var(--primary-color)" stroke-width="2">
              <line x1="4" y1="21" x2="4" y2="14"></line>
              <line x1="4" y1="10" x2="4" y2="3"></line>
              <line x1="12" y1="21" x2="12" y2="12"></line>
              <line x1="12" y1="8" x2="12" y2="3"></line>
              <line x1="20" y1="21" x2="20" y2="16"></line>
              <line x1="20" y1="12" x2="20" y2="3"></line>
              <line x1="1" y1="14" x2="7" y2="14"></line>
              <line x1="9" y1="8" x2="15" y2="8"></line>
              <line x1="17" y1="16" x2="23" y2="16"></line>
            </svg>
            <h3 id="settings-title" class="modal-title">Reading Settings</h3>
          </div>
          <button id="btn-close-modal" class="btn-icon" aria-label="Close">
            <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <line x1="18" y1="6" x2="6" y2="18"></line>
              <line x1="6" y1="6" x2="18" y2="18"></line>
            </svg>
          </button>
        </div>

        <div class="modal-body">
          <!-- Theme Selection -->
          <div class="setting-group">
            <label class="setting-label">Aesthetic Theme</label>
            <div class="theme-chips-row">
              <button class="theme-chip ${state.themeMode === 'light' ? 'chip-active' : ''}" data-theme="light">
                <span class="chip-color-dot dot-light"></span>
                <span class="chip-title">Emerald</span>
                <span class="chip-sub">Day</span>
              </button>
              <button class="theme-chip ${state.themeMode === 'sepia' ? 'chip-active' : ''}" data-theme="sepia">
                <span class="chip-color-dot dot-sepia"></span>
                <span class="chip-title">Sepia</span>
                <span class="chip-sub">Paper</span>
              </button>
              <button class="theme-chip ${state.themeMode === 'night' ? 'chip-active' : ''}" data-theme="night">
                <span class="chip-color-dot dot-night"></span>
                <span class="chip-title">Night</span>
                <span class="chip-sub">Dark</span>
              </button>
            </div>
          </div>

          <!-- Font Size Slider -->
          <div class="setting-group">
            <div class="setting-label-row">
              <label class="setting-label">Font Size</label>
              <span class="setting-value">${Math.round(state.fontSize)} px</span>
            </div>
            <input 
              type="range" 
              id="settings-font-slider" 
              min="13" 
              max="26" 
              step="1" 
              value="${state.fontSize}" 
              class="settings-slider"
            />
            <div class="font-preview-box" style="font-size: ${state.fontSize}px;">
              Nabi-e-Karam ﷺ ne farmaya: 'Maine deen ki amanat pohcha di.'
            </div>
          </div>

          <!-- English Reference Toggle -->
          <div class="setting-group toggle-row" id="row-toggle-en">
            <div class="toggle-texts">
              <span class="toggle-title">English Reference Text</span>
              <span class="toggle-sub">Show original English alongside Roman Urdu</span>
            </div>
            <label class="switch">
              <input type="checkbox" id="switch-show-english" ${state.showEnglish ? 'checked' : ''} />
              <span class="slider-round"></span>
            </label>
          </div>
        </div>

        <div class="modal-footer">
          <button id="btn-done-settings" class="btn-primary full-width">Done</button>
        </div>
      </div>
    </div>
  `;
}

function renderBookmarks(state) {
  const bookmarks = state.bookmarks || [];

  return `
    <div class="modal-backdrop" id="modal-backdrop">
      <div class="modal-card modal-card-sheet animate-slide-up" role="dialog" aria-modal="true" aria-labelledby="bookmarks-title">
        <div class="modal-header">
          <div class="modal-title-group">
            <svg width="22" height="22" viewBox="0 0 24 24" fill="var(--gold-accent)" stroke="var(--gold-accent)" stroke-width="2">
              <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
            </svg>
            <h3 id="bookmarks-title" class="modal-title">Saved Bookmarks</h3>
          </div>
          <button id="btn-close-modal" class="btn-icon" aria-label="Close">
            <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <line x1="18" y1="6" x2="6" y2="18"></line>
              <line x1="6" y1="6" x2="18" y2="18"></line>
            </svg>
          </button>
        </div>

        <div class="modal-body bookmarks-body">
          ${bookmarks.length === 0 ? `
            <div class="empty-state">
              <svg width="56" height="56" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5">
                <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
              </svg>
              <p class="empty-title">Abhi koi bookmark mehfooz nahi</p>
              <p class="empty-subtitle">Reader me bookmark icon daba kar kisi bhi safay ko save karein</p>
            </div>
          ` : `
            <div class="bookmarks-list">
              ${bookmarks.map(item => `
                <div class="bookmark-item-card">
                  <div class="bookmark-badge">${item.chapterId}</div>
                  <div class="bookmark-details" data-jump-chapter="${item.chapterId}" data-jump-page="${item.pageIndex}">
                    <span class="bm-chapter">${escapeHtml(item.chapterTitleUrdu)}</span>
                    <h4 class="bm-heading">${escapeHtml(item.pageTitleUrdu)} (Safa ${item.pageNumber})</h4>
                    <p class="bm-snippet">${escapeHtml(item.snippet)}</p>
                  </div>
                  <button class="btn-delete-bm" data-delete-id="${item.id}" title="Delete Bookmark" aria-label="Delete">
                    <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                      <polyline points="3 6 5 6 21 6"></polyline>
                      <path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path>
                    </svg>
                  </button>
                </div>
              `).join('')}
            </div>
          `}
        </div>
      </div>
    </div>
  `;
}

function escapeHtml(text) {
  if (!text) return '';
  return text.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}
