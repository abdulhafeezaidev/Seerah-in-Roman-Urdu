const STORAGE_KEYS = {
  LAST_CHAPTER_ID: 'ar_raheeq_last_chapter_id',
  LAST_PAGE_INDEX: 'ar_raheeq_last_page_index',
  THEME_MODE: 'ar_raheeq_theme_mode',
  FONT_SIZE: 'ar_raheeq_font_size',
  SHOW_ENGLISH: 'ar_raheeq_show_english',
  BOOKMARKS: 'ar_raheeq_bookmarks'
};

export const StorageService = {
  getLastChapterId() {
    const val = localStorage.getItem(STORAGE_KEYS.LAST_CHAPTER_ID);
    return val ? parseInt(val, 10) : 1;
  },

  setLastChapterId(id) {
    try {
      localStorage.setItem(STORAGE_KEYS.LAST_CHAPTER_ID, String(id));
    } catch (e) {
      console.warn('Storage unavailable', e);
    }
  },

  getLastPageIndex() {
    const val = localStorage.getItem(STORAGE_KEYS.LAST_PAGE_INDEX);
    return val ? parseInt(val, 10) : 0;
  },

  setLastPageIndex(index) {
    try {
      localStorage.setItem(STORAGE_KEYS.LAST_PAGE_INDEX, String(index));
    } catch (e) {
      console.warn('Storage unavailable', e);
    }
  },

  getThemeMode() {
    const val = localStorage.getItem(STORAGE_KEYS.THEME_MODE);
    return ['light', 'sepia', 'night'].includes(val) ? val : 'light';
  },

  setThemeMode(mode) {
    try {
      localStorage.setItem(STORAGE_KEYS.THEME_MODE, mode);
    } catch (e) {
      console.warn('Storage unavailable', e);
    }
  },

  getFontSize() {
    const val = localStorage.getItem(STORAGE_KEYS.FONT_SIZE);
    const parsed = val ? parseFloat(val) : 17;
    return Math.min(26, Math.max(13, parsed));
  },

  setFontSize(size) {
    try {
      const clamped = Math.min(26, Math.max(13, size));
      localStorage.setItem(STORAGE_KEYS.FONT_SIZE, String(clamped));
    } catch (e) {
      console.warn('Storage unavailable', e);
    }
  },

  getShowEnglish() {
    return localStorage.getItem(STORAGE_KEYS.SHOW_ENGLISH) === 'true';
  },

  setShowEnglish(show) {
    try {
      localStorage.setItem(STORAGE_KEYS.SHOW_ENGLISH, show ? 'true' : 'false');
    } catch (e) {
      console.warn('Storage unavailable', e);
    }
  },

  getBookmarks() {
    try {
      const json = localStorage.getItem(STORAGE_KEYS.BOOKMARKS);
      return json ? JSON.parse(json) : [];
    } catch (e) {
      console.error('Error reading bookmarks', e);
      return [];
    }
  },

  saveBookmarks(bookmarks) {
    try {
      localStorage.setItem(STORAGE_KEYS.BOOKMARKS, JSON.stringify(bookmarks));
    } catch (e) {
      console.warn('Storage unavailable', e);
    }
  },

  addBookmark(chapterId, pageIndex, chapterTitleUrdu, pageTitleUrdu, snippet) {
    const id = `${chapterId}_${pageIndex + 1}`;
    const bookmarks = this.getBookmarks().filter(b => b.id !== id);
    const newBookmark = {
      id,
      chapterId: parseInt(chapterId, 10),
      pageIndex: parseInt(pageIndex, 10),
      pageNumber: parseInt(pageIndex, 10) + 1,
      chapterTitleUrdu,
      pageTitleUrdu,
      snippet: snippet.substring(0, 140) + '...',
      timestamp: Date.now()
    };
    bookmarks.unshift(newBookmark);
    this.saveBookmarks(bookmarks);
    return bookmarks;
  },

  removeBookmark(id) {
    const bookmarks = this.getBookmarks().filter(b => b.id !== id);
    this.saveBookmarks(bookmarks);
    return bookmarks;
  },

  isBookmarked(chapterId, pageIndex) {
    const id = `${chapterId}_${pageIndex + 1}`;
    return this.getBookmarks().some(b => b.id === id);
  }
};
