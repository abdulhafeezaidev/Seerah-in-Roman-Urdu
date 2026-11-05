package com.example.data.model

data class ArabicQuote(
    val arabicText: String,
    val romanUrduTranslation: String,
    val englishTranslation: String,
    val reference: String = ""
) {
    val arabic: String get() = arabicText
    val romanUrdu: String get() = romanUrduTranslation
}

data class BookPage(
    val pageNumber: Int,
    val titleUrdu: String,
    val titleEnglish: String,
    val contentUrdu: String,
    val contentEnglish: String,
    val arabicQuotes: List<ArabicQuote> = emptyList(),
    val reflectionUrdu: String = ""
) {
    val urduHeading: String get() = titleUrdu
    val urduContent: String get() = contentUrdu
    val englishContent: String get() = contentEnglish
    val keyTakeaway: String get() = reflectionUrdu
}

data class SeerahChapter(
    val id: Int,
    val titleUrdu: String,
    val titleEnglish: String,
    val era: String, // "Makki Daur" or "Madani Daur"
    val summaryUrdu: String,
    val pages: List<BookPage>
) {
    val pageCount: Int get() = pages.size
}

data class BookmarkItem(
    val id: String,
    val chapterId: Int,
    val pageIndex: Int,
    val chapterTitleUrdu: String,
    val pageTitleUrdu: String,
    val snippet: String,
    val timestamp: Long = System.currentTimeMillis()
) {
    val pageNumber: Int get() = pageIndex + 1
    val pageHeading: String get() = pageTitleUrdu
}
