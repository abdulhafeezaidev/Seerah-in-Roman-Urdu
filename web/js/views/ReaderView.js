import { BookRepository } from '../data/BookRepository.js';
import { StorageService } from '../services/StorageService.js';
import { store } from '../store/StateStore.js';

export function renderReader(state) {
  const chapter = BookRepository.getChapter(state.currentChapterId);
  if (!chapter) {
    return `<div class="reader-not-found">Chapter not found <button id="btn-back-home" class="btn-primary">Return Home</button></div>`;
  }

  const pageIndex = Math.min(Math.max(0, state.currentPageIndex), chapter.pages.length - 1);
  const page = chapter.pages[pageIndex];
  const isBookmarked = StorageService.isBookmarked(chapter.id, pageIndex);
  const isLastPage = pageIndex === chapter.pages.length - 1;
  const nextChapter = isLastPage ? BookRepository.getNextChapter(chapter.id) : null;

  return `
    <header class="app-topbar reader-topbar">
      <div class="topbar-left">
        <button id="btn-reader-back" class="btn-icon" title="Back to Chapters" aria-label="Back">
          <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <line x1="19" y1="12" x2="5" y2="12"></line>
            <polyline points="12 19 5 12 12 5"></polyline>
          </svg>
        </button>
        <div class="reader-header-titles">
          <h2 class="reader-chap-title">Baab ${chapter.id}: ${chapter.titleUrdu}</h2>
          <span class="reader-chap-meta">Safa ${pageIndex + 1} of ${chapter.pages.length} • ${chapter.era}</span>
        </div>
      </div>
      <div class="topbar-actions">
        <button id="btn-reader-bookmark" class="btn-icon" title="Bookmark Page" aria-label="Bookmark">
          <svg width="20" height="20" viewBox="0 0 24 24" fill="${isBookmarked ? 'var(--gold-accent)' : 'none'}" stroke="${isBookmarked ? 'var(--gold-accent)' : 'currentColor'}" stroke-width="2">
            <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
          </svg>
        </button>
        <button id="btn-reader-settings" class="btn-icon" title="Settings" aria-label="Settings">
          <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
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
        </button>
      </div>
    </header>

    <main class="reader-canvas">
      <article class="reader-page-card" style="--reader-font-size: ${state.fontSize}px;">
        <!-- Bismillah Banner -->
        <div class="bismillah-badge">
          <span class="bismillah-arabic">بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ</span>
          <span class="bismillah-trans">Bismillaahir-Rahmaanir-Raheem</span>
        </div>

        <!-- Page Heading -->
        <div class="page-heading-wrapper">
          <div class="heading-gold-bar"></div>
          <h2 class="page-heading">${page.titleUrdu}</h2>
        </div>

        <!-- Arabic Quotes -->
        ${(page.arabicQuotes || []).map(quote => `
          <div class="arabic-quote-card">
            <p class="arabic-script">${quote.arabicText}</p>
            <div class="quote-label-pill">Roman Urdu</div>
            <p class="quote-roman-urdu">${quote.romanUrduTranslation}</p>
            <p class="quote-english">“${quote.englishTranslation}”</p>
            ${quote.reference ? `<span class="quote-reference">${quote.reference}</span>` : ''}
          </div>
        `).join('')}

        <!-- Main Narrative Text -->
        <div class="narrative-card">
          <div class="card-section-label">Tarjuma (Roman Urdu)</div>
          <div class="narrative-content">
            ${formatParagraphs(page.contentUrdu)}
          </div>
        </div>

        <!-- Toggleable English Reference Card -->
        ${state.showEnglish ? `
          <div class="english-reference-card">
            <div class="english-card-header">
              <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <circle cx="12" cy="12" r="10"></circle>
                <line x1="2" y1="12" x2="22" y2="12"></line>
                <path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"></path>
              </svg>
              <span>Original English Reference (The Sealed Nectar)</span>
            </div>
            <div class="english-card-body">
              ${formatParagraphs(page.contentEnglish)}
            </div>
          </div>
        ` : ''}

        <!-- Key Takeaway (Azeem Sabaq) Card -->
        ${page.reflectionUrdu ? `
          <div class="takeaway-card">
            <div class="takeaway-icon">
              <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <path d="M9 18h6"></path>
                <path d="M10 22h4"></path>
                <path d="M15.09 14c.18-.98.65-1.74 1.41-2.5A4.65 4.65 0 0 0 18 8 6 6 0 0 0 6 8c0 1 .23 2.23 1.5 3.5A4.61 4.61 0 0 1 8.91 14"></path>
              </svg>
            </div>
            <div class="takeaway-text">
              <h4 class="takeaway-title">Azeem Sabaq (Key Takeaway)</h4>
              <p class="takeaway-desc">${page.reflectionUrdu}</p>
            </div>
          </div>
        ` : ''}

        <!-- Next Chapter Banner on Last Page -->
        ${isLastPage && nextChapter ? `
          <div class="next-chapter-banner" id="btn-next-chapter">
            <div class="banner-texts">
              <span class="banner-sub">Agle Baab Par Jayein</span>
              <h4 class="banner-title">Baab ${nextChapter.id}: ${nextChapter.titleUrdu}</h4>
            </div>
            <div class="banner-arrow">
              <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <line x1="5" y1="12" x2="19" y2="12"></line>
                <polyline points="12 5 19 12 12 19"></polyline>
              </svg>
            </div>
          </div>
        ` : ''}
      </article>
    </main>

    <!-- Bottom Dock -->
    <nav class="reader-dock">
      <button id="btn-prev-page" class="dock-btn" title="Previous Page" aria-label="Previous Page">
        <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
          <polyline points="15 18 9 12 15 6"></polyline>
        </svg>
      </button>

      <div class="font-steppers">
        <button id="btn-font-dec" class="font-btn" title="Decrease Font" ${state.fontSize <= 13 ? 'disabled' : ''}>A-</button>
        <span class="font-size-indicator">${Math.round(state.fontSize)}</span>
        <button id="btn-font-inc" class="font-btn" title="Increase Font" ${state.fontSize >= 26 ? 'disabled' : ''}>A+</button>
      </div>

      <button id="btn-dock-theme" class="dock-btn" title="Cycle Theme" aria-label="Cycle Theme">
        ${getThemeIcon(state.themeMode)}
      </button>

      <button id="btn-toggle-en" class="dock-btn en-btn ${state.showEnglish ? 'en-active' : ''}" title="Toggle English" aria-label="Toggle English">
        <span>EN</span>
      </button>

      <button id="btn-next-page" class="dock-btn" title="Next Page" aria-label="Next Page">
        <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
          <polyline points="9 18 15 12 9 6"></polyline>
        </svg>
      </button>
    </nav>
  `;
}

