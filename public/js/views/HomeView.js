import { BookRepository } from '../data/BookRepository.js';
import { store } from '../store/StateStore.js';

export function renderHome(state) {
  const chapters = BookRepository.getAllChapters();
  const lastChapter = BookRepository.getChapter(state.currentChapterId);
  const isSearching = Boolean(state.searchQuery.trim());

  return `
    <header class="app-topbar">
      <div class="topbar-brand">
        <div class="brand-icon">
          <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <path d="M2 3h6a4 4 0 0 1 4 4v14a3 3 0 0 0-3-3H2z"></path>
            <path d="M22 3h-6a4 4 0 0 0-4 4v14a3 3 0 0 1 3-3h7z"></path>
          </svg>
        </div>
        <div class="brand-text">
          <h1 class="brand-title">Ar-Raheeq</h1>
          <span class="brand-subtitle">The Sealed Nectar (Roman Urdu)</span>
        </div>
      </div>
      <div class="topbar-actions">
        <button id="btn-theme-toggle" class="btn-icon" title="Toggle Theme" aria-label="Toggle Theme">
          ${getThemeIcon(state.themeMode)}
        </button>
        <button id="btn-open-bookmarks" class="btn-icon relative" title="Bookmarks" aria-label="Bookmarks">
          <svg width="20" height="20" viewBox="0 0 24 24" fill="${state.bookmarks.length > 0 ? 'var(--gold-accent)' : 'none'}" stroke="currentColor" stroke-width="2">
            <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
          </svg>
          ${state.bookmarks.length > 0 ? `<span class="badge-count">${state.bookmarks.length}</span>` : ''}
        </button>
        <button id="btn-open-settings" class="btn-icon" title="Settings" aria-label="Settings">
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

    <main class="home-container">
      <!-- Hero Banner -->
      <section class="hero-banner">
        <div class="hero-image-overlay"></div>
        <div class="hero-content">
          <span class="hero-tag">Authentic Seerah in Roman Urdu</span>
          <h2 class="hero-arabic">الرَّحِيقُ الْمَخْتُومُ</h2>
          <h3 class="hero-title">Ar-Raheeq Al-Makhtum • The Sealed Nectar</h3>
          <p class="hero-author">Sheikh Saifur Rahman al-Mubarakpuri (R.A)</p>
        </div>
      </section>

      <!-- Resume Reading Card -->
      ${lastChapter ? `
        <section class="resume-card" id="card-resume-reading">
          <div class="resume-info">
            <div class="resume-header">
              <svg width="18" height="18" viewBox="0 0 24 24" fill="var(--gold-accent)" stroke="var(--gold-accent)" stroke-width="2">
                <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z"></path>
              </svg>
              <span class="resume-label">Continue Reading</span>
            </div>
            <h4 class="resume-chapter">Baab ${lastChapter.id}: ${lastChapter.titleUrdu}</h4>
            <span class="resume-page">Safa ${state.currentPageIndex + 1} of ${lastChapter.pages.length}</span>
          </div>
          <button class="btn-resume" id="btn-resume-action">
            <span>Resume</span>
            <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <line x1="5" y1="12" x2="19" y2="12"></line>
              <polyline points="12 5 19 12 12 19"></polyline>
            </svg>
          </button>
        </section>
      ` : ''}

      <!-- Search Bar -->
      <section class="search-section">
        <div class="search-input-wrapper">
          <svg class="search-icon" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <circle cx="11" cy="11" r="8"></circle>
            <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
          </svg>
          <input 
            type="text" 
            id="search-input" 
            class="search-input" 
            placeholder="Search Seerah (e.g. Hira, Badr, Hudaibiyah, Bilal)..." 
            value="${escapeHtml(state.searchQuery)}"
          />
          ${isSearching ? `
            <button id="btn-clear-search" class="btn-clear-search" aria-label="Clear Search">
              <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <line x1="18" y1="6" x2="6" y2="18"></line>
                <line x1="6" y1="6" x2="18" y2="18"></line>
              </svg>
            </button>
          ` : ''}
        </div>
      </section>

      <!-- Content Section (Search Results or Chapters List) -->
      ${isSearching ? renderSearchResults(state.searchResults, state.searchQuery) : renderChaptersList(chapters)}
    </main>
  `;
}

function renderChaptersList(chapters) {
  return `
    <section class="chapters-section">
      <div class="section-header">
        <h3 class="section-title">Abwaab (Chapters)</h3>
        <span class="section-meta">${chapters.length} Chapters • 60 Pages</span>
      </div>
      <div class="chapters-grid">
        ${chapters.map(chapter => `
          <div class="chapter-card" data-chapter-id="${chapter.id}">
            <div class="chapter-num-badge">${chapter.id}</div>
            <div class="chapter-details">
              <div class="chapter-tags">
                <span class="era-tag ${chapter.era.includes('Makki') ? 'era-makki' : 'era-madani'}">${chapter.era}</span>
                <span class="pages-tag">${chapter.pages.length} Safa</span>
              </div>
              <h4 class="chapter-title-urdu">${chapter.titleUrdu}</h4>
              <p class="chapter-title-english">${chapter.titleEnglish}</p>
              <p class="chapter-summary">${chapter.summaryUrdu}</p>
            </div>
            <div class="chapter-arrow">
              <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <polyline points="9 18 15 12 9 6"></polyline>
              </svg>
            </div>
          </div>
        `).join('')}
      </div>
    </section>
  `;
}

function renderSearchResults(results, query) {
  return `
    <section class="search-results-section">
      <h3 class="section-title">Search Results (${results.length})</h3>
      ${results.length === 0 ? `
        <div class="empty-state">
          <svg width="48" height="48" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5">
            <circle cx="11" cy="11" r="8"></circle>
            <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
          </svg>
          <p class="empty-title">Koi nateeja nahi mila</p>
          <p class="empty-subtitle">'${escapeHtml(query)}' ke mutabiq koi lafz ya aayat nahi mili.</p>
        </div>
      ` : `
        <div class="results-list">
          ${results.map(res => `
            <div class="search-result-card" data-chapter-id="${res.chapter.id}" data-page-index="${res.pageIndex}">
              <div class="result-header">
                <span class="result-chapter">Baab ${res.chapter.id}: ${res.chapter.titleUrdu}</span>
                <span class="result-page">Safa ${res.pageIndex + 1}</span>
              </div>
              <h4 class="result-heading">${res.page.titleUrdu}</h4>
              <p class="result-snippet">${escapeHtml(res.snippet)}</p>
            </div>
          `).join('')}
        </div>
      `}
    </section>
  `;
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
