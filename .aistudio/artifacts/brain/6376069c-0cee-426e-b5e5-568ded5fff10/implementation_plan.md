# Ar-Raheeq Al-Makhtum - Modular Progressive Web App (PWA)

A clean-architecture, zero-dependency Progressive Web Application for *Ar-Raheeq Al-Makhtum (The Sealed Nectar)* that allows users worldwide to read the complete 20-chapter Seerah in Roman Urdu with authentic Arabic calligraphy, English reference toggle, and offline support on any mobile or desktop browser without installing an APK.

---

## User Review & Critical Decisions

> [!IMPORTANT]
> The following decisions were confirmed during the interactive interview:
> - **Architecture**: Modular PWA with clean separation of concerns (Models, Repositories, State/Store, Services, UI Components) organized into a self-contained `/web` directory ready for 1-click deployment to GitHub Pages, Netlify, Vercel, or Cloudflare Pages.
> - **Offline Capability**: Progressive Web App with a custom Service Worker (`sw.js`) and Web App Manifest (`manifest.json`) supporting full offline reading and "Add to Home Screen" installation.
> - **Persistence**: Browser `localStorage` with reactive state management, automatic reading position restoration, and bookmarking.
> - **Preservation of Android Core**: All existing Android project code, build configurations, and APK assets remain untouched.

---

## 1. Overview & Core Concept

- **What It Does**: Provides an instant, zero-install web reader accessible via any modern browser (iOS Safari, Android Chrome, Desktop Edge/Chrome/Firefox/Safari). Features the full 20 chapters (60 interactive pages), authentic Arabic script with Tashkeel, clear Roman Urdu translation, toggleable English reference, 3 visual reading themes (Emerald Day, Sepia Paper, Night Dark), font size controls, live search, and bookmarks.
- **Target Audience**: Mobile and desktop users seeking comfortable, reverent reading of the Prophet Muhammad's ﷺ life story without needing an Android device or Google Play installation.
- **Key Value**: 100% portable, hostable anywhere with zero server-side build steps or backend servers needed, loadable in milliseconds with complete offline capability.

---

## 2. User Experience & Visual Design

### Key User Flows
1. **Landing & Exploration**: 
   - Welcomed by an Islamic header banner featuring the golden book and crescent motif.
   - Quick **"Continue Reading"** card immediately restores the user's exact last-read chapter and page.
   - Live search input allows instant real-time filtering across Roman Urdu, Arabic, and English terms.
   - Structured list of all 20 Abwaab (Chapters) with era badges (Makki Daur vs. Madani Daur), page counters, and summaries.
2. **Reading Experience**:
   - Clean, full-bleed reading card with smooth slide animation transitions.
   - Bismillah calligraphy header (`بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ`).
   - Arabic calligraphy quote container with Harakat/Tashkeel, Roman Urdu transliteration, and reference.
   - Scalable Roman Urdu main text with adjustable line spacing.
   - Toggleable English reference card for bilingual comparison.
   - Highlighted golden *Azeem Sabaq* (Key Takeaway) card for spiritual reflection.
3. **Controls & Customization**:
   - Docked bottom control bar with Previous / Next navigation, `A-` / `A+` font size steppers, theme cycler, and `EN` reference toggle.
   - Settings modal with live preview slider and theme swatches.
   - Bookmarks drawer with direct jump and one-click removal.

### Visual Identity & Theme Tokens
- **Emerald Theme (Day Default)**: Primary `#0B3B24`, Gold Accent `#D4AF37`, Surface `#FFFFFF`, Background `#F7FAF7`, Text `#14241B`.
- **Sepia Theme (Parchment Paper)**: Primary `#8B5E3C`, Gold Accent `#B8860B`, Surface `#FBF7EE`, Background `#F6F0E0`, Text `#2C2215`.
- **Night Theme (Midnight Dark)**: Primary `#2E8B57`, Gold Accent `#E5C058`, Surface `#132219`, Background `#0A120E`, Text `#E9F1EC`.
- **Typography**: System sans-serif optimized for Urdu transliteration readability paired with traditional Arabic Naskh/Amiri styling for Arabic verses and hadith quotes.

---

## 3. Key Product Decisions & Trade-Offs

