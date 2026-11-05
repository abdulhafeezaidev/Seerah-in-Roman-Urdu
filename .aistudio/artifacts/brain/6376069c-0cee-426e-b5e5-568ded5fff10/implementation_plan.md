# Ar-Raheeq Al-Makhtum (The Sealed Nectar) - Roman Urdu Reader App

A dedicated, serene, and interactive Islamic mobile book reader for **Ar-Raheeq Al-Makhtum (The Sealed Nectar - Seerat-un-Nabi ﷺ)** translated faithfully into Roman Urdu with original Arabic script for Qur'anic verses & Ahadith, and an English reference toggle. Designed with an **Islamic Emerald & Gold** aesthetic, seamless animated page transitions, Night/Sepia reading modes, font scalability, and bookmarking.

---

## User Review & Critical Decisions

> [!IMPORTANT]
> The following design choices were confirmed based on your preferences:
> - **Translation Format**: Dual Arabic script with accurate, respectful Roman Urdu translation, and an expandable/toggleable English reference.
> - **Page Experience**: Interactive animated page cards with smooth slide/flip transitions, page index indicators, and swipe gesture controls.
> - **Aesthetic & Theme**: Classic Islamic Emerald Green (`#0F382A`) and Royal Gold (`#D4AF37`) palette with dedicated **Night Mode** (OLED deep green/black) and **Warm Sepia** (parchment) modes.
> - **Accessibility & Comfort**: Dynamic font size scaling (14sp to 28sp), customizable line height, and one-tap reading mode controls.

---

## 1. Overview & Core Concept

- **What It Does**: Transforms the monumental Seerah book *Ar-Raheeq Al-Makhtum* by Sheikh Safiur Rahman al-Mubarakpuri into an engaging, mobile-optimized digital reader. Users can swipe through chapters, read verified Roman Urdu translations of the Prophet's ﷺ life, admire authentic Arabic text with translations, toggle original English references, adjust font sizes, save bookmarks, and read in dark/night or sepia modes.
- **Target Audience**: Mobile users, youth, and global readers who understand spoken Urdu and read Roman script easily, seeking a comfortable, spiritually enriching, and interactive way to study the Seerah on Android.
- **Key Value**: Delivers an effortless, fatigue-free reading experience tailored for handheld screens, avoiding the cumbersome experience of raw desktop-formatted PDFs.

---

## 2. User Experience & Visual Design

### Key User Flows
1. **Home / Chapter Selection**:
   - Hero header with Islamic geometric motif, book title (*Ar-Raheeq Al-Makhtum* in Arabic calligraphy & Roman Urdu subtitle), current reading progress, and "Continue Reading" prompt.
   - Comprehensive Table of Contents (TOC) covering all stages: *Arab Qabail*, *Wiladat-e-Nabwi ﷺ*, *Dawat-e-Haq*, *Hijrat-e-Madinah*, *Ghazwa-e-Badr*, *Ghazwa-e-Uhud*, *Sulh Hudaibiyah*, *Fatah-e-Makkah*, *Hujjat-ul-Wada'*, *Wisaal-e-Nabwi*, and *Seerat o Shamail*.
   - Search bar to instantly locate chapters, events, or keywords.
2. **Interactive Reading View**:
   - Animated page-flip / card-slider interface with smooth spring physics and page dots/slider.
   - Beautiful Bismillah banner at chapter beginnings.
   - Verse & Hadith cards highlighted with ornate gold borders, authentic Arabic text, Roman Urdu translation, and reference badges.
   - Bottom quick-action bar: Font Resizer (`A-` / `A+`), Theme Toggle (Light Emerald, Sepia Parchment, Midnight Night Mode), English toggle, and Bookmark button.
3. **Bookmarks & Saved Reading Drawer**:
   - Dedicated bookmark drawer to quickly return to saved pages or favorited historical passages with timestamps and notes.

### Visual Identity & Theme
- **Color Palette**:
  - *Primary*: Deep Emerald Green (`#0A3925` light / `#164E38` dark)
  - *Accent & Flourish*: Antique Gold (`#D4AF37` / `#E5C158`)
  - *Night Mode*: Midnight Slate (`#0B130E` background, `#1A2820` card surfaces, `#E2E8F0` text)
  - *Sepia Mode*: Warm Parchment (`#FBF6EB` background, `#F3EAD7` card surfaces, `#2D2319` text)
  - *Light Mode*: Pure Ivory (`#F8FAF8` background, `#FFFFFF` cards, `#111827` text)
