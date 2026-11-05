package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.dialogs.BookmarksBottomSheet
import com.example.ui.dialogs.SettingsDialog
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.ReaderScreen
import com.example.ui.theme.ArRaheeqTheme
import com.example.ui.viewmodel.AppScreen
import com.example.ui.viewmodel.BookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: BookViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val snackbarHostState = remember { SnackbarHostState() }

            LaunchedEffect(uiState.toastMessage) {
                uiState.toastMessage?.let { msg ->
                    snackbarHostState.showSnackbar(msg)
                    viewModel.clearToast()
                }
            }

            ArRaheeqTheme(themeMode = uiState.themeMode) {
                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (val screen = uiState.currentScreen) {
                            is AppScreen.Home -> {
                                HomeScreen(
                                    uiState = uiState,
                                    onChapterClick = { chapterId ->
                                        viewModel.openReader(chapterId, 0)
                                    },
                                    onResumeReading = {
                                        viewModel.resumeReading()
                                    },
                                    onSearchResultClick = { chapterId, pageNumber ->
                                        viewModel.openReader(chapterId, pageNumber - 1)
                                    },
                                    onSearchQueryChange = { query ->
                                        viewModel.updateSearchQuery(query)
                                    },
                                    onClearSearch = {
                                        viewModel.clearSearch()
                                    },
                                    onCycleTheme = {
                                        viewModel.cycleThemeMode()
                                    },
                                    onOpenBookmarks = {
                                        viewModel.setShowBookmarksSheet(true)
                                    },
                                    onOpenSettings = {
                                        viewModel.setShowSettingsDialog(true)
                                    }
                                )
                            }
                            is AppScreen.Reader -> {
                                BackHandler {
                                    viewModel.navigateToHome()
                                }

                                ReaderScreen(
                                    chapterId = screen.chapterId,
                                    initialPageIndex = screen.initialPageIndex,
                                    uiState = uiState,
                                    onBack = {
                                        viewModel.navigateToHome()
                                    },
                                    onPageChanged = { chapId, pageIdx ->
                                        viewModel.onPageChanged(chapId, pageIdx)
                                    },
                                    onNextChapter = {
                                        viewModel.nextChapter()
                                    },
                                    onPreviousChapter = {
                                        viewModel.previousChapter()
                                    },
                                    onToggleBookmark = { chap, pageIdx ->
                                        viewModel.toggleBookmark(chap, pageIdx)
                                    },
                                    onIncreaseFontSize = {
                                        viewModel.increaseFontSize()
                                    },
                                    onDecreaseFontSize = {
                                        viewModel.decreaseFontSize()
                                    },
                                    onCycleTheme = {
                                        viewModel.cycleThemeMode()
                                    },
                                    onToggleEnglish = {
                                        viewModel.toggleEnglish()
                                    },
                                    onOpenSettings = {
                                        viewModel.setShowSettingsDialog(true)
                                    }
                                )
                            }
                        }

                        // Settings Dialog
                        if (uiState.showSettingsDialog) {
                            SettingsDialog(
                                themeMode = uiState.themeMode,
                                fontSizeSp = uiState.fontSizeSp,
                                showEnglish = uiState.showEnglish,
                                onThemeSelect = { mode ->
                                    viewModel.setThemeMode(mode)
                                },
                                onFontSizeChange = { size ->
                                    viewModel.setFontSize(size)
                                },
                                onToggleEnglish = {
                                    viewModel.toggleEnglish()
                                },
                                onDismiss = {
                                    viewModel.setShowSettingsDialog(false)
                                }
                            )
                        }

                        // Bookmarks Bottom Sheet
                        if (uiState.showBookmarksSheet) {
                            BookmarksBottomSheet(
                                bookmarks = uiState.bookmarks,
                                onSelectBookmark = { chapterId, pageNumber ->
                                    viewModel.openReader(chapterId, pageNumber - 1)
                                },
                                onDeleteBookmark = { id ->
                                    viewModel.removeBookmark(id)
                                },
                                onDismiss = {
                                    viewModel.setShowBookmarksSheet(false)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