- **Decision 1: Modular ES6 JavaScript vs. Heavy Framework Bundle (React/Vue/Angular)**
  - *Chosen Approach*: Modern vanilla JavaScript with clean ES Modules (`import`/`export`), structured into Model-View-Presenter/Store layers.
  - *Why*: Eliminates `npm build` overhead, keeps the entire deployment footprint under 1 MB, loads instantly on 2G/3G mobile networks, and requires zero Node.js build configuration on static hosts like GitHub Pages.
- **Decision 2: Directory Separation (`/web` and `/public`)**
  - *Chosen Approach*: Place web application source files cleanly in `/web` (and serveable root `/public`) so static hosting platforms can point directly to the folder or root without interfering with Android Gradle files.
  - *Why*: Prevents pollution of Android application sources and guarantees clean maintenance.

---

## 4. Technical Architecture & Data Strategy

### System Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                      Web Browser Client                         │
│   (Mobile Safari, Chrome, Firefox, Edge, Desktop Browser)       │
└────────────────┬───────────────────────────────┬────────────────┘
                 │                               │
                 ▼                               ▼
┌─────────────────────────────────┐   ┌───────────────────────────┐
│        Service Worker           │   │    Web App Manifest       │
│  (Offline Caching & PWA Assets) │   │ (Install to Home Screen)  │
└────────────────┬────────────────┘   └───────────────────────────┘
                 │
                 ▼
┌─────────────────────────────────────────────────────────────────┐
│                     Presentation Layer                          │
│  ┌───────────────────────┐   ┌───────────────────────────────┐  │
│  │     HomeView.js       │   │         ReaderView.js         │  │
│  │ (Catalog, Search,     │   │ (Card transitions, Arabic box,│  │
│  │  Hero, Resume Card)   │   │  Urdu text, Takeaways, Dock)  │  │
│  └───────────────────────┘   └───────────────────────────────┘  │
│  ┌───────────────────────┐   ┌───────────────────────────────┐  │
│  │   SettingsModal.js    │   │      BookmarksModal.js        │  │
│  └───────────────────────┘   └───────────────────────────────┘  │
└────────────────┬───────────────────────────────┬────────────────┘
                 │                               │
                 ▼                               ▼
┌─────────────────────────────────────────────────────────────────┐
│                       State & Store                             │
│       StateStore.js (Observer Pattern / Pub-Sub Events)         │
│  - currentChapterId, currentPageIndex, theme, fontSize, etc.   │
└────────────────┬───────────────────────────────┬────────────────┘
                 │                               │
                 ▼                               ▼
┌─────────────────────────────────┐   ┌───────────────────────────┐
│         Data Layer              │   │     Storage Service       │
│  - seerahData.js (20 Chapters,  │   │  StorageService.js        │
│    60 Pages, Full Arabic/Urdu)  │   │  (localStorage sync,      │
│  - BookRepository.js            │   │   reading position &      │
│    (Lookup, Search, Navigation) │   │   bookmarks persistence)  │
└─────────────────────────────────┘   └───────────────────────────┘
```

### Component & File Structure (Self-Contained in `/web`):
1. `index.html`: Semantic, responsive shell with accessibility labels, PWA meta tags, and theme variables.
2. `styles.css`: Pure CSS design system implementing M3/Islamic color palettes, responsive typography, bottom docks, and page flip/slide transitions.
3. `manifest.json`: Web App Manifest for mobile installation with custom icons.
4. `sw.js`: Service worker providing seamless offline caching for all assets and data.
5. `js/data/seerahData.js`: Complete 20-chapter authentic dataset matching the Android repository.
6. `js/data/BookRepository.js`: Query engine supporting live search, chapter lookups, and boundary pagination.
7. `js/services/StorageService.js`: Robust localStorage manager for bookmarks, theme, font size, and progress.
8. `js/store/StateStore.js`: Reactive central state container triggering UI re-renders on state mutations.
9. `js/views/HomeView.js`: Renders hero header, resume reading card, search bar, and chapter cards.
10. `js/views/ReaderView.js`: Renders animated reading canvas, Arabic calligraphy cards, scalable Roman Urdu, and reader dock.
11. `js/views/Modals.js`: Settings and bookmarks dialogs.
12. `js/app.js`: Main application bootstrapper.
