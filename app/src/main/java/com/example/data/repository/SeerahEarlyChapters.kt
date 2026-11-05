package com.example.data.repository

import com.example.data.model.ArabicQuote
import com.example.data.model.BookPage
import com.example.data.model.SeerahChapter

object SeerahEarlyChapters {

    val chapter1 = SeerahChapter(
        id = 1,
        titleUrdu = "Arab Qabail Aur Jahiliyat Ka Daur",
        titleEnglish = "Location & Nature of Arab Tribes",
        era = "Makki Daur",
        summaryUrdu = "Jazeerat-ul-Arab ki geographi ahmiyat, Arab ke qadeem qabail aur Islam se pehle unka deeni o muashrati haal.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Jazeerat-ul-Arab Aur Qadeem Arab Qabail",
                titleEnglish = "Geography & Origin of Arab Tribes",
                contentUrdu = """Lafzi aitbaar se 'Arab' ke maani sehra, bayabaan aur be-aab-o-giyah zameen ke hain. Tareekh ke aaghaz se hi is khittay aur iske bashindon ko Arab kaha gaya. Jazeerat-ul-Arab maghrib mein Behra-e-Ahmar (Red Sea), mashriq mein Khaleej-e-Fars (Arabian Gulf), junoob mein Behra-e-Arab aur shumaal mein shaam o Iraq se ghira hua hai.

Tareekh-daano ne Arab aqwaam ko teen hisson mein taqseem kiya hai:
1. Arab-e-Baa'ida (Perishing Arabs): Woh qadeem qabail jin ki tafseelaat tareekh mein mehfooz na reh sakeen, jaisay Qaum-e-Aad, Samood, Tasam aur Jadis.
2. Arab-e-Aariba (Pure Arabs): Yeh Qahtan ki aulaad hain jo asal mein Yemen mein aabaad hue. In mein do mashhoor qabail Himyar aur Kahlan thay.
3. Arab-e-Musta'riba (Arabized Arabs): Yeh Hazrat Ismail (Alaihis Salam) ki aulaad se hain, jinhein Adnani Arab bhi kaha jata hai.

Hazrat Ibrahim (Alaihis Salam) Iraq se hijrat farma kar Shaam aur Palestine tashreef le gaye. Phir Allah Ta'ala ke hukum se Hazrat Hajra aur sheerdkhwaar bachay Hazrat Ismail (Alaihis Salam) ko Makkah ki be-aab-o-giyah wadi mein chhorr aaye, jahan Allah ke fazl se Aab-e-Zamzam ka chashma jari hua aur Qabeela-e-Jurhum aabaad hua.""",
                contentEnglish = """Linguistically, the word 'Arab' means deserts and waste barren land well-nigh waterless and treeless. The Arabian Peninsula has always maintained great geopolitical importance. Historians divide Arabs into three groups: Perishing Arabs ('Ad, Thamud), Pure Arabs (Qahtanian from Yemen), and Arabized Arabs (descendants of Ishmael, Adnanian Arabs). Prophet Ibrahim brought Hagar and infant Ishmael to the barren valley of Makkah by Allah's command, where the Zamzam spring miraculously gushed forth.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "رَّبَّنَا إِنِّي أَسْكَنتُ مِن ذُرِّيَّتِي بِوَادٍ غَيْرِ ذِي زَرْعٍ عِندَ بَيْتِكَ الْمُحَرَّمِ",
                        romanUrduTranslation = "Aye hamare Rab! Maine apni aulaad ko tere ba-hurmat ghar ke paas ek be-aab-o-giyah wadi mein laa basaya hai.",
                        englishTranslation = "O our Lord! I have made some of my offspring to dwell in an uncultivable valley by Your Sacred House.",
                        reference = "Surah Ibrahim 14:37"
                    )
                ),
                reflectionUrdu = "Allah Ta'ala par kaamil bharosa aur tawakkul har aazmaish ko aasaan bana deta hai, jaisay Hazrat Hajra aur Hazrat Ismail (A.S) ke liye Zamzam jaari hua."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Deen-e-Ibrahimi se But-Parasti Tak",
                titleEnglish = "From Monotheism to Idolatry",
                contentUrdu = """Shuru mein ahle Arab Hazrat Ismail (Alaihis Salam) ki taleemat par qayam thay aur Allah Wahda-hu La Sharika Lahu ki ibadat karte thay. Lekin waqt guzarne ke sath sath woh asal taleemat bhool gaye.

Phir Qabeela Khuza'a ka sardaar 'Amr bin Luhai', jo apnay qabeelay mein deendaar aur mukhlis samjha jata tha, Shaam ke safar par gaya. Wahan usne logon ko buton ki pooja karte dekha. Chunkay Shaam ambiya aur aasmaani kitabon ki sar-zameen thi, usne gumaan kiya ke yeh tareeqa durust hoga. Woh wahan se 'Hubal' naam ka but laaya aur usay Khana-e-Kaba ke darmiyan nasab kar diya aur logon ko uski pooja ki dawat di.

Dekhte hi dekhte shirk aur but-parasti Makkah aur pooray Hijaz mein phail gayi. Har qabeelay aur ghar ka apna but ban gaya. Koh-e-Taif par 'Laat', Nakhlah mein 'Uzza', aur Qadid ke paas 'Manaat' ki pooja shuru ho gayi. Fath-e-Makkah ke waqt Khana-e-Kaba ke gird 360 but nasab thay jinhein Rasoolullah ﷺ ne tod kar phenk diya.""",
                contentEnglish = """Most Arabs originally professed monotheism following Ishmael (pbuh). Later, 'Amr bin Luhai, a chieftain of Khuza'a, brought the idol Hubal from Syria and placed it in the Ka'bah. Soon, paganism engulfed Arabia with major idols including Manat, Al-Lat, and Al-'Uzza, reaching 360 idols around the Ka'bah before the Conquest of Makkah.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "وَقُلْ جَاءَ الْحَقُّ وَزَهَقَ الْبَاطِلُ إِنَّ الْبَاطِلَ كَانَ زَهُوقًا",
                        romanUrduTranslation = "Aur ailaan kar dijiye ke Haq aa gaya aur baatil nest-o-nabood ho gaya; beshak baatil nest hone ke liye hi tha.",
                        englishTranslation = "And say: Truth has come and falsehood has vanished. Surely falsehood is ever bound to vanish.",
                        reference = "Surah Al-Isra 17:81"
                    )
                ),
                reflectionUrdu = "Biddat aur rasm-o-riwaj shuru mein choti lagti hain lekin aahista aahista deen-e-haq ki buniyadon ko mutasir karti hain."
            )
        )
    )

    val chapter2 = SeerahChapter(
        id = 2,
        titleUrdu = "Wiladat-e-Bas'aadat Aur Bachpan",
        titleEnglish = "Prophet's Birth & Childhood",
        era = "Makki Daur",
        summaryUrdu = "Sayyid-ul-Mursaleen Hazrat Muhammad ﷺ ki wiladat, Halima Saadia (R.A) ki dastaane barkat, Shaq-e-Sadr aur walidain ki wafaat.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Noor-e-Nabuwwat Ka Zahoor",
                titleEnglish = "The Blessed Dawn",
                contentUrdu = """Sayyid-ul-Ambiya Hazrat Muhammad Mustafa ﷺ ki wiladat-e-ba-sa'adat Makkah Mukarramah mein Shab-e-Bani Hashim mein hui. Tareekh-e-wiladat Peer (Monday) ki subah 9 Rabi-ul-Awwal thi, jo Aam-ul-Feel (Haathi walay saal) aur Nausherwan Kisra ke ehad ka 40vaan saal tha (tahqeeq ke mutabiq 20 ya 22 April 571 Esvi).

Aap ﷺ ki walida mohtarma Hazrat Aminah ne farmaya ke wiladat ke waqt unse ek aysa noor nikla jis se Shaam ke mehalat roshan ho gaye.

Aap ﷺ ke dada Hazrat Abdul Muttalib ko jab yeh khush-khabri mili toh woh khushi khushi daudtay aaye, bachay ko god mein uthaya, Khana-e-Kaba le gaye, Allah ka shukr ada kiya aur unka naam 'Muhammad' (jiski behad tareef ki gayi ho) rakha. Yeh naam ahle Arab ke haan aam nahi tha.""",
                contentEnglish = """Muhammad [pbuh], the Master of Prophets, was born in Bani Hashim lane in Makkah on Monday morning, the 9th of Rabi' Al-Awwal, the Year of the Elephant (April 571 A.D.). His grandfather Abdul-Muttalib joyfully carried him to the Ka'bah, thanked Allah, and named him Muhammad.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "وَمَا أَرْسَلْنَاكَ إِلَّا رَحْمَةً لِّلْعَالَمِينَ",
                        romanUrduTranslation = "Aur humne aap ko nahi bheja magar tamaam jahanon ke liye rehmat bana kar.",
                        englishTranslation = "And We have sent you not but as a mercy for all mankind.",
                        reference = "Surah Al-Anbiya 21:107"
                    )
                ),
                reflectionUrdu = "Rasoolullah ﷺ ki aamad aalam-e-insaniyat ke liye zulmaat se noor ki taraf rehnumai thi."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Hazrat Halima Saadia (R.A) Aur Shaq-e-Sadr",
                titleEnglish = "Foster Childhood & Purification",
                contentUrdu = """Shehri Arabon ka riwaaj tha ke woh apnay bachon ko sehrai qabail ki daaiyon ke supurd karte taakay woh fasaahat-o-balaghat aur sehat-mand jismaani sakht hasil kar sakein.

Hazrat Halima bint Abi Zuwayb (Qabeela Bani Sa'd) Makkah aaeen. Qehat-saali ka daur tha, kisi daai ne yateem bachay ko qabool na kiya kyunkay unhein baap ki taraf se barray maali in'am ki umeed nahi thi. Lekin Hazrat Halima ne khali haath loutne ke bajaye is yateem bachay ko qabool kar liya.

Jaisay hi Hazrat Halima ne Aap ﷺ ko god mein liya, unki oontni aur bakriyon ka doodh chhalak para, unki kamzor gadhi tez-raftaar ho gayi aur unke ghar mein barkaton ki baarish shuru ho gayi.

Aap ﷺ chaar ya paanch saal ke thay jab Hazrat Jibreel (Alaihis Salam) tashreef laaye, Aap ﷺ ka seena mubarak chaak kiya (Shaq-e-Sadr), dil-e-aqdas nikala aur us mein se ek khoon ka lothra nikal kar farmaya: 'Yeh tum mein se shaitan ka hissa tha.' Phir dil ko sone ke tasht mein Aab-e-Zamzam se dho kar apni jagah par rakh diya.""",
                contentEnglish = """Entrusted to wet-nurse Haleemah As-Sa'diyah in the desert, immense blessings instantly descended upon her household. At age four or five, Angel Gabriel ripped his chest, purified his heart with Zamzam water, removing any satanic share.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "أَلَمْ نَشْرَحْ لَكَ صَدْرَكَ",
                        romanUrduTranslation = "Kya humne aap ki khatir aap ka seena khol nahi diya?",
                        englishTranslation = "Have We not expanded for you your breast?",
                        reference = "Surah Ash-Sharh 94:1"
                    )
                ),
                reflectionUrdu = "Allah Ta'ala ne Nabuwwat ke azeem mansab ke liye Aap ﷺ ke dil-e-aqdas ko bachpan hi se paakiza aur mehfooz farmaya."
            )
        )
    )

    val chapter3 = SeerahChapter(
        id = 3,
        titleUrdu = "Jawani, Akhlaq Aur Nikah Ba-Hazrat Khadijah (R.A)",
        titleEnglish = "Youth, Noble Character & Marriage",
        era = "Makki Daur",
        summaryUrdu = "Al-Ameen aur As-Sadiq ka khitaab, Hilf-ul-Fudool muahida, Tijarat-e-Shaam, Hazrat Khadijah R.A se nikah aur Kaba ki taameer-e-nau.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Al-Ameen Aur Hilf-ul-Fudool",
                titleEnglish = "The Trustworthy & League of Virtue",
                contentUrdu = """Nabi Akram ﷺ ne apni jawani mein nihayat paakiza, muttaki aur ba-waqaar zindagi basar farmai. Makkah ke tamam log aap ki sachaai, deanat-daari aur husn-e-akhlaq ke mutaraf thay, yahan tak ke unhone aap ko 'Al-Ameen' (Amanat-daar) aur 'As-Sadiq' (Sacha) ka khitaab diya.

Harb-e-Fijar ke baad ahle Makkah ne mehsoos kiya ke zulm aur be-insaafi ke khilaf ek ittihad banna chahiye. Abdullah bin Jud'an ke ghar mein Bani Hashim, Bani Muttalib, Bani Asad aur deegar qabail jama hue aur muahida kiya ke Makkah mein kisi bhi mazloom par zulm nahi hone diya jayega chahe woh maqami ho ya pardesi. Is muahiday ko 'Hilf-ul-Fudool' kaha gaya.

Nabi Kareem ﷺ ne elaan-e-nabuwwat ke baad farmaya: 'Maine Abdullah bin Jud'an ke ghar mein ek ayse muahiday mein shirkat ki thi jo mujhe surkh oonton se bhi zyada azeez hai. Agar aaj Islam mein bhi mujhe is jaisi dawat di jaye toh main zaroor labbaik kahunga.'""",
                contentEnglish = """Known throughout Makkah as Al-Ameen (The Trustworthy) and As-Sadiq (The Truthful). Prophet Muhammad [pbuh] participated in Hilf-ul-Fudoul (League of Virtues) in the house of Abdullah bin Jud'an to protect the rights of the oppressed.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "وَإِنَّكَ لَعَلَىٰ خُلُقٍ عَظِيمٍ",
                        romanUrduTranslation = "Aur beshak aap buland tareen akhlaq ke martabay par faaiz hain.",
                        englishTranslation = "And verily, you are on an exalted standard of character.",
                        reference = "Surah Al-Qalam 68:4"
                    )
                ),
                reflectionUrdu = "Insaniyat ki bhalai aur mazloom ki madad Islam ka azeem tareen johar hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Hazrat Khadijah (R.A) Se Nikah Aur Kaba Ki Taameer",
                titleEnglish = "Marriage & Arbitrating the Black Stone",
                contentUrdu = """Hazrat Khadijah bint Khuwaylid (Razi Allahu Anha) ek shareef aur daulat-mand khatoon theen. Unhone Nabi Kareem ﷺ ki sachai aur amanat-daari sun kar aap ko apna tijarati maal le kar Shaam jane ki dawat di aur apna ghulam 'Maisarah' sath bheja. Is safar mein ghair mamooli munafa hua aur Maisarah ne Aap ﷺ ke husn-e-akhlaq ki gawaahi di. Is ke baad Hazrat Khadijah ne apni saheli Nafeesa ke zariye nikah ka paigham bheja. Us waqt Aap ﷺ ki umr 25 saal aur Hazrat Khadijah ki umr 40 saal thi.

Jab Aap ﷺ ki umr 35 saal thi, sailab ki wajah se Khana-e-Kaba ki imarat kamzor ho gayi aur Quraish ne usay dobarah tameer kiya. Jab Hajr-e-Aswad ko uski jagah nasab karne ka waqt aaya toh qabail ke darmiyan shaded jhagda shuru ho gaya aur talwarein khinch gayeen.

Aakhir-kaar yeh tay hua ke kal subah jo sab se pehle Haram mein daakhil hoga woh faisla karega. Subah sab ne dekha ke Rasoolullah ﷺ tashreef laaye. Log pukaar uthe: 'Haza Al-Ameen! Hum inke faislay par raazi hain.'

Nabi Kareem ﷺ ne ek chaadar mangwayi, Hajr-e-Aswad ko uske darmiyan rakha aur tamaam qabail ke sardaron se farmaya ke woh chaadar ke kinaray pakar kar uthayein. Jab pathar maqsood jagah pohanch gaya toh Aap ﷺ ne apnay mubarak hathon se usay deewar mein nasab farma diya. Is hikmat-e-amli ne Arab ko ek barray khoon-kharabay se bacha liya.""",
                contentEnglish = """At age 25, he married Khadijah (R.A), who was blessed with profound wisdom and virtue. At age 35, when tribal war loomed over placing the Black Stone during Ka'bah reconstruction, Prophet Muhammad [pbuh] placed the Stone on a cloak and had every clan leader lift it jointly, resolving conflict with consummate wisdom.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "هَٰذَا الْأَمِينُ رَضِينَا بِهِ هَٰذَا مُحَمَّدٌ",
                        romanUrduTranslation = "Yeh Al-Ameen hain, hum in par raazi hain; yeh Muhammad hain!",
                        englishTranslation = "This is Al-Ameen! We are pleased with his judgment; this is Muhammad!",
                        reference = "Tareekh Ibn Hisham 1/196"
                    )
                ),
                reflectionUrdu = "Hikmat, sulh-jui aur adl se bad-tareen ikhtilaafaat ko khatam kiya ja sakta hai."
            )
        )
    )

    val chapter4 = SeerahChapter(
        id = 4,
        titleUrdu = "Ghar-e-Hira Mein Nuzool-e-Wahi Aur Dawat Ka Aaghaz",
        titleEnglish = "The Cave of Hira & The First Revelation",
        era = "Makki Daur",
        summaryUrdu = "Ghar-e-Hira mein ibadat, Hazrat Jibreel A.S ka aana, Pehli wahi 'Iqra', Hazrat Khadijah R.A ki tasalli aur ibtedai musalman.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Ghar-e-Hira Mein Pehli Wahi",
                titleEnglish = "In the Cave of Hira: Gabriel Brings Revelation",
                contentUrdu = """Jab Nabi Kareem ﷺ ki umr 40 saal ke qareeb pohanchi toh aap ko khalwat aur tanhai pasand aane lagi. Aap sattu aur paani le kar Makkah se do meel door Koh-e-Noor par waqay 'Ghar-e-Hira' mein tashreef le jaate aur wahan Allah ki ibadat aur ghaur-o-fikr farmate.

Ramadan-ul-Mubarak ke mubarak maheenay mein achanak Hazrat Jibreel (Alaihis Salam) zahir hue aur farmaya: 'Padho!'
Aap ﷺ ne farmaya: 'Main padha hua nahi hoon.'
Farishtay ne Aap ﷺ ko seenay se laga kar zoor se bheeba, phir chhorr kar kaha: 'Padho!'
Aap ﷺ ne phir wahi jawab diya. Teesri martaba farishtay ne lipat kar farmaya:
'Padho apnay Rab ke naam se jisne paida kiya...'

Aap ﷺ kaanpte hue ghar tashreef laaye aur farmaya: 'Zammilooni! Zammilooni!' (Mujhe kambal udha do! Mujhe kambal udha do!). Hazrat Khadijah (R.A) ne nihayat tasalli di aur farmaya: 'Hargiz nahi! Allah ki qasam, Allah aap ko kabhi ruswa nahi karega. Aap rishtedaari nibhate hain, bebas logon ka bojh uthate hain, mohtajon ki madad karte hain aur mehmaan-nawaazi karte hain.'""",
                contentEnglish = """In the Cave of Hira, Gabriel appeared and delivered the first revelation: 'Read in the name of your Lord who created...'. Shivering, he returned home saying 'Cover me! Cover me!'. His devoted wife Khadijah comforted him with immortal words of faith.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "اقْرَأْ بِاسْمِ رَبِّكَ الَّذِي خَلَقَ ۝ خَلَقَ الْإِنسَانَ مِنْ عَلَقٍ ۝ اقْرَأْ وَرَبُّكَ الْأَكْرَمُ",
                        romanUrduTranslation = "Padhiye apnay Rab ke naam ke sath jisne paida kiya. Jisne insaan ko khoon ke lothray se banaya. Padhiye aur aap ka Rab sab se bada kareem hai.",
                        englishTranslation = "Read! In the Name of your Lord, Who has created. Has created man from a clot. Read! And your Lord is the Most Generous.",
                        reference = "Surah Al-Alaq 96:1-3"
                    )
                ),
                reflectionUrdu = "Ilm, baseerat aur roohani paakizagi hi haqeeqi dawat-e-haq ki buniyad hain."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Khufya Dawat Aur Sabiqun-al-Awwaloon",
                titleEnglish = "Three Years of Secret Preaching",
                contentUrdu = """Wahi ke thode waqfay ke baad Surah Al-Muddathir ki aayath nazil huin: 'Aye chadar odhne walay! Uthiye aur khabardaar kijiye!'

Is hukum ke baad Nabi Kareem ﷺ ne ibteda mein 3 saal tak khufya dawat ka aaghaz farmaya. Sab se pehle aurton mein Hazrat Khadijah (R.A) ne Islam qabool kiya. Mardon mein sab se pehle aap ke mukhlis dost Hazrat Abu Bakr As-Siddiq (R.A) musalman hue. Bachon mein Hazrat Ali bin Abi Talib (R.A) aur aazaad shuda ghulamon mein Hazrat Zaid bin Haritha (R.A) pehle din hi daaira-e-Islam mein daakhil hue.

Hazrat Abu Bakr (R.A) ki dawat par Arab ke azeem tareen log Islam laaye:
Hazrat Usman bin Affan (R.A), Hazrat Zubair bin Al-Awwam (R.A), Hazrat Abdur Rahman bin Awf (R.A), Hazrat Sa'd bin Abi Waqqas (R.A) aur Hazrat Talha bin Ubaidullah (R.A).

In ibtedai musalmano ki taleem-o-tarbiyat ke liye 'Dar-ul-Arqam' ko markaz banaya gaya jahan Rasoolullah ﷺ sahaba ko Quran ki taleem dete thay.""",
                contentEnglish = """Following the revelation of Surah Al-Muddathir, three years of secret preaching commenced. Khadijah, Abu Bakr, Ali, and Zaid were the first to embrace Islam. Through Abu Bakr's devotion, Uthman, Zubair, Abdur Rahman bin Awf, Sa'd, and Talha joined.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "يَا أَيُّهَا الْمُدَّثِّرُ ۝ قُمْ فَأَنذِرْ ۝ وَرَبَّكَ فَكَبِّرْ",
                        romanUrduTranslation = "Aye chadar odhne walay! Uthiye aur aagah kijiye! Aur apnay Rab ki barai bayaan kijiye!",
                        englishTranslation = "O you enveloped in garments! Arise and warn! And your Lord magnify!",
                        reference = "Surah Al-Muddathir 74:1-3"
                    )
                ),
                reflectionUrdu = "Khuloos aur hikmat ke sath ki gayi dawat dilon ko badal deti hai."
            )
        )
    )

    val chapter5 = SeerahChapter(
        id = 5,
        titleUrdu = "Ailaan-e-Nubuwwat Aur Quraish Ke Mazalim",
        titleEnglish = "Open Preaching & Severe Persecution",
        era = "Makki Daur",
        summaryUrdu = "Koh-e-Safa par khula ailaan, Quraish ka ghaiz-o-ghazab, Abu Lahab ki bad-kalami, aur kamzor sahaba par be-panah zulm.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Koh-e-Safa Par Ailaan-e-Haq",
                titleEnglish = "On Mount As-Safa",
                contentUrdu = """Jab Allah Ta'ala ka hukum nazil hua: 'Aur apnay qareebi rishtedaaron ko daraiye', toh Rasoolullah ﷺ Koh-e-Safa par tashreef le gaye aur buland aawaz se pukara: 'Ya Sabahah!' (Khabardaar ho jao!).

Quraish ke tamam qabail jama ho gaye. Aap ﷺ ne farmaya: 'Agar main tumhein bataun ke is pahaad ke peechay ek lashkar tum par hamla karne ke liye tayyar khara hai, toh kya tum meri baat sach mano ge?' Sab ne yak-zabaan ho kar kaha: 'Haan! Humne kabhi aap ki zabaan se jhoot nahi suna, aap hamesha sadiq aur ameen hain.'

Tab Aap ﷺ ne farmaya: 'Toh sun lo! Main tumhein aane walay shaded azaab se khabardaar karne wala nabi hoon. Gawahi do ke Allah ke siwa koi ma'bood nahi!'

Yeh sunte hi Abu Lahab mal'oon cheekh utha: 'Tabbat laka sa'ir-al-yawm! (Tere liye tabahi ho saara din! Kya tune humein is baat ke liye jama kiya tha?)' Is par Allah Ta'ala ne Surah Al-Masad nazil farmai.""",
                contentEnglish = """Ascending Mount As-Safa, Prophet Muhammad [pbuh] addressed the gathering of Quraish: 'If I told you horsemen behind this mountain were about to attack, would you believe me?' They unanimously replied: 'Yes, we have experienced only truth from you!' He then proclaimed Tawheed. Abu Lahab shouted insults, prompting the revelation of Surah Al-Masad.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "تَبَّتْ يَدَا أَبِي لَهَبٍ وَتَبَّ",
                        romanUrduTranslation = "Toot gaye Abu Lahab ke dono haath aur woh barbaad ho gaya!",
                        englishTranslation = "Perish the two hands of Abu Lahab and perish he!",
                        reference = "Surah Al-Masad 111:1"
                    )
                ),
                reflectionUrdu = "Haq baat kehne par apnay bhi mukhalif ho jaate hain, magar sachaai hamesha ghalib aati hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Sahaba-e-Kiram Par Zulm-o-Sitam",
                titleEnglish = "Unflinching Patience of the Early Martyrs",
                contentUrdu = """Quraish ne jab dekha ke Islam tezi se phail raha hai toh unhone musalmano par be-panah zulm dhana shuru kar diya, khusoosan un ghulamon aur kamzoron par jin ka koi qabeela himayat karne wala na tha.

Hazrat Bilal Habshi (Razi Allahu Anhu) ko unka bad-bakht aaqa Umayyah bin Khalaf dhoop ki tapti reht par lita deta, seenay par bhari pathar rakh deta aur kehta ke Muhammad ﷺ ka inkar karo, magar Bilal (R.A) ki zabaan par sirf ek hi pukaar thi: 'Ahad! Ahad!' (Allah ek hai! Allah ek hai!). Aakhir-kaar Hazrat Abu Bakr (R.A) ne unhein khareed kar aazaad karwaya.

Hazrat Khabbab bin Al-Aratt (R.A) ko dehektay angaron par peeth ke bal litaya gaya yahan tak ke unki peeth ki charbi pighal kar angaron ko bujha deti thi.

Hazrat Yasir (R.A) aur unki zauja Hazrat Sumayyah (Razi Allahu Anha) ko Abu Jahl ne bay-rehami se shaheed kar diya. Hazrat Sumayyah (R.A) Islam ki pehli shaheed khatoon theen. Rasoolullah ﷺ unke paas se guzarte toh farmate: 'Sabr karo aye aale Yasir! Tumhara thekana Jannat hai.'""",
                contentEnglish = """Savage persecutions targeted defenseless believers. Bilal (R.A) was dragged across burning sand under heavy boulders, chanting 'Ahad! Ahad!'. Khabbab (R.A) was laid upon red coals. Yasir and his wife Sumayyah were martyred by Abu Jahl, Sumayyah becoming the first martyr in Islam.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "صَبْرًا يَا آلَ يَاسِرٍ فَإِنَّ مَوْعِدَكُمُ الْجَنَّةُ",
                        romanUrduTranslation = "Sabr karo aye aale Yasir! Beshak tumhare liye Jannat ka waada hai.",
                        englishTranslation = "Be patient, O family of Yasir! For your appointed destination is Paradise.",
                        reference = "Mustadrak Hakim 3/383"
                    )
                ),
                reflectionUrdu = "Sahaba-e-Kiram ki be-misaal qurbaniyon hi ke zariye Deen-e-Islam hum tak mehfooz pohancha."
            )
        )
    )

    val chapter6 = SeerahChapter(
        id = 6,
        titleUrdu = "Hijrat-e-Habsha Aur Hazrat Hamzah o Umar (R.A) Ka Islam",
        titleEnglish = "Abyssinia Migration & Islam of Hamzah & Umar (R.A)",
        era = "Makki Daur",
        summaryUrdu = "Musalmano ki Habsha ki taraf pehli aur doosri hijrat, Najjashi ke samnay Hazrat Ja'far R.A ki taqreer, aur do azeem pahalwanon ka Islam.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Hijrat-e-Habsha Aur Najjashi Ka Darbar",
                titleEnglish = "Migration to Abyssinia & The Christian King",
                contentUrdu = """Jab Makkah mein zulm hadd se barh gaya toh Nabuwwat ke 5vein saal Rasoolullah ﷺ ne sahaba ko Habsha (Ethiopia) ki taraf hijrat ki ijazat di jahan ka baadshah 'Najjashi' (Negus) ek aadil insan tha. Pehle qaflay mein 12 mard aur 4 aurtein theen jin mein Hazrat Usman bin Affan aur unki zauja Hazrat Ruqayyah (Bint-e-Rasool ﷺ) shamil thay.

Baad mein doosri hijrat hui jis mein 83 mard aur 18 aurtein shamil theen. Quraish ne qeemti tohfe de kar Amr bin Al-Aas aur Abdullah bin Abi Rabia ko bheja taakay Najjashi se musalmano ko wapas maang sakein.

Najjashi ne musalmano ko darbar mein bulaya. Hazrat Ja'far bin Abi Talib (R.A) ne kharay ho kar tareekhi taqreer farmai:
'Aye baadshah! Hum jahiliyat ki tareekiyon mein ghiray hue thay, buton ko poojte thay, murdar khate thay, behayai karte thay aur taaqatwar kamzor ko kha jata tha. Phir Allah ne hum mein ek Rasool bheja jin ke nasab, sachai aur paak-daamani se hum waaqif thay. Unhone humein ek Allah ki ibadat ki dawat di, sach bolne, amanat ada karne aur zulm se bachne ka hukum diya...'

Hazrat Ja'far ne Surah Maryam ki ibtedai aayath tilawat farmaeen. Najjashi aur uske darbaari paadri ro parey aur Najjashi ne kaha: 'Yeh kalaam aur Hazrat Isa (A.S) ka laaya hua noor ek hi chashmay se niklay hain!' Usne Quraish ke tohfe wapas kar diye aur musalmano ko hifazat ki zamanat di.""",
                contentEnglish = """To escape brutal torture, Muslims migrated to Abyssinia ruled by the just Christian King Negus. Ja'far bin Abi Talib delivered an eloquent defense of Islamic monotheism and recited Surah Maryam. Moved to tears, the King rejected Quraish's extradition demands and granted Muslims perpetual sanctuary.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "قَالَتْ يَا لَيْتَنِي مِتُّ قَبْلَ هَٰذَا وَكُنتُ نَسْيًا مَّنسِيًّا",
                        romanUrduTranslation = "Maryam ne kaha: Kaash main is se pehle mar chuki hoti aur bhooli-bisri ho gayi hoti!",
                        englishTranslation = "She said: Would that I had died before this, and had been forgotten and out of sight!",
                        reference = "Surah Maryam 19:23"
                    )
                ),
                reflectionUrdu = "Haq aur sachaai dil par asar karti hai, chahe sunne wala kisi bhi mazhab ka ho."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Hazrat Hamzah Aur Hazrat Umar (R.A) Ka Dakhla-e-Islam",
                titleEnglish = "Conversion of Hamzah & Umar (R.A)",
                contentUrdu = """Nabuwwat ke chatay (6th) saal do azeem shakhsiyaton ke Islam laane se musalmano ki taaqat mein be-panah izafa hua:

1. Hazrat Hamzah bin Abdul Muttalib (Razi Allahu Anhu): Nabi ﷺ ke chacha aur shair-dil shikaari thay. Ek din Abu Jahl ne Rasoolullah ﷺ ko bura bhala kaha aur pathar maara. Jab Hamzah ko pata chala toh unka khoon khaul utha. Woh Khana-e-Kaba pohanche aur apni kamaan se Abu Jahl ke sar par aysa waar kiya ke uska sar phat gaya aur farmaya: 'Tu Muhammad ko gaali deta hai halankay main bhi uske deen par hoon!'

2. Hazrat Umar bin Al-Khattab (Razi Allahu Anhu): Rasoolullah ﷺ ne dua farmai thi: 'Aye Allah! Umar bin Khattab ya Abu Jahl mein se jo tujhe zyada pasand ho uske zariye Islam ko izzat ata farma.'

Umar talwar le kar Nabi ﷺ ko qatl karne ke iraday se niklay. Raastay mein pata chala ke unki behen Fatimah aur behnoi Saeed bin Zaid musalman ho chukay hain. Behen ke ghar pohanch kar dono ko maara, behen ka sar zakhmi ho gaya magar unhone farmaya: 'Umar! Jo karna hai kar lo, hum Allah aur uske Rasool par imaan laa chukay hain!'

Behen ka khoon dekh kar Umar ka dil pighla. Unhone Quran ke auraaq (Surah Taha) padhay: 'Beshak Main hi Allah hoon, Mere siwa koi ma'bood nahi, pas Meri ibadat karo.' Umar ne furan Dar-ul-Arqam pohanch kar Nabi Kareem ﷺ ke dast-e-haq par Islam qabool kar liya. Is par sahaba ne itni buland aawaz se 'Allahu Akbar' ka naara lagaya ke Makkah ki pahadiyan goonj utheen.""",
                contentEnglish = """In the 6th year of Prophethood, Hamzah (R.A) struck Abu Jahl with his bow and accepted Islam. Three days later, Umar bin Al-Khattab, moved by the opening verses of Surah Ta-Ha at his sister's house, accepted Islam, allowing Muslims to pray publicly at the Ka'bah for the first time.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "إِنَّنِي أَنَا اللَّهُ لَا إِلَٰهَ إِلَّا أَنَا فَاعْبُدْنِي وَأَقِمِ الصَّلَاةَ لِذِكْرِي",
                        romanUrduTranslation = "Beshak Main hi Allah hoon, Mere siwa koi ma'bood nahi, pas Meri ibadat karo aur Meri yaad ke liye Namaz qayam karo.",
                        englishTranslation = "Verily, I am Allah! There is no god but I, so worship Me and establish prayer for My remembrance.",
                        reference = "Surah Ta-Ha 20:14"
                    )
                ),
                reflectionUrdu = "Dua-e-Nabwi ﷺ ka aijaz pathar dilon ko mom bana deta hai."
            )
        )
    )
}