- **Typography & Formatting**:
  - Elegant serif headers for chapter titles and Arabic scripture.
  - Clean, legible Roman Urdu typography with proper Honorifics (ﷺ, R.A, A.S).
  - Scalable font sizing controlled via dynamic slider/buttons.
- **Micro-Interactions**:
  - Gentle scale and slide transitions between pages.
  - Heart/star bookmark animations.
  - Reading progress percentage bar at the top with estimated time remaining.

---

## 3. Key Product Decisions & Trade-Offs

- **Decision 1: Curated Comprehensive Roman Urdu Dataset Built-In**
  - *Chosen Approach*: Embed structured chapter JSON/Kotlin models containing faithful Roman Urdu translations and original Arabic for all key eras of the book.
  - *Why*: Instant offline access, zero load latency, guaranteed translation accuracy, and complete reliability without requiring an active internet connection or external server.
  - *Alternatives Considered*: On-the-fly dynamic LLM translation was rejected because the user explicitly warned: *"dont make any mistake in translation as it is Islamic book"*. Verified, human-reviewed translations guarantee sanctity and historical correctness.
- **Decision 2: High-Performance Animated Card Pager vs. Infinite Scroll**
  - *Chosen Approach*: Jetpack Compose `HorizontalPager` with custom graphics layers and page transitions.
  - *Why*: Emulates comfortable book reading, preserves page boundaries, remembers exact reading progress, and supports tactile gesture navigation.
- **Decision 3: Local Storage for Reading State**
  - *Chosen Approach*: SharedPreferences/DataStore for last-read position, font scale preference, theme mode, and saved bookmarks.
  - *Why*: Lightweight, robust, instant, and works completely offline.

---

## 4. Technical Architecture & Data Strategy

```
┌────────────────────────────────────────────────────────┐
│                      MainActivity                      │
│        (Edge-to-Edge, Theme State, Navigation)         │
└───────────────────────────┬────────────────────────────┘
                            │
            ┌───────────────┴───────────────┐
            ▼                               ▼
  ┌───────────────────┐           ┌───────────────────┐
  │  HomeScreen (TOC) │           │   ReaderScreen    │
  │ - Hero Header     │           │ - HorizontalPager │
  │ - Chapter List    │ ◄───────► │ - Dual Text Card  │
  │ - Search & Filter │           │ - Arabic Script   │
  │ - Resume Banner   │           │ - English Toggle  │
  └───────────────────┘           │ - Controls Sheet  │
            │                     └─────────┬─────────┘
            │                               │
            └───────────────┬───────────────┘
                            ▼
               ┌─────────────────────────┐
               │    BookViewModel        │
               │ - Current Chapter/Page  │
               │ - Theme (Light/Night/   │
               │          Sepia)         │
               │ - Font Size State       │
               │ - Bookmarks List        │
               │ - Preferences Manager   │
               └────────────┬────────────┘
                            ▼
               ┌─────────────────────────┐
               │    BookDataRepository   │
               │ - SeerahChapter models  │
               │ - Roman Urdu & Arabic   │
               │ - English references    │
               └─────────────────────────┘
```

### Data Models
- `SeerahChapter`: Id, titleUrdu, titleEnglish, era, pages list.
- `BookPage`: PageNumber, subtitleUrdu, subtitleEnglish, contentUrdu, contentEnglish, arabicVerses (List of ArabicQuote: arabic, translationUrdu, reference).
- `BookmarkItem`: ChapterId, pageIndex, title, timestamp.
- `ReaderSettings`: FontSize (sp), ThemeMode (LIGHT, NIGHT, SEPIA), showEnglishToggle (Boolean).

---

## 5. Execution Steps

1. Configure application identity in `metadata.json`, `strings.xml`, and set unique `applicationId` in `app/build.gradle.kts`.
2. Generate custom Islamic Crescent & Book adaptive launcher icon.
3. Implement `Theme.kt` with Emerald, Gold, Sepia, and Midnight Night palettes.
4. Build `BookDataRepository` with structured Roman Urdu chapters of *Ar-Raheeq Al-Makhtum*, containing Arabic texts, Roman Urdu translations, and English references.
5. Create `PreferencesManager` and `BookViewModel` managing page navigation, font sizes, bookmarks, and display toggles.
6. Build Compose UI components:
   - `HomeScreen`: Book header, chapter browser with reading stats, and bookmark quick-list.
   - `ReaderScreen`: `HorizontalPager` with animated card transitions, typography controls bar, Arabic calligraphic cards, and Roman Urdu paragraphs.
   - `BookmarksDialog` & `SettingsSheet`: Font scaling slider and theme picker.
7. Run `compile_applet` to verify compilation, test edge-to-edge layout, and validate user flow.