function formatParagraphs(text) {
  if (!text) return '';
  return text
    .split('\n\n')
    .map(p => `<p>${escapeHtml(p).replace(/\n/g, '<br/>')}</p>`)
    .join('');
}

function getThemeIcon(mode) {
  if (mode === 'night') {
    return `<svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><circle cx="12" cy="12" r="5"></circle><line x1="12" y1="1" x2="12" y2="3"></line><line x1="12" y1="21" x2="12" y2="23"></line><line x1="4.22" y1="4.22" x2="5.64" y2="5.64"></line><line x1="18.36" y1="18.36" x2="19.78" y2="19.78"></line><line x1="1" y1="12" x2="3" y2="12"></line><line x1="21" y1="12" x2="23" y2="12"></line><line x1="4.22" y1="19.78" x2="5.64" y2="18.36"></line><line x1="18.36" y1="5.64" x2="19.78" y2="4.22"></line></svg>`;
  } else if (mode === 'sepia') {
    return `<svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M12 2v2M12 20v2M4.93 4.93l1.41 1.41M17.66 17.66l1.41 1.41M2 12h2M20 12h2M6.34 17.66l-1.41 1.41M19.07 4.93l-1.41 1.41"></path></svg>`;
  } else {
    return `<svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M21 12.79A9 9 0 1 1 11.21 3 7 7 0 0 0 21 12.79z"></path></svg>`;
  }
}

function escapeHtml(text) {
  if (!text) return '';
  return text.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}
