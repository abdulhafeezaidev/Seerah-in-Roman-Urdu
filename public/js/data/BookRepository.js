import { SEERAH_CHAPTERS } from './seerahData.js';

export const BookRepository = {
  getAllChapters() {
    return SEERAH_CHAPTERS;
  },

  getChapter(id) {
    const numId = parseInt(id, 10);
    return SEERAH_CHAPTERS.find(c => c.id === numId) || null;
  },

  getNextChapter(currentId) {
    const nextId = parseInt(currentId, 10) + 1;
    return SEERAH_CHAPTERS.find(c => c.id === nextId) || null;
  },

  getPreviousChapter(currentId) {
    const prevId = parseInt(currentId, 10) - 1;
    return SEERAH_CHAPTERS.find(c => c.id === prevId) || null;
  },

  search(query) {
    const q = (query || '').trim().toLowerCase();
    if (!q) return [];

    const results = [];
    for (const chapter of SEERAH_CHAPTERS) {
      const chapterMatches =
        chapter.titleUrdu.toLowerCase().includes(q) ||
        chapter.titleEnglish.toLowerCase().includes(q) ||
        chapter.summaryUrdu.toLowerCase().includes(q);

      chapter.pages.forEach((page, pageIndex) => {
        const matchesHeading = page.titleUrdu.toLowerCase().includes(q);
        const matchesUrdu = page.contentUrdu.toLowerCase().includes(q);
        const matchesEnglish = page.contentEnglish.toLowerCase().includes(q);
        const matchesTakeaway = page.reflectionUrdu.toLowerCase().includes(q);
        const matchesArabic = page.arabicQuotes.some(
          quote =>
            quote.arabicText.includes(q) ||
            quote.romanUrduTranslation.toLowerCase().includes(q) ||
            quote.englishTranslation.toLowerCase().includes(q)
        );

        if (chapterMatches || matchesHeading || matchesUrdu || matchesEnglish || matchesTakeaway || matchesArabic) {
          let snippet = page.titleUrdu;
          if (matchesUrdu) {
            const idx = page.contentUrdu.toLowerCase().indexOf(q);
            const start = Math.max(0, idx - 40);
            const end = Math.min(page.contentUrdu.length, idx + q.length + 60);
            snippet = '...' + page.contentUrdu.substring(start, end).replace(/\n/g, ' ') + '...';
          } else if (matchesEnglish) {
            const idx = page.contentEnglish.toLowerCase().indexOf(q);
            const start = Math.max(0, idx - 40);
            const end = Math.min(page.contentEnglish.length, idx + q.length + 60);
            snippet = '...' + page.contentEnglish.substring(start, end).replace(/\n/g, ' ') + '...';
          }

          results.push({
            chapter,
            page,
            pageIndex,
            snippet
          });
        }
      });
    }

    return results;
  },

  getTotalPagesCount() {
    return SEERAH_CHAPTERS.reduce((sum, ch) => sum + ch.pages.length, 0);
  }
};
