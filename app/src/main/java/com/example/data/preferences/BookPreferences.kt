package com.example.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.data.model.BookmarkItem
import com.example.ui.theme.ReaderThemeMode
import org.json.JSONArray
import org.json.JSONObject

class BookPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("ar_raheeq_prefs", Context.MODE_PRIVATE)

    var lastChapterId: Int
        get() = prefs.getInt(KEY_LAST_CHAPTER_ID, 1)
        set(value) = prefs.edit().putInt(KEY_LAST_CHAPTER_ID, value).apply()

    var lastPageIndex: Int
        get() = prefs.getInt(KEY_LAST_PAGE_INDEX, 0)
        set(value) = prefs.edit().putInt(KEY_LAST_PAGE_INDEX, value).apply()

    var themeMode: ReaderThemeMode
        get() {
            val name = prefs.getString(KEY_THEME_MODE, ReaderThemeMode.LIGHT.name)
            return try {
                ReaderThemeMode.valueOf(name ?: ReaderThemeMode.LIGHT.name)
            } catch (e: Exception) {
                ReaderThemeMode.LIGHT
            }
        }
        set(value) = prefs.edit().putString(KEY_THEME_MODE, value.name).apply()

    var fontSizeSp: Float
        get() = prefs.getFloat(KEY_FONT_SIZE_SP, 17f)
        set(value) = prefs.edit().putFloat(KEY_FONT_SIZE_SP, value.coerceIn(13f, 26f)).apply()

    var showEnglishToggle: Boolean
        get() = prefs.getBoolean(KEY_SHOW_ENGLISH, false)
        set(value) = prefs.edit().putBoolean(KEY_SHOW_ENGLISH, value).apply()

    fun getBookmarks(): List<BookmarkItem> {
        val json = prefs.getString(KEY_BOOKMARKS, "[]") ?: "[]"
        val list = mutableListOf<BookmarkItem>()
        try {
            val arr = JSONArray(json)
            for (i in 0 until arr.length()) {
                val obj = arr.getJSONObject(i)
                list.add(
                    BookmarkItem(
                        id = obj.getString("id"),
                        chapterId = obj.getInt("chapterId"),
                        pageIndex = obj.optInt("pageIndex", (obj.optInt("pageNumber", 1) - 1).coerceAtLeast(0)),
                        chapterTitleUrdu = obj.getString("chapterTitleUrdu"),
                        pageTitleUrdu = obj.optString("pageTitleUrdu", obj.optString("pageHeading", "")),
                        snippet = obj.getString("snippet"),
                        timestamp = obj.optLong("timestamp", System.currentTimeMillis())
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    fun saveBookmarks(bookmarks: List<BookmarkItem>) {
        val arr = JSONArray()
        for (item in bookmarks) {
            val obj = JSONObject()
            obj.put("id", item.id)
            obj.put("chapterId", item.chapterId)
            obj.put("pageIndex", item.pageIndex)
            obj.put("chapterTitleUrdu", item.chapterTitleUrdu)
            obj.put("pageTitleUrdu", item.pageTitleUrdu)
            obj.put("snippet", item.snippet)
            obj.put("timestamp", item.timestamp)
            arr.put(obj)
        }
        prefs.edit().putString(KEY_BOOKMARKS, arr.toString()).apply()
    }

    companion object {
        private const val KEY_LAST_CHAPTER_ID = "key_last_chapter_id"
        private const val KEY_LAST_PAGE_INDEX = "key_last_page_index"
        private const val KEY_THEME_MODE = "key_theme_mode"
        private const val KEY_FONT_SIZE_SP = "key_font_size_sp"
        private const val KEY_SHOW_ENGLISH = "key_show_english"
        private const val KEY_BOOKMARKS = "key_bookmarks"
    }
}
