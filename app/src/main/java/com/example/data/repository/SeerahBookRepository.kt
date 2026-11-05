package com.example.data.repository

import com.example.data.model.BookPage
import com.example.data.model.SeerahChapter

data class SearchMatch(
    val chapter: SeerahChapter,
    val page: BookPage,
    val matchedSnippet: String
)

object SeerahBookRepository {
    val allChapters: List<SeerahChapter> by lazy {
        listOf(
            SeerahEarlyChapters.chapter1,
            SeerahEarlyChapters.chapter2,
            SeerahEarlyChapters.chapter3,
            SeerahEarlyChapters.chapter4,
            SeerahEarlyChapters.chapter5,
            SeerahEarlyChapters.chapter6,
            SeerahMiddleChapters.chapter7,
            SeerahMiddleChapters.chapter8,
            SeerahMiddleChapters.chapter9,
            SeerahMiddleChapters.chapter10,
            SeerahMiddleChapters.chapter11,
            SeerahMiddleChapters.chapter12,
            SeerahLateChapters.chapter13,
            SeerahLateChapters.chapter14,
            SeerahLateChapters.chapter15,
            SeerahLateChapters.chapter16,
            SeerahFinalChapters.chapter17,
            SeerahFinalChapters.chapter18,
            SeerahFinalChapters.chapter19,
            SeerahFinalChapters.chapter20
        )
    }

    fun getChapter(id: Int): SeerahChapter? {
        return allChapters.firstOrNull { it.id == id }
    }

    fun getNextChapter(currentId: Int): SeerahChapter? {
        val nextId = currentId + 1
        return allChapters.firstOrNull { it.id == nextId }
    }

    fun getPreviousChapter(currentId: Int): SeerahChapter? {
        val prevId = currentId - 1
        return allChapters.firstOrNull { it.id == prevId }
    }

    fun search(query: String): List<SearchMatch> {
        val cleanQuery = query.trim().lowercase()
        if (cleanQuery.isBlank()) return emptyList()

        val results = mutableListOf<SearchMatch>()
        for (chapter in allChapters) {
            val chapterMatchesTitle = chapter.titleUrdu.lowercase().contains(cleanQuery) ||
                    chapter.titleEnglish.lowercase().contains(cleanQuery) ||
                    chapter.summaryUrdu.lowercase().contains(cleanQuery)

            for (page in chapter.pages) {
                val pageMatches = page.urduHeading.lowercase().contains(cleanQuery) ||
                        page.urduContent.lowercase().contains(cleanQuery) ||
                        page.englishContent.lowercase().contains(cleanQuery) ||
                        page.keyTakeaway.lowercase().contains(cleanQuery) ||
                        page.arabicQuotes.any {
                            it.romanUrdu.lowercase().contains(cleanQuery) ||
                                    it.englishTranslation.lowercase().contains(cleanQuery) ||
                                    it.arabic.contains(cleanQuery)
                        }

                if (chapterMatchesTitle || pageMatches) {
                    val snippet = when {
                        page.urduHeading.lowercase().contains(cleanQuery) -> page.urduHeading
                        page.urduContent.lowercase().contains(cleanQuery) -> {
                            val idx = page.urduContent.lowercase().indexOf(cleanQuery)
                            val start = maxOf(0, idx - 40)
                            val end = minOf(page.urduContent.length, idx + cleanQuery.length + 60)
                            "..." + page.urduContent.substring(start, end) + "..."
                        }
                        page.englishContent.lowercase().contains(cleanQuery) -> {
                            val idx = page.englishContent.lowercase().indexOf(cleanQuery)
                            val start = maxOf(0, idx - 40)
                            val end = minOf(page.englishContent.length, idx + cleanQuery.length + 60)
                            "..." + page.englishContent.substring(start, end) + "..."
                        }
                        else -> page.urduHeading
                    }
                    results.add(SearchMatch(chapter = chapter, page = page, matchedSnippet = snippet))
                }
            }
        }
        return results
    }

    fun getTotalPagesCount(): Int {
        return allChapters.sumOf { it.pages.size }
    }
}
