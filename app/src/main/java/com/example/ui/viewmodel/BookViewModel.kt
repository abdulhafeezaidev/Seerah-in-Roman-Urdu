package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.BookmarkItem
import com.example.data.model.SeerahChapter
import com.example.data.preferences.BookPreferences
import com.example.data.repository.SearchMatch
import com.example.data.repository.SeerahBookRepository
import com.example.ui.theme.ReaderThemeMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface AppScreen {
    data object Home : AppScreen
    data class Reader(val chapterId: Int, val initialPageIndex: Int = 0) : AppScreen
}

data class ReaderUiState(
    val currentScreen: AppScreen = AppScreen.Home,
    val currentChapterId: Int = 1,
    val currentPageIndex: Int = 0,
    val themeMode: ReaderThemeMode = ReaderThemeMode.LIGHT,
    val fontSizeSp: Float = 17f,
    val showEnglish: Boolean = false,
    val bookmarks: List<BookmarkItem> = emptyList(),
    val searchQuery: String = "",
    val searchResults: List<SearchMatch> = emptyList(),
    val showSettingsDialog: Boolean = false,
    val showBookmarksSheet: Boolean = false,
    val toastMessage: String? = null
)

class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val prefs = BookPreferences(application)

    private val _uiState = MutableStateFlow(
        ReaderUiState(
            currentChapterId = prefs.lastChapterId,
            currentPageIndex = prefs.lastPageIndex,
            themeMode = prefs.themeMode,
            fontSizeSp = prefs.fontSizeSp,
            showEnglish = prefs.showEnglishToggle,
            bookmarks = prefs.getBookmarks()
        )
    )
    val uiState: StateFlow<ReaderUiState> = _uiState.asStateFlow()

    fun openReader(chapterId: Int, pageIndex: Int = 0) {
        prefs.lastChapterId = chapterId
        prefs.lastPageIndex = pageIndex
        _uiState.update {
            it.copy(
                currentScreen = AppScreen.Reader(chapterId, pageIndex),
                currentChapterId = chapterId,
                currentPageIndex = pageIndex
            )
        }
    }

    fun resumeReading() {
        openReader(prefs.lastChapterId, prefs.lastPageIndex)
    }

    fun navigateToHome() {
        _uiState.update { it.copy(currentScreen = AppScreen.Home) }
    }

    fun onPageChanged(chapterId: Int, pageIndex: Int) {
        prefs.lastChapterId = chapterId
        prefs.lastPageIndex = pageIndex
        _uiState.update {
            it.copy(
                currentChapterId = chapterId,
                currentPageIndex = pageIndex
            )
        }
    }

    fun nextChapter() {
        val next = SeerahBookRepository.getNextChapter(_uiState.value.currentChapterId)
        if (next != null) {
            openReader(next.id, 0)
        }
    }

    fun previousChapter() {
        val prev = SeerahBookRepository.getPreviousChapter(_uiState.value.currentChapterId)
        if (prev != null) {
            val lastPageIdx = (prev.pages.size - 1).coerceAtLeast(0)
            openReader(prev.id, lastPageIdx)
        }
    }

    fun setThemeMode(mode: ReaderThemeMode) {
        prefs.themeMode = mode
        _uiState.update { it.copy(themeMode = mode) }
    }

    fun cycleThemeMode() {
        val next = when (_uiState.value.themeMode) {
            ReaderThemeMode.LIGHT -> ReaderThemeMode.SEPIA
            ReaderThemeMode.SEPIA -> ReaderThemeMode.NIGHT
            ReaderThemeMode.NIGHT -> ReaderThemeMode.LIGHT
        }
        setThemeMode(next)
    }

    fun setFontSize(size: Float) {
        val clamped = size.coerceIn(13f, 26f)
        prefs.fontSizeSp = clamped
        _uiState.update { it.copy(fontSizeSp = clamped) }
    }

    fun increaseFontSize() {
        setFontSize(_uiState.value.fontSizeSp + 1.5f)
    }

    fun decreaseFontSize() {
        setFontSize(_uiState.value.fontSizeSp - 1.5f)
    }

    fun toggleEnglish() {
        val newToggle = !_uiState.value.showEnglish
        prefs.showEnglishToggle = newToggle
        _uiState.update { it.copy(showEnglish = newToggle) }
    }

    fun toggleBookmark(chapter: SeerahChapter, pageIndex: Int) {
        val page = chapter.pages.getOrNull(pageIndex) ?: return
        val bookmarkId = "${chapter.id}_${page.pageNumber}"
        val currentBookmarks = _uiState.value.bookmarks.toMutableList()
        val existingIndex = currentBookmarks.indexOfFirst { it.id == bookmarkId }

        if (existingIndex >= 0) {
            currentBookmarks.removeAt(existingIndex)
            prefs.saveBookmarks(currentBookmarks)
            _uiState.update {
                it.copy(
                    bookmarks = currentBookmarks,
                    toastMessage = "Bookmark removed"
                )
            }
        } else {
            val snippet = page.urduContent.take(120) + "..."
            val newBookmark = BookmarkItem(
                id = bookmarkId,
                chapterId = chapter.id,
                pageIndex = pageIndex,
                chapterTitleUrdu = chapter.titleUrdu,
                pageTitleUrdu = page.urduHeading,
                snippet = snippet,
                timestamp = System.currentTimeMillis()
            )
            currentBookmarks.add(0, newBookmark)
            prefs.saveBookmarks(currentBookmarks)
            _uiState.update {
                it.copy(
                    bookmarks = currentBookmarks,
                    toastMessage = "Bookmark added!"
                )
            }
        }
    }

    fun isBookmarked(chapterId: Int, pageNumber: Int): Boolean {
        val bookmarkId = "${chapterId}_${pageNumber}"
        return _uiState.value.bookmarks.any { it.id == bookmarkId }
    }

    fun removeBookmark(id: String) {
        val updated = _uiState.value.bookmarks.filterNot { it.id == id }
        prefs.saveBookmarks(updated)
        _uiState.update { it.copy(bookmarks = updated) }
    }

    fun updateSearchQuery(query: String) {
        val results = SeerahBookRepository.search(query)
        _uiState.update {
            it.copy(
                searchQuery = query,
                searchResults = results
            )
        }
    }

    fun clearSearch() {
        _uiState.update {
            it.copy(
                searchQuery = "",
                searchResults = emptyList()
            )
        }
    }

    fun setShowSettingsDialog(show: Boolean) {
        _uiState.update { it.copy(showSettingsDialog = show) }
    }

    fun setShowBookmarksSheet(show: Boolean) {
        _uiState.update { it.copy(showBookmarksSheet = show) }
    }

    fun clearToast() {
        _uiState.update { it.copy(toastMessage = null) }
    }
}
