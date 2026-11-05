package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.data.model.ArabicQuote
import com.example.data.model.BookPage
import com.example.data.model.SeerahChapter
import com.example.data.repository.SeerahBookRepository
import com.example.ui.theme.IslamicGold
import com.example.ui.theme.IslamicGoldDark
import com.example.ui.theme.ReaderThemeMode
import com.example.ui.viewmodel.ReaderUiState
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderScreen(
    chapterId: Int,
    initialPageIndex: Int,
    uiState: ReaderUiState,
    onBack: () -> Unit,
    onPageChanged: (chapterId: Int, pageIndex: Int) -> Unit,
    onNextChapter: () -> Unit,
    onPreviousChapter: () -> Unit,
    onToggleBookmark: (SeerahChapter, Int) -> Unit,
    onIncreaseFontSize: () -> Unit,
    onDecreaseFontSize: () -> Unit,
    onCycleTheme: () -> Unit,
    onToggleEnglish: () -> Unit,
    onOpenSettings: () -> Unit
) {
    val chapter = SeerahBookRepository.getChapter(chapterId)
    if (chapter == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Chapter not found")
        }
        return
    }

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = initialPageIndex.coerceIn(0, (chapter.pages.size - 1).coerceAtLeast(0)),
        pageCount = { chapter.pages.size }
    )

    LaunchedEffect(pagerState.currentPage) {
        onPageChanged(chapter.id, pagerState.currentPage)
    }

    val isCurrentBookmarked = uiState.bookmarks.any {
        it.id == "${chapter.id}_${pagerState.currentPage + 1}"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Baab ${chapter.id}: ${chapter.titleUrdu}",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Safa ${pagerState.currentPage + 1} of ${chapter.pages.size} • ${chapter.era}",
                            style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("reader_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back to Chapters"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { onToggleBookmark(chapter, pagerState.currentPage) },
                        modifier = Modifier.testTag("reader_bookmark_button")
                    ) {
                        Icon(
                            imageVector = if (isCurrentBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Bookmark Page",
                            tint = if (isCurrentBookmarked) IslamicGold else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    IconButton(
                        onClick = onOpenSettings,
                        modifier = Modifier.testTag("reader_settings_button")
                    ) {
                        Icon(imageVector = Icons.Default.Tune, contentDescription = "Settings")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            ReaderBottomDock(
                currentPage = pagerState.currentPage,
                totalPages = chapter.pages.size,
                fontSizeSp = uiState.fontSizeSp,
                themeMode = uiState.themeMode,
                showEnglish = uiState.showEnglish,
                onPrevious = {
                    if (pagerState.currentPage > 0) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    } else {
                        onPreviousChapter()
                    }
                },
                onNext = {
                    if (pagerState.currentPage < chapter.pages.size - 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        onNextChapter()
                    }
                },
                onIncreaseFont = onIncreaseFontSize,
                onDecreaseFont = onDecreaseFontSize,
                onCycleTheme = onCycleTheme,
                onToggleEnglish = onToggleEnglish
            )
        }
    ) { paddingValues ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .testTag("reader_horizontal_pager")
        ) { pageIndex ->
            // Animated page card effect based on offset
            val pageOffset = (
                    (pagerState.currentPage - pageIndex) + pagerState.currentPageOffsetFraction
                    ).absoluteValue

            val pageScale = lerp(0.92f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
            val pageAlpha = lerp(0.5f, 1f, 1f - pageOffset.coerceIn(0f, 1f))

            val page = chapter.pages[pageIndex]

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        scaleX = pageScale
                        scaleY = pageScale
                        alpha = pageAlpha
                    }
            ) {
                PageCardContent(
                    chapter = chapter,
                    page = page,
                    fontSizeSp = uiState.fontSizeSp,
                    showEnglish = uiState.showEnglish,
                    isLastPage = pageIndex == chapter.pages.size - 1,
                    onNextChapter = onNextChapter
                )
            }
        }
    }
}

