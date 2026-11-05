import { StorageService } from '../services/StorageService.js';
import { BookRepository } from '../data/BookRepository.js';

class StateStore {
  constructor() {
    this.state = {
      currentView: 'home', // 'home' | 'reader'
      currentChapterId: StorageService.getLastChapterId(),
      currentPageIndex: StorageService.getLastPageIndex(),
      themeMode: StorageService.getThemeMode(),
      fontSize: StorageService.getFontSize(),
      showEnglish: StorageService.getShowEnglish(),
      bookmarks: StorageService.getBookmarks(),
      searchQuery: '',
      searchResults: [],
      activeModal: null, // null | 'settings' | 'bookmarks'
      toastMessage: null
    };

    this.listeners = new Set();
  }

  getState() {
    return this.state;
  }

  subscribe(listener) {
    this.listeners.add(listener);
    return () => this.listeners.delete(listener);
  }

  notify() {
    for (const listener of this.listeners) {
      listener(this.state);
    }
  }

  setState(partial) {
    this.state = { ...this.state, ...partial };
    this.notify();
  }

  // Actions
  openReader(chapterId, pageIndex = 0) {
    StorageService.setLastChapterId(chapterId);
    StorageService.setLastPageIndex(pageIndex);
    this.setState({
      currentView: 'reader',
      currentChapterId: chapterId,
      currentPageIndex: pageIndex,
      activeModal: null
    });
  }

  resumeReading() {
    const chapterId = StorageService.getLastChapterId();
    const pageIndex = StorageService.getLastPageIndex();
    this.openReader(chapterId, pageIndex);
  }

  navigateToHome() {
    this.setState({
      currentView: 'home',
      activeModal: null
    });
  }

  setPage(pageIndex) {
    StorageService.setLastPageIndex(pageIndex);
    this.setState({ currentPageIndex: pageIndex });
  }

  nextPage() {
    const chapter = BookRepository.getChapter(this.state.currentChapterId);
    if (!chapter) return;

    if (this.state.currentPageIndex < chapter.pages.length - 1) {
      this.setPage(this.state.currentPageIndex + 1);
    } else {
      const nextChapter = BookRepository.getNextChapter(this.state.currentChapterId);
      if (nextChapter) {
        this.openReader(nextChapter.id, 0);
      }
    }
  }

  previousPage() {
    if (this.state.currentPageIndex > 0) {
      this.setPage(this.state.currentPageIndex - 1);
    } else {
      const prevChapter = BookRepository.getPreviousChapter(this.state.currentChapterId);
      if (prevChapter) {
        this.openReader(prevChapter.id, Math.max(0, prevChapter.pages.length - 1));
      }
    }
  }

  setTheme(mode) {
    StorageService.setThemeMode(mode);
    this.setState({ themeMode: mode });
  }

  cycleTheme() {
    const next = {
      light: 'sepia',
      sepia: 'night',
      night: 'light'
    }[this.state.themeMode] || 'light';
    this.setTheme(next);
  }

  setFontSize(size) {
    const clamped = Math.min(26, Math.max(13, size));
    StorageService.setFontSize(clamped);
    this.setState({ fontSize: clamped });
  }

  increaseFontSize() {
    this.setFontSize(this.state.fontSize + 1.5);
  }

  decreaseFontSize() {
    this.setFontSize(this.state.fontSize - 1.5);
  }

  toggleEnglish() {
    const next = !this.state.showEnglish;
    StorageService.setShowEnglish(next);
    this.setState({ showEnglish: next });
  }

  toggleBookmark() {
    const chapter = BookRepository.getChapter(this.state.currentChapterId);
    if (!chapter) return;
    const page = chapter.pages[this.state.currentPageIndex];
    if (!page) return;

    const isBookmarked = StorageService.isBookmarked(chapter.id, this.state.currentPageIndex);
    let updated;
    if (isBookmarked) {
      updated = StorageService.removeBookmark(`${chapter.id}_${this.state.currentPageIndex + 1}`);
      this.showToast('Bookmark removed');
    } else {
      updated = StorageService.addBookmark(
        chapter.id,
        this.state.currentPageIndex,
        chapter.titleUrdu,
        page.titleUrdu,
        page.contentUrdu
      );
      this.showToast('Bookmark saved!');
    }
    this.setState({ bookmarks: updated });
  }

  removeBookmark(id) {
    const updated = StorageService.removeBookmark(id);
    this.setState({ bookmarks: updated });
  }

  search(query) {
    const results = BookRepository.search(query);
    this.setState({
      searchQuery: query,
      searchResults: results
    });
  }

  clearSearch() {
    this.setState({
      searchQuery: '',
      searchResults: []
    });
  }

  openModal(modalName) {
    this.setState({ activeModal: modalName });
  }

  closeModal() {
    this.setState({ activeModal: null });
  }

  showToast(message) {
    this.setState({ toastMessage: message });
    setTimeout(() => {
      if (this.state.toastMessage === message) {
        this.setState({ toastMessage: null });
      }
    }, 2500);
  }
}

export const store = new StateStore();
