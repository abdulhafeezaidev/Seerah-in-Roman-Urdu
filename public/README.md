# Ar-Raheeq Al-Makhtum - Web App (PWA)

This directory contains the complete, self-contained Progressive Web App (PWA) for *Ar-Raheeq Al-Makhtum (The Sealed Nectar)* in Roman Urdu with authentic Arabic calligraphy and an English reference toggle.

## How to Host This Web App:

This app requires **zero backend servers** and **no build step** (`npm install` or `npm run build` is NOT required). You can host it directly on any static web host:

### 1. GitHub Pages (1-Click Free Hosting)
1. Push this `/web` folder (or your repository) to GitHub.
2. In your repository on GitHub, go to **Settings** > **Pages**.
3. Under **Build and deployment**, select **Deploy from a branch**.
4. Choose your branch and select `/web` (or `/` if deploying from the web root).
5. Click **Save**. Your web app will be live at `https://<username>.github.io/<repo>/`!

### 2. Vercel
1. Run `npx vercel` inside the `web/` directory or connect your GitHub repository in the Vercel dashboard.
2. Set the **Root Directory** to `web` (or leave default if deploying `web` directly).
3. Click **Deploy**.

### 3. Netlify
1. Drag and drop the `web/` folder directly onto [app.netlify.com/drop](https://app.netlify.com/drop).
2. Your site is live immediately with SSL!

### 4. Cloudflare Pages / Firebase Hosting
Point the publish directory to `web/` and deploy.

---

## Features Included:
- **Clean Architecture**: Separated into Data, Repository, State Store, Services, and Views.
- **Offline Capable (PWA)**: Built-in Service Worker (`sw.js`) caches all assets and chapters for reading without an internet connection.
- **Installable**: Mobile users can tap "Add to Home Screen" to install it like a native app.
- **3 Visual Themes**: Emerald Day, Sepia Parchment Paper, and Midnight Dark mode.
- **Local Persistence**: Saves reading position and bookmarks automatically in browser `localStorage`.
- **Bilingual & Reverent**: Authentic Arabic verses and Ahadith with full Harakat, Roman Urdu translation, and toggleable English reference.