@Composable
private fun PageCardContent(
    chapter: SeerahChapter,
    page: BookPage,
    fontSizeSp: Float,
    showEnglish: Boolean,
    isLastPage: Boolean,
    onNextChapter: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Bismillah Calligraphic Header
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Bismillaahir-Rahmaanir-Raheem",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Page Heading
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp, 28.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(IslamicGold)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = page.urduHeading,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = (fontSizeSp + 3f).sp
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        // Arabic Quotes Box (if any)
        if (page.arabicQuotes.isNotEmpty()) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                page.arabicQuotes.forEach { quote ->
                    ArabicQuoteCard(quote = quote)
                }
            }
        }

        // Main Roman Urdu Narrative Text
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "Tarjuma (Roman Urdu)",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = page.urduContent,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = fontSizeSp.sp,
                        lineHeight = (fontSizeSp * 1.6f).sp,
                        fontWeight = FontWeight.Normal
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        // Original English Reference Toggle Card
        if (showEnglish) {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                ),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Translate,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Original English Reference (The Sealed Nectar)",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = page.englishContent,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = (fontSizeSp - 1f).sp,
                            lineHeight = ((fontSizeSp - 1f) * 1.5f).sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Key Takeaway (Sabaq) Card
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = IslamicGold.copy(alpha = 0.12f)),
            border = androidx.compose.foundation.BorderStroke(1.dp, IslamicGold.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(IslamicGold.copy(alpha = 0.25f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = "Key Lesson",
                        tint = IslamicGoldDark,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Azeem Sabaq (Key Takeaway)",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = IslamicGoldDark
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = page.keyTakeaway,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = (fontSizeSp - 1f).sp,
                            lineHeight = ((fontSizeSp - 1f) * 1.45f).sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        // Next Chapter Banner on last page
        if (isLastPage) {
            val nextChap = SeerahBookRepository.getNextChapter(chapter.id)
            if (nextChap != null) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNextChapter() }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Agle Baab Par Jayein",
                                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Baab ${nextChap.id}: ${nextChap.titleUrdu}",
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Next Chapter",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
private fun ArabicQuoteCard(quote: ArabicQuote) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.primary.copy(alpha = 0.25f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Arabic Text with Tashkeel
            Text(
                text = quote.arabic,
                fontSize = 20.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Roman Urdu Transliteration & Meaning
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    color = IslamicGold.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "Roman Urdu",
                        color = IslamicGoldDark,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = quote.romanUrdu,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(6.dp))

            // English Meaning
            Text(
                text = "“${quote.englishTranslation}”",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun ReaderBottomDock(
    currentPage: Int,
    totalPages: Int,
    fontSizeSp: Float,
    themeMode: ReaderThemeMode,
    showEnglish: Boolean,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onIncreaseFont: () -> Unit,
    onDecreaseFont: () -> Unit,
    onCycleTheme: () -> Unit,
    onToggleEnglish: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp,
        shadowElevation = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Previous Page Button
            IconButton(
                onClick = onPrevious,
                modifier = Modifier.testTag("reader_prev_page_button")
            ) {
                Icon(
                    imageVector = Icons.Default.NavigateBefore,
                    contentDescription = "Previous Page",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            // Quick Font Size Buttons: A- and A+
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = onDecreaseFont,
                    enabled = fontSizeSp > 13.5f,
                    modifier = Modifier.testTag("font_decrease_button")
                ) {
                    Text("A-", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
                Text(
                    text = "${fontSizeSp.toInt()}",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
                IconButton(
                    onClick = onIncreaseFont,
                    enabled = fontSizeSp < 25.5f,
                    modifier = Modifier.testTag("font_increase_button")
                ) {
                    Text("A+", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }

            // Theme cycler button
            IconButton(
                onClick = onCycleTheme,
                modifier = Modifier.testTag("reader_cycle_theme_button")
            ) {
                val (icon, label) = when (themeMode) {
                    ReaderThemeMode.LIGHT -> Pair(Icons.Default.DarkMode, "Night")
                    ReaderThemeMode.SEPIA -> Pair(Icons.Default.LightMode, "Light")
                    ReaderThemeMode.NIGHT -> Pair(Icons.Default.WbSunny, "Sepia")
                }
                Icon(imageVector = icon, contentDescription = label)
            }

            // English Toggle Chip/Button
            FilledTonalIconToggleButton(
                checked = showEnglish,
                onCheckedChange = { onToggleEnglish() },
                modifier = Modifier.testTag("reader_toggle_en_button")
            ) {
                Text(
                    text = "EN",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = if (showEnglish) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Next Page Button
            IconButton(
                onClick = onNext,
                modifier = Modifier.testTag("reader_next_page_button")
            ) {
                Icon(
                    imageVector = Icons.Default.NavigateNext,
                    contentDescription = "Next Page",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
