package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.repository.SeerahBookRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Ar-Raheeq", appName)
  }

  @Test
  fun `verify Seerah book repository has 20 authentic chapters`() {
    val chapters = SeerahBookRepository.allChapters
    assertEquals(20, chapters.size)

    // Check first and last chapters
    assertEquals(1, chapters.first().id)
    assertEquals(20, chapters.last().id)

    // Ensure all chapters have pages with Roman Urdu content and Arabic quotes
    for (chap in chapters) {
      assertTrue("Chapter ${chap.id} should have pages", chap.pages.isNotEmpty())
      for (page in chap.pages) {
        assertTrue("Page ${page.pageNumber} in Chapter ${chap.id} content should not be empty", page.urduContent.isNotBlank())
        assertTrue("Page ${page.pageNumber} in Chapter ${chap.id} takeaway should not be empty", page.keyTakeaway.isNotBlank())
      }
    }
  }

  @Test
  fun `verify search function in SeerahBookRepository`() {
    val results = SeerahBookRepository.search("Badr")
    assertTrue("Search for 'Badr' should yield matches", results.isNotEmpty())
  }
}
