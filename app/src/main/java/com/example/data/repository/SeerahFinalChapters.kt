package com.example.data.repository

import com.example.data.model.ArabicQuote
import com.example.data.model.BookPage
import com.example.data.model.SeerahChapter

object SeerahFinalChapters {
    val chapter17 = SeerahChapter(
        id = 17,
        titleUrdu = "Ghazwa-e-Hunain, Taif Aur Tabook",
        titleEnglish = "Hunain, Ta'if and the Expedition of Tabuk",
        era = "Madani Daur (8-9 Hijri)",
        summaryUrdu = "Hawazin aur Saqif ka hamla, Hunain me tadad par naaz aur ibtidaai larzish, Rasoolullah ﷺ ki bay-misaal sabat-qadmi, Ansar ke aansu aur dil-kush tasalli, aur shadeed garmi me Tabook ka azeem tareen aazmaishi safar.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Ghazwa-e-Hunain Aur Rasoolullah ﷺ Ki Sabat-Qadmi",
                titleEnglish = "Battle of Hunain and Steadfast Courage of the Prophet ﷺ",
                contentUrdu = "Shawwal 8 Hijri me Hawazin aur Saqif ke qabayil ne 20,000 ka lashkar jama kiya. Musalman 12,000 the aur unhe apni kasrat par naaz hua. Ghaati me dushman ke teer-andazon ne achanak teeron ki barish kar di jis se safon me bhagdarr mach gayi.\n\nIs sakht tareen lamhe me jab log peechay hat rahe the, Rasoolullah ﷺ apne safeed khachhar par akele dushman ki safon ki taraf barhte ja rahe the aur buland aawaz se pukaar rahe the: 'Ana an-Nabiyyu laa kazib, ana ibnu Abdil Muttalib!' (Mai sachha Nabi hoon jhoota nahi, mai Abdul Muttalib ka beta hoon!). Hazrat Abbas (R.A) ne buland aawaz se Sahaba ko pukaara to sab parwanon ki tarah wapis palte aur shandaar fatah naseeb hui.",
                contentEnglish = "In Shawwal 8 A.H., tribes of Hawazin and Thaqif ambushed the 12,000-strong Muslim army in the narrow defiles of Hunain, causing initial disarray. Amidst panic, the Prophet ﷺ remained completely fearless, spurring his white mule forward towards the enemy and proclaiming: 'I am the Prophet without falsehood; I am the son of Abdul-Muttalib!' Re rallying around him, the Muslims triumphed.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "أَنَا النَّبِيُّ لَا كَذِبْ ، أَنَا ابْنُ عَبْدِ الْمُطَّلِبْ",
                        romanUrduTranslation = "Ana an-Nabiyyu laa kazib, ana ibnu 'Abdil Muttalib.",
                        englishTranslation = "I am the Prophet in truth, no lie; I am the son of Abdul-Muttalib!",
                        reference = "Sahih al-Bukhari 2864"
                    ),
                    ArabicQuote(
                        arabicText = "وَيَوْمَ حُنَيْنٍ ۙ إِذْ أَعْجَبَتْكُمْ كَثْرَتُكُمْ فَلَمْ تُغْنِ عَنكُمْ شَيْئًا وَضَاقَتْ عَلَيْكُمُ الْأَرْضُ بِمَا رَحُبَتْ ثُمَّ وَلَّيْتُم مُّدْبِرِينَ ۝ ثُمَّ أَنزَلَ اللَّهُ سَكِينَتَهُ عَلَىٰ رَسُولِهِ وَعَلَى الْمُؤْمِنِينَ",
                        romanUrduTranslation = "Wa yawma Hunaynin iz a'jabatkum kasratukum falam tughni 'ankum shay'an wa daaqat 'alaykumul ardu bimaa rahubat summa wallaytum mudbireen. Summa anzalallaahu sakeenatahoo 'alaa Rasoolihee wa 'alal mu'mineen.",
                        englishTranslation = "And [remember] the day of Hunayn, when your great numbers pleased you, but they availed you not at all, and the earth was confined for you in spite of its vastness; then you turned back in flee. Then Allah sent down His tranquility upon His Messenger and upon the believers.",
                        reference = "Surah At-Tawbah 9:25-26"
                    )
                ),
                reflectionUrdu = "Kisi bhi maidan me tadad ya asbaab par ghurur nahi karna chahiye; asal fatah Allah ki madad aur kamil yaqeen se aati hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Maal-e-Ghaneemat Aur Ansar Ke Aansu",
                titleEnglish = "Spoils of War and Tender Weeping of the Ansar",
                contentUrdu = "Hunain ke baad Rasoolullah ﷺ ne dilon ko jodne ke liye No-Muslim Makki sardaron ko bohot sa maal-e-ghaneemat aur oont ataa farmaye, jabke Ansar ko kuch na mila. Ansar ke jawan dilon me thori khalish paida hui.\n\nRasoolullah ﷺ ne tamam Ansar ko ek kheemay me jama kiya aur aisa riqqat-aamez khutba diya jis par Ansar ro pare. Aap ﷺ ne farmaya: 'Ay Ansar! Kya tum is baat par raazi nahi ke log bakrian aur oont le kar apne gharon ko jayen, aur tum apne gharon ko Allah ke Rasool ﷺ ko le kar jao?!' Ansar daariyan bhigho kar ro pare aur bole: 'Hum Allah aur Uske Rasool ﷺ par raazi hain!'",
                contentEnglish = "Following Hunain, the Prophet ﷺ gifted large spoils to newly converted Makkan leaders to reconcile their hearts, allocating nothing material to the Ansar. Sensing youthful Ansar dismay, the Prophet ﷺ gathered them and said: 'O Ansar, are you not pleased that people return with sheep and camels, while you return home accompanied by the Messenger of Allah ﷺ?' The Ansar wept profusely until their beards were soaked, voicing unreserved content.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "أَلَا تَرْضَوْنَ أَنْ يَذْهَبَ النَّاسُ بِالشَّاةِ وَالْبَعِيرِ ، وَتَرْجِعُونَ بِرَسُولِ اللَّهِ إِلَى رِحَالِكُمْ ؟",
                        romanUrduTranslation = "Alaa tardawna an yazhaban-naasu bish-shaati wal-ba'eer, wa tarji'oona bi-Rasoolillaahi ilaa rihaalikum?",
                        englishTranslation = "Are you not satisfied that people walk away with sheep and camels, while you return to your dwellings with the Messenger of Allah?",
                        reference = "Sahih al-Bukhari 4330"
                    )
                ),
                reflectionUrdu = "Dunya ki daulat faani hai, jabke Rasoolullah ﷺ ki qurbat aur mohabbat hi haqeeqi daulat aur azeem tareen inaam hai."
            ),
            BookPage(
                pageNumber = 3,
                titleUrdu = "Ghazwa-e-Tabook: Aazmaish Ka Safar",
                titleEnglish = "The Expedition of Tabuk: Trial of Faith",
                contentUrdu = "Rajab 9 Hijri me Rumi (Byzantine) lashkar ke hamlay ki ittela par Rasoolullah ﷺ ne shadeed garmi aur qahat-saali ke bawajood 30,000 Sahaba ke sath Tabook ka rukh farmaya. Yeh 'Jaish-ul-Usrah' (tang-dasti ka lashkar) kehlaya.\n\nHazrat Usman (R.A) ne lashkar ka ek tihai hissa khud sponsor kiya, 300 oont aur 1,000 deenar paish kiye. Hazrat Abu Bakr Siddiq (R.A) ne ghar ka sara saman la kar paish kar diya. Musalmano ki jurrat dekh kar Rumi lashkar pehle hi maidan chor kar bhag gaya aur bila larayi shandar siyasi aur fauji dabdaba qayam hua.",
                contentEnglish = "In Rajab 9 A.H., amid scorching summer heat and famine, the Prophet ﷺ prepared the 30,000-strong Expedition of Tabuk ('Jaish al-Usrah') against Byzantine Roman threats. Uthman (R.A) equipped a third of the army with 300 camels and 1,000 gold dinars; Abu Bakr (R.A) donated all his household possessions. Overawed by Muslim resolve, Roman legions dispersed without a battle.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "لَّقَد تَّابَ اللَّهُ عَلَى النَّبِيِّ وَالْمُهَاجِرِينَ وَالْأَنصَارِ الَّذِينَ اتَّبَعُوهُ فِي سَاعَةِ الْعُسْرَةِ",
                        romanUrduTranslation = "Laqad taaballaahu 'alan Nabiyyi wal Muhaajireena wal Ansaarilladheenat-taba'oohu fee saa'atil 'usrah.",
                        englishTranslation = "Allah has already forgiven the Prophet and the Emigrants and the Ansar who followed him in the hour of difficulty.",
                        reference = "Surah At-Tawbah 9:117"
                    )
                ),
                reflectionUrdu = "Deen-e-Haq ki khatir apne aaraam aur maali mafaad ko qurban karna hi ashaab-e-imaan ka tareeqa hai."
            )
        )
    )

    val chapter18 = SeerahChapter(
        id = 18,
        titleUrdu = "Hajjat-ul-Wada' (The Farewell Pilgrimage)",
        titleEnglish = "The Farewell Pilgrimage and Universal Charter",
        era = "Madani Daur (10 Hijri)",
        summaryUrdu = "Zul-Hijjah 10 Hijri me Rasoolullah ﷺ ka aakhri Hajj, 124,000 se zayd Sahaba ka ijtima, Maidan-e-Arafat me insani huqooq ka azeem aalmi dastoor, rang o nasal ki bartaari ka khatma, aur deen ki takmeel ka ailaan.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "124,000 Sahaba Ke Sath Hajj Ka Safar",
                titleEnglish = "Pilgrimage with 124,000 Devoted Companions",
                contentUrdu = "Zul-Qadah 10 Hijri ke aakhir me Rasoolullah ﷺ ne Hajj ka ailaan farmaya. Poore Jazeerat-ul-Arab se musalman parwanon ki tarah Madinah umand aaye. 124,000 se zayd Sahaba-e-Kiram Aap ﷺ ki qiyadat me safar-e-Hajj par rawana hue.\n\nZul-Hulaifah me ihram baandha aur 'Labbaik Allahumma Labbaik, Labbaika laa shareeka laka labbaik' ki aawazon se fazayein goonj utheen. Aap ﷺ ne Hajj ke tamam manasik khud amalan kar ke sikhaye aur farmaya: 'Mujh se apne Hajj ke manasik seekh lo, shayad mai is saal ke baad tum se na mil sakoon.'",
                contentEnglish = "In Dhul-Qi'dah 10 A.H., the Prophet ﷺ announced his solitary pilgrimage. Over 124,000 companions gathered from every corner of Arabia. At Dhul-Hulaifah, the vast assembly donned the white Ihram, filling valleys with thunderous Talbiyah chants. The Prophet ﷺ instructed them carefully: 'Learn your pilgrimage rites from me, for I do not know if I will meet you after this year.'",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ ، لَا شَرِيكَ لَكَ",
                        romanUrduTranslation = "Labbaik Allaahumma Labbaik, Labbaika laa shareeka laka Labbaik. Innal hamda wan-ni'mata laka wal mulk, laa shareeka lak.",
                        englishTranslation = "Here I am, O Allah, here I am. Here I am, You have no partner, here I am. Verily all praise, blessings, and sovereignty belong to You. You have no partner.",
                        reference = "Sahih Muslim 1184"
                    )
                ),
                reflectionUrdu = "Hajj tamam musalmano ke darmiyan rang, nasal aur daulat ke faraq ko mita kar ek bhai-chara qayam karta hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Khutba Hajjat-ul-Wada': Insani Huqooq Ka Manshoor",
                titleEnglish = "The Farewell Sermon: Charter of Human Equality and Rights",
                contentUrdu = "9 Zul-Hijjah 10 Hijri ko Jabal-e-Rehmat (Arafat) par Rasoolullah ﷺ apni oontni Qaswa par sawaar hue aur tareekh-e-insaniyat ka sab se azeem khutba irshad farmaya:\n\n'Ay logo! Meri baat suno! Kisi gore ko kisi kale par aur kisi kale ko kisi gore par, kisi arabi ko kisi ajami par koi fazeelat nahi magar taqwa ke zariye! Tumhara khoon, tumhara maal aur tumhari aabroo ek dusre par aisi hi haraam hai jaise aaj ka yeh din aur yeh shehar mohtaram hai! Auraton ke baare me Allah se daro! Sood ke tamam mutalibaat mere paon ke neeche hain!'",
                contentEnglish = "On 9th Dhul-Hijjah at Mount Arafat, atop Al-Qaswa, the Prophet ﷺ delivered the landmark Farewell Sermon: declaring absolute racial equality ('An Arab has no superiority over a non-Arab, nor a white over a black, except by piety'), sanctifying human life, property, and honor, abolishing usury/interest completely, and championing the sacred rights and dignity of women.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "أَلَا لَا فَضْلَ لِعَرَبِيٍّ عَلَى عَجَمِيٍّ ، وَلَا لِعَجَمِيٍّ عَلَى عَرَبِيٍّ ، وَلَا لِأَحْمَرَ عَلَى أَسْوَدَ ، وَلَا أَسْوَدَ عَلَى أَحْمَرَ إِلَّا بِالتَّقْوَى",
                        romanUrduTranslation = "Alaa laa fadla li-'arabiyyin 'alaa 'ajamiyyin, wa laa li-'ajamiyyin 'alaa 'arabiyyin, wa laa li-ahmara 'alaa aswada, wa laa aswada 'alaa ahmara illaa bit-taqwaa.",
                        englishTranslation = "Verily there is no superiority of an Arab over a non-Arab, nor of a non-Arab over an Arab, nor of a white over a black, nor of a black over a white, except through piety and God-consciousness.",
                        reference = "Musnad Ahmad 23489"
                    )
                ),
                reflectionUrdu = "Islam ne 1400 saal pehle insani masawat (equality) aur huqooq-e-niswan ka wo nizam diya jo dunya ka koi qanoon nahi de saka."
            ),
            BookPage(
                pageNumber = 3,
                titleUrdu = "Gawahi Aur Deen Ki Takmeel",
                titleEnglish = "Divine Witness and Perfection of Islam",
                contentUrdu = "Khutba ke aakhir me Rasoolullah ﷺ ne majma-e-aam se pucha: 'Ay logo! Qayamat ke din Allah tum se mere baare me puchega, to tum kya jawab doge?'\n\n124,000 se zayd logon ne yak-zaban ho kar kaha: 'Hum gawahi dete hain ke Aap ﷺ ne deen ki amanat pohcha di, risalat ka haq ada kar diya aur ummat ki kamil khair-khwahi farmai!' Yeh sun kar Aap ﷺ ne apni shahadat ki ungli aasmaan ki taraf uthai aur farmaya: 'Allahumma ishhad! Allahumma ishhad! Allahumma ishhad!' (Ay Allah gawah rehna!). Is roz Allah ne Quran ki aakhri ahem aayat nazil farmai jis me deen ke mukammal hone ka ailaan kiya gaya.",
                contentEnglish = "The Prophet ﷺ asked the multitude: 'When questioned about me before Allah on Judgment Day, what will you testify?' The crowd roared in unison: 'We bear witness that you have faithfully conveyed the message, fulfilled the trust, and counseled the community with sincere love!' Raising his index finger to the sky, he prayed: 'O Allah, bear witness! O Allah, bear witness!' Thereupon was revealed the verse of Deen's completion.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "الْيَوْمَ أَكْمَلْتُ لَكُمْ دِينَكُمْ وَأَتْمَمْتُ عَلَيْكُمْ نِعْمَتِي وَرَضِيتُ لَكُمُ الْإِسْلَامَ دِينًا",
                        romanUrduTranslation = "Al-yawma akmaltu lakum deenakum wa atmamtu 'alaykum ni'matee wa radeetu lakumul Islaama deenaa.",
                        englishTranslation = "This day I have perfected for you your religion and completed My favor upon you and have approved for you Islam as your religion.",
                        reference = "Surah Al-Ma'idah 5:3"
                    )
                ),
                reflectionUrdu = "Deen-e-Islam ab qayamat tak ke liye mukammal hai; is me kisi kami-beshi ki gunjaish nahi."
            )
        )
    )

    val chapter19 = SeerahChapter(
        id = 19,
        titleUrdu = "Wisaal-e-Nabwi ﷺ Aur Madinah Ka Gham",
        titleEnglish = "The Passing of the Prophet ﷺ and Medina in Mourning",
        era = "Madani Daur (11 Hijri)",
        summaryUrdu = "Aakhri ayaam aur bimaari, Hazrat Aisha (R.A) ke hujray me qayam, Hazrat Abu Bakr (R.A) ko imamat ka hukm, aakhri naseehat (Namaz aur Ghulamon ka khayal), 'Ar-Rafeeq Al-A'la', Sahaba par azeem gham aur Hazrat Abu Bakr (R.A) ka tareekhi khutba.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Maraz-e-Wafat Aur Aakhri Naseehatein",
                titleEnglish = "Final Illness and Parting Counsels",
                contentUrdu = "Safar 11 Hijri ke aakhir me Rasoolullah ﷺ ko shadeed bukhar shuru hua. Aap ﷺ ne tamam azwaj-e-mutahharat ki ijazat se Hazrat Aisha (R.A) ke hujray me qayam farmaya. Shadeed maraz ke bawajood Aap ﷺ ne farmaya: 'Abu Bakr se kaho ke wo logon ko namaz parhayein.'\n\nApni zindagi ke aakhri lamhaat tak Aap ﷺ ki zabaan-e-aqdas par bar bar yeh naseehat thi: 'As-Salaah! As-Salaah! Wa maa malakat aimaanukum!' (Namaz ka khayal rakhna aur apne matahato/ghulamon ke huqooq ka khayal rakhna!). Aap ﷺ ne dunya chorne se pehle apne paas bache hue aakhri 6 ya 7 deenar bhi sadqa karwa diye.",
                contentEnglish = "In late Safar 11 A.H., severe illness and fever gripped the Prophet ﷺ. With the gracious consent of all his wives, he resided in Aisha's (R.A) chamber. When unable to lead the congregation, he commanded: 'Tell Abu Bakr to lead the people in prayer.' His repeated dying counsel was: 'The prayer, the prayer, and treat kindly those whom your right hands possess!' He distributed every last dinar in charity before passing.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "الصَّلَاةَ الصَّلَاةَ وَمَا مَلَكَتْ أَيْمَانُكُمْ",
                        romanUrduTranslation = "As-Salaata as-Salaata wa maa malakat aimaanukum.",
                        englishTranslation = "Guard the prayer, guard the prayer, and fear Allah concerning those whom your right hands possess!",
                        reference = "Sunan Ibn Majah 2698"
                    )
                ),
                reflectionUrdu = "Namaz aur kamzoron ke huqooq ki adaigi Rasoolullah ﷺ ki aakhri waseeyat aur deen ki rooh hain."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Wisaal-e-Mubarak: 'Bal Ar-Rafeeq Al-A'la'",
                titleEnglish = "The Blessed Departure: 'Rather, the Most High Companion'",
                contentUrdu = "Peer ka din, 12 Rabi-ul-Awwal 11 Hijri ko subah ke waqt Rasoolullah ﷺ ne hujray ka parda utha kar dekha to Sahaba Abu Bakr (R.A) ke peechay namaz parh rahe the. Aap ﷺ ka chehra-e-aqdas roshan chaand ki tarah chamak raha tha aur muskurahat dekh kar Sahaba khushi se be-qaboo hone lage. Yeh Aap ﷺ ki aakhri deedar thi.\n\nDopahar ke waqt Hazrat Aisha (R.A) ki god me sar-e-mubarak tha. Aap ﷺ ne miswaak farmai, phir apni ungli aasmaan ki taraf uthai aur aakhri alfaaz ada farmaye: 'Bal ar-Rafeeqal A'la!' (Balki sab se aala aur buland Rafeeq — Allah ki qurbat!). Is ke sath hi rooh-e-aqdas apne Khaliq-e-Haqeeqi se ja mili. Inna lillahi wa inna ilayhi raji'oon.",
                contentEnglish = "On Monday, 12th Rabi-ul-Awwal 11 A.H., the Prophet ﷺ gently parted the curtain of his room, gazing upon companions standing in rows behind Abu Bakr (R.A). His blessed countenance shone like a page of the Quran, smiling peacefully. By midday, resting his head upon Aisha's (R.A) lap, he used the Miswak, raised his finger upwards, and whispered his final words: 'Rather, the Most High Companion (in Paradise)!' His noble soul departed to its Creator.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "مَعَ الَّذِينَ أَنْعَمَ اللَّهُ عَلَيْهِم مِّنَ النَّبِيِّينَ وَالصِّدِّيقِينَ وَالشُّهَدَاءِ وَالصَّالِحِينَ ۚ بَلِ الرَّفِيقَ الْأَعْلَى",
                        romanUrduTranslation = "Ma'alladheena an'amallaahu 'alayhim minan-nabiyyeena was-siddeeqeena wash-shuhadaa'i was-saaliheen. Balir-Rafeeqal A'laa.",
                        englishTranslation = "With those upon whom Allah has bestowed favor: the prophets, the truthful, the martyrs and the righteous. Rather, the Most High Companion!",
                        reference = "Sahih al-Bukhari 4440"
                    )
                ),
                reflectionUrdu = "Dunya kisi ke liye daimi nahi; maut barhaq hai aur azeem tareen rooh bhi apne Maula ki qurbat ko muntakhib karti hai."
            ),
            BookPage(
                pageNumber = 3,
                titleUrdu = "Madinah Ka Gham Aur Hazrat Abu Bakr (R.A) Ka Khutba",
                titleEnglish = "Grief of Medina and Historic Address of Abu Bakr (R.A)",
                contentUrdu = "Wisaal ki khabar sun kar Madinah par tareeki chha gayi aur Sahaba shadeed sadmay se nidhaal ho gaye. Hazrat Umar Farooq (R.A) gham ki shiddat se talwaar le kar kharay ho gaye aur kaha ke jo kahega Rasoolullah ﷺ inteqaal kar gaye mai uski gardan maar dunga!\n\nHazrat Abu Bakr Siddiq (R.A) tashreef laye, Aap ﷺ ke chehra-e-anwar ka bosa liya aur farmaya: 'Aap zindagi me bhi pakeeza the aur wisal ke baad bhi pakeeza hain.' Phir bahar aakar wo tareekhi azeem khutba diya jis ne sab ko sambhala: 'Suno! Jo shakhs Muhammad ﷺ ki ibadat karta tha to jaan le ke Muhammad ﷺ wisal farma chuke hain, aur jo Allah ki ibadat karta hai to Allah zinda hai use kabhi maut nahi!'",
                contentEnglish = "Grief overwhelmed Medina. Paralyzed by shock, Umar (R.A) brandished his sword declaring the Prophet ﷺ was not dead. Abu Bakr (R.A) entered, tenderly kissed the Prophet's forehead, weeping: 'How pure you were in life and in death.' He addressed the bewildered Sahaba: 'Whoever worshipped Muhammad, let him know that Muhammad has passed away; but whoever worships Allah, let him know that Allah is Ever-Living and does not die!'",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "وَمَا مُحَمَّدٌ إِلَّا رَسُولٌ قَدْ خَلَتْ مِن قَبْلِهِ الرُّسُلُ ۚ أَفَإِن مَّاتَ أَوْ قُتِلَ انقَلَبْتُمْ عَلَىٰ أَعْقَابِكُمْ",
                        romanUrduTranslation = "Wa maa Muhammadun illaa Rasoolun qad khalat min qablihir-rusul, afa'im-maata aw qutilan-qalabtum 'alaa a'qaabikum.",
                        englishTranslation = "Muhammad is not but a messenger. [Other] messengers have passed away before him. So if he was to die or be killed, would you turn back on your heels?",
                        reference = "Surah Ali 'Imran 3:144"
                    )
                ),
                reflectionUrdu = "Rasoolullah ﷺ ka jism-e-aqdas parda farma gaya magar Aap ﷺ ka laya hua deen aur sunnat qayamat tak zinda-o-painda hai."
            )
        )
    )

    val chapter20 = SeerahChapter(
        id = 20,
        titleUrdu = "Shamail-e-Nabwi ﷺ: Husn-e-Akhlaq Aur Soorat",
        titleEnglish = "The Noble Attributes and Sublime Character",
        era = "Khasaais-o-Shamail",
        summaryUrdu = "Rasool-e-Karam ﷺ ka haseen jism-e-aqdas, Umm Ma'bad aur Hazrat Ali (R.A) ki bayan karda soorat-e-mubarka, be-misaal sakhaawat, rehm-o-karam, ghareebon aur yatimon se ulfat, aur bacho par shafqat.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Soorat-e-Mubarka: Chehra-e-Aqdas Ka Husn",
                titleEnglish = "The Radiant Appearance of the Prophet ﷺ",
                contentUrdu = "Sahaba-e-Kiram farmate hain ke Rasoolullah ﷺ tamam insano me sab se zyada haseen aur khoob-roo the. Chehra-e-aqdas chaudveen raat ke chaand ki tarah chamakta tha. Aankhein bari aur siah theen jin me qudrati surkhi ki barik lakeerein theen.\n\n Hazrat Ali (R.A) farmate hain: 'Aap ﷺ na bohot lambe the aur na chhotay qad ke, balki miyana-qad the. Zulfein kano ki low tak aati theen. Paseena-e-mubarak motiyon ki tarah chamakta tha aur mushk-o-amber se zyada khushboodar tha. Jis gali se Aap ﷺ guzar jate the wo rasta khushboo se mehak uthta tha.'",
                contentEnglish = "Companions describe the Prophet ﷺ as the most radiant and majestic of human beings. His face shone brighter than the full moon; his eyes were large, dark, and naturally kohled; his complexion was luminous white tinted with rosy hue. Ali (R.A) recorded that he was neither excessively tall nor short, with hair touching his earlobes and perspiration that smelled sweeter than musk and amber.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "كَانَ رَسُولُ اللَّهِ ﷺ أَحْسَنَ النَّاسِ وَجْهًا وَأَحْسَنَهُمْ خَلْقًا ، لَيْسَ بِالطَّوِيلِ الْبَائِنِ ، وَلَا بِالْقَصِيرِ",
                        romanUrduTranslation = "Kaana Rasoolullaahi ﷺ ahsanan-naasi wajhan wa ahsanahum khalqan, laysa bit-taweelil baa'ini wa laa bil-qaseer.",
                        englishTranslation = "The Messenger of Allah ﷺ had the most handsome face and the most perfect constitution; he was neither excessively tall nor short.",
                        reference = "Sahih al-Bukhari 3549"
                    )
                ),
                reflectionUrdu = "Allah Ta'ala ne Rasoolullah ﷺ ko soorat aur seerat dono me kamal-e-husn aur be-misaal jalal ataa farmaya tha."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Husn-e-Akhlaq: 'Wa Innaka La'alaa Khuluqin 'Azeem'",
                titleEnglish = "Sublime Moral Character: The Living Quran",
                contentUrdu = "Quran-e-Majeed ne Aap ﷺ ke akhlaq ko 'Khuluq-e-Azeem' qarar diya. Hazrat Aisha (R.A) se jab Aap ﷺ ke akhlaq ke baare me pucha gaya to unhone farmaya: 'Kya tumne Quran nahi parha? Aap ﷺ ka akhlaq to saara Quran hi tha!'\n\nHazrat Anas (R.A) farmate hain ke mai ne 10 saal tak Rasoolullah ﷺ ki khidmat ki, magar Aap ﷺ ne kabhi mujhe 'Uff' tak nahi farmaya, aur na kabhi yeh pucha ke tum ne yeh kaam kyun kiya ya kyun nahi kiya! Aap ﷺ hamesha muskurate rehte the aur salam me pehal farmate the.",
                contentEnglish = "The Quran declared his character as supreme ('And indeed, you are of a great moral character'). When Aisha (R.A) was asked about his temperament, she answered: 'His character was the Quran.' Anas ibn Malik (R.A) stated: 'I served the Prophet ﷺ for ten years, and he never once said 'Uff' (an expression of irritation) to me, nor rebuked me for doing or omitting anything.' He was constantly smiling and humble.",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "وَإِنَّكَ لَعَلَىٰ خُلُقٍ عَظِيمٍ",
                        romanUrduTranslation = "Wa innaka la'alaa khuluqin 'azeem.",
                        englishTranslation = "And indeed, you are of a great moral character.",
                        reference = "Surah Al-Qalam 68:4"
                    ),
                    ArabicQuote(
                        arabicText = "كَانَ خُلُقُهُ الْقُرْآنَ",
                        romanUrduTranslation = "Kaana khuluquhul Qur'aan.",
                        englishTranslation = "His character was the Quran.",
                        reference = "Sahih Muslim 746"
                    )
                ),
                reflectionUrdu = "Haqeeqi musalman wo hai jo Rasoolullah ﷺ ke akhlaq, narmi aur kirdar ko apni rozmarrah zindagi ka hissa banaye."
            ),
            BookPage(
                pageNumber = 3,
                titleUrdu = "Be-Misaal Sakhaawat Aur Shafqat-e-Nabwi ﷺ",
                titleEnglish = "Unmatched Generosity and Universal Compassion",
                contentUrdu = "Rasoolullah ﷺ tamam insano me sab se zyada sakhi the. Ramadan-ul-Mubarak me to Aap ﷺ tez chalne wali hawa se bhi zyada sakhaawat farmate the. Jo koi bhi Aap ﷺ se mangta, Aap ﷺ use kabhi inkaar na farmate.\n\nAap ﷺ yatimon, bewaon aur ghareebon ke sar par shafqat ka haath rakhte the. Bachon se be-panah mohabbat farmate; unhe god me uthate aur bosa dete. Janwaron par bhi hadd se zyada bojh laadne se mana farmate. Aap ﷺ farmate the: 'Rehm karne walon par Rahman rehm farmata hai; zameen walon par rehm karo, aasmaan wala tum par rehm karega!'",
                contentEnglish = "The Prophet ﷺ was the most generous of all men, especially in Ramadan when his charity was swifter than the blowing wind. He never refused anyone who asked. He held orphans and widows in utmost compassion, cradled and kissed children, and strictly forbade cruelty or overburdening animals. He stated: 'The Merciful has mercy upon the merciful. Have mercy upon those on earth, and the One in heaven will have mercy upon you.'",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "الرَّاحِمُونَ يَرْحَمُهُمُ الرَّحْمَٰنُ ، ارْحَمُوا مَنْ فِي الْأَرْضِ يَرْحَمْكُمْ مَنْ فِي السَّمَاءِ",
                        romanUrduTranslation = "Ar-raahimoona yarhamuhumur-Rahmaan. Irhamoo man fil-ardi yarhamkum man fis-samaa'.",
                        englishTranslation = "The merciful will be shown mercy by the Most Merciful. Show mercy to those on the earth, and the One in the heavens will show mercy to you.",
                        reference = "Sunan at-Tirmidhi 1924"
                    )
                ),
                reflectionUrdu = "Islam ka paigham mohabbat, aman, insaniyat aur har makhlooq ke sath rehm-o-karam ka paigham hai."
            )
        )
    )
}
