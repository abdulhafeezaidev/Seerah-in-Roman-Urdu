package com.example.data.repository

import com.example.data.model.ArabicQuote
import com.example.data.model.BookPage
import com.example.data.model.SeerahChapter

object SeerahMiddleChapters {

    val chapter7 = SeerahChapter(
        id = 7,
        titleUrdu = "Shob-e-Abi Talib Ka Boycott Aur Aam-ul-Huzn",
        titleEnglish = "The Boycott & The Year of Grief",
        era = "Makki Daur",
        summaryUrdu = "Musalmano aur Banu Hashim ka 3 saal tak shob-e-Abi Talib mein shadeed boycott, aur Hazrat Abu Talib o Hazrat Khadijah R.A ka wisaal.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Shob-e-Abi Talib Ka Muqataa (Boycott)",
                titleEnglish = "Three Years of Stifling Siege",
                contentUrdu = """Nabuwwat ke 7vein saal Muharram mein Quraish ke tamam qabail ne mil kar ek zalimana muahida tayaar kiya jis par Bagheed bin Amir ne dastakhat kiye aur usay Khana-e-Kaba ke andar latka diya. Muahiday ki shart yeh thi ke Banu Hashim aur Banu Muttalib se koi shakhs na rishta karega, na khareed-o-farokht karega, aur na koi guftagu karega jab tak ke woh Muhammad ﷺ ko qatl ke liye unke hawale na kar dein.

Abu Talib ne apnay qabeelay ko Makkah ke mashriqi pahadi darre 'Shob-e-Abi Talib' mein jama kiya. Yeh muqataa 3 saal tak chala. Musalmano aur Banu Hashim par itni shadeed bhook aur faqa-kashi aayi ke bachon ke ronay ki aawazein baahar aati theen aur log darakhton ke pattay aur sukhi hui chamdi ubaal kar khane par majboor ho gaye.

Aakhir-kaar Nabuwwat ke 10vein saal Allah Ta'ala ne deewak (termite) ko us dastaweez par musallat kar diya jisne Allah ke naam ke siwa saara muahida chaat liya. Rasoolullah ﷺ ne iski khabar Abu Talib ko di. Abu Talib ne jaa kar Quraish ko aagah kiya. Jab dastaweez dekhi gayi toh waisa hi paaya gaya jaisa Nabi ﷺ ne farmaya tha, aur Quraish ke ba-zameer logon ne is muqatay ko tod diya.""",
                contentEnglish = """In the 7th year of Prophethood, Quraish enforced a merciless three-year social and economic boycott against Banu Hashim and Banu Al-Muttalib in the narrow pass of Shi'b Abu Talib. Believers suffered intense starvation, surviving on tree leaves. By Allah's decree, termites consumed the entire parchment except the Name of Allah, terminating the unjust pact.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "بِاسْمِكَ اللَّهُمَّ",
                        romanUrduTranslation = "Aye Allah! Tere hi naam ke sath.",
                        englishTranslation = "In Your Name, O Allah!",
                        reference = "Tareekh Ibn Hisham 1/350"
                    )
                ),
                reflectionUrdu = "Zulm chahe kitna hi taaqatwar ho, haq aur sachai ke aagay hamesha reza reza ho jata hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Aam-ul-Huzn: Gham Ka Saal",
                titleEnglish = "The Passing of Abu Talib and Khadijah (R.A)",
                contentUrdu = """Shob-e-Abi Talib ke muqatay se nikalne ke sirf 6 maah baad, Nabuwwat ke 10vein saal Rajab mein, Nabi Kareem ﷺ ke chacha aur sab se barray muhafiz Abu Talib bimaar hue aur wafat pa gaye. Unhone 40 saal tak Nabi ﷺ ki har tarah se hifazat aur dildaari ki thi.

Is ke sirf do maah baad, Ramadan mein, Rasoolullah ﷺ ki mutahhara zauja, Umm-ul-Momineen Hazrat Khadijah (Razi Allahu Anha) 65 saal ki umr mein wafat pa gayeen. Woh 25 saal tak Rasoolullah ﷺ ki dukh-sukh ki shareek theen. Unhone apna saara maal Islam par nichawar kar diya tha.

Aap ﷺ ne farmaya: 'Khadijah us waqt mujh par imaan laaeen jab logon ne mera inkar kiya, unhone us waqt meri tasdeeq ki jab log mujhe jhutla rahe thay, aur unhone apnay maal se meri madad ki jab logon ne mujhe mehroom kiya.'

Dono azeem sahare chhin jaane par Nabi Kareem ﷺ ko be-inteha sadma hua, is liye tareekh mein is saal ko 'Aam-ul-Huzn' (Gham Ka Saal) kaha jata hai.""",
                contentEnglish = """Within two months in the 10th year of Prophethood, the Prophet [pbuh] suffered the passing of his protective uncle Abu Talib and his beloved wife Khadijah (R.A). Grieved by the loss of his two greatest earthly pillars, the year became known as the 'Year of Grief'.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "آمَنَتْ بِي حِينَ كَفَرَ بِي النَّاسُ، وَصَدَّقَتْنِي حِينَ كَذَّبَنِي النَّاسُ",
                        romanUrduTranslation = "Woh mujh par imaan laaeen jab logon ne kufr kiya, aur meri tasdeeq ki jab logon ne mujhe jhutlaya.",
                        englishTranslation = "She believed in me when people disbelieved, and confirmed my truth when people rejected me.",
                        reference = "Musnad Imam Ahmad 6/118"
                    )
                ),
                reflectionUrdu = "Musalman par aazmaishon ke pahaad toot parrein tab bhi Allah ki raza par raazi rehna chahiye."
            )
        )
    )

    val chapter8 = SeerahChapter(
        id = 8,
        titleUrdu = "Safar-e-Taif Aur Al-Isra wal-Mi'raj",
        titleEnglish = "The Journey to Ta'if & The Heavenly Ascension",
        era = "Makki Daur",
        summaryUrdu = "Taif ke aazmaishi lamhaat, Rasoolullah ﷺ ki mashhoor dua, Isra aur Mairaj ka azeem maujiza aur 5 waqt ki Namaz ka tohfa.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Safar-e-Taif Aur Dua-e-Rehmat",
                titleEnglish = "Ta'if: Patience and Mercy Under Trials",
                contentUrdu = """Shawwal 10 Nabuwwat mein Rasoolullah ﷺ apnay aazaad karda ghulam Hazrat Zaid bin Haritha (R.A) ke sath Taif tashreef le gaye taakay Qabeela Saqeef ko Islam ki dawat dein.

Wahan ke sardaron ne na sirf dawat ko thukraya balkay shehar ke awara laundon aur bad-maashon ko Nabi ﷺ ke peechay laga diya. Unhone dono taraf se pathar barsaye yahan tak ke Aap ﷺ ki jootiyan khoon-e-mubarak se bhar gayeen aur Zaid bin Haritha aap ko bachaate hue zakhmi ho gaye.

Aap ﷺ ne ek bagh mein panah li aur Allah ke huzoor nihayat dard-bhari dua ki:
'Allahumma ilaika ashkoo da'fa quwwati...' (Aye Allah! Main Apni be-basi aur be-kasi ka shikwa sirf Tere huzoor karta hoon... Agar Tu mujh se naraaz nahi toh mujhe kisi takleef ki parwah nahi!)

Pahaadon ke farishtay ne haazir ho kar arz kiya: 'Aye Allah ke Rasool! Agar aap hukam dein toh main Makkah ke dono pahaadon (Akhshabain) ko aapas mein mila kar inhein pees daalun.'
Rehmat-ul-lil-Aalameen ﷺ ne farmaya: 'Nahi! Mujhe umeed hai ke Allah inki pushton se ayse log paida karega jo sirf ek Allah ki ibadat karenge aur kisi ko shareek na thehrayenge.'""",
                contentEnglish = """Pelted with heavy stones in Ta'if until blood filled his shoes, the Prophet [pbuh] sought refuge in a vineyard and supplicated to Allah. When the Angel of the Mountains offered to crush the city between the two peaks of Makkah, the Mercy to Mankind refused, praying instead that future generations would worship Allah alone.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "اللَّهُمَّ إِلَيْكَ أَشْكُو ضَعْفَ قُوَّتِي، وَقِلَّةَ حِيلَتِي، وَهَوَانِي عَلَى النَّاسِ، يَا أَرْحَمَ الرَّاحِمِينَ",
                        romanUrduTranslation = "Aye Allah! Main Apni be-basi, wasail ki kami aur logon mein apni be-waqri ki faryad Tere hi huzoor karta hoon, Aye sab se barh kar reham karne walay!",
                        englishTranslation = "O Allah! To You alone I complain of my helplessness, the paucity of my resources, and my insignificance before mankind, O Most Merciful of the merciful!",
                        reference = "Al-Bidayah wan-Nihayah 3/135"
                    )
                ),
                reflectionUrdu = "Badla lene ki taaqat rakhne ke bawajood dushman ke liye hidayat ki dua karna Nabi ﷺ ka azeem tareen akhlaq hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Al-Isra Wal-Mi'raj: Aasmaani Safar",
                titleEnglish = "The Miraculous Night Journey & Ascension",
                contentUrdu = """Hijrat se taqreeban 16 maah pehle, Allah Ta'ala ne apnay Habib ﷺ ko azeem roohani o jismaani moajizay se nawaza.

1. Al-Isra (Zameeni Safar): Hazrat Jibreel (A.S) Buraaq par sawar karwa kar Nabi ﷺ ko Masjid-e-Haram (Makkah) se Masjid-e-Aqsa (Bait-ul-Muqaddas) le gaye jahan Aap ﷺ ne tamam ambiya-e-kiram ki imamat farmai.

2. Al-Mi'raj (Aasmaani Safar): Phir aasmaanon par tashreef le gaye. Pehle aasmaan par Hazrat Adam (A.S), doosray par Hazrat Yahya o Isa (A.S), teesray par Hazrat Yusuf (A.S), chothay par Hazrat Idrees (A.S), paanchwein par Hazrat Haroon (A.S), chatay par Hazrat Musa (A.S) aur saatwein par Hazrat Ibrahim (A.S) se mulaqat hui.

Aap ﷺ Sidrat-ul-Muntaha tashreef le gaye jahan Allah Ta'ala ne apnay bando par 50 Namazein farz farmaeen. Hazrat Musa (A.S) ke mashwaray par Nabi ﷺ ne baar baar iltija ki yahan tak ke Allah Ta'ala ne reham farma kar 5 Namazein muqarrar farmaeen aur farmaya ke 'Amal mein 5 hain magar ajar mein 50 ka sawab milega.'

Agli subah jab Makkah walon ne mazaq udaya toh Hazrat Abu Bakr (R.A) ne farmaya: 'Agar Muhammad ﷺ ne yeh farmaya hai toh bilkul sach farmaya hai.' Is sachai ki tasdeeq par unhein 'As-Siddiq' ka laqab mila.""",
                contentEnglish = """The miraculous journey from Makkah to Jerusalem (Al-Isra) where he led all Prophets in prayer, followed by the bodily ascension through the seven heavens (Al-Mi'raj) to Sidrat-ul-Muntaha. Here the gift of five daily prayers (rewarded as fifty) was ordained. Abu Bakr verified the event without hesitation, earning the title 'As-Siddiq'.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "سُبْحَانَ الَّذِي أَسْرَىٰ بِعَبْدِهِ لَيْلًا مِّنَ الْمَسْجِدِ الْحَرَامِ إِلَى الْمَسْجِدِ الْأَقْصَى",
                        romanUrduTranslation = "Paak hai Woh Zaat jo le gayi apnay banday ko raat hi raat mein Masjid-e-Haram se Masjid-e-Aqsa tak.",
                        englishTranslation = "Exalted is He who took His Servant by night from al-Masjid al-Haram to al-Masjid al-Aqsa.",
                        reference = "Surah Al-Isra 17:1"
                    )
                ),
                reflectionUrdu = "Namaz momin ki mairaj hai, jo seedha bande ka rab ke sath ta'alluq jodh deti hai."
            )
        )
    )

    val chapter9 = SeerahChapter(
        id = 9,
        titleUrdu = "Bay'at-e-Aqabah Aur Hijrat-e-Madinah",
        titleEnglish = "Pledges of Aqabah & Hijrah to Madinah",
        era = "Makki Daur",
        summaryUrdu = "Yasrib (Madinah) ke logon ka Islam, Mus'ab bin Umair R.A ki dawat, Dar-un-Nadwah ki sazish, Ghar-e-Saur aur Madinah ki taraf azeem hijrat.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Bay'at-e-Aqabah Aur Madinah Mein Noor-e-Islam",
                titleEnglish = "The Pledges of Aqabah",
                contentUrdu = """Nabuwwat ke 11vein saal Hajj ke mausam mein Yasrib (Madinah) ke Khazraj qabeelay ke 6 afrad ne Mina ki ghaati (Aqabah) ke paas Rasoolullah ﷺ ki dawat sun kar Islam qabool kiya.

Agli baar (12 Nabuwwat) 12 afrad aaye aur pehli Bay'at-e-Aqabah hui. Nabi ﷺ ne Hazrat Mus'ab bin Umair (R.A) ko pehla Islami safeer (ambassador) bana kar Madinah bheja. Hazrat Mus'ab ki mudallal dawat aur husn-e-akhlaq se Sa'd bin Mu'adh aur Usaid bin Hudair jaise azeem sardar musalman hue aur Madinah ka koi aysa ghar na bacha jahan Islam ka charcha na ho.

Agley saal (13 Nabuwwat) 73 mard aur 2 aurtein Makkah aaeen aur doosri azeem Bay'at-e-Aqabah hui jis mein unhone Nabi ﷺ ko Madinah aane ki dawat di aur apni jaano ki tarah hifazat ka pohncha ehad kiya.""",
                contentEnglish = """During Hajj seasons, delegations from Yathrib (Madinah) embraced Islam at Al-'Aqabah. Mus'ab bin Umair was dispatched as the first envoy, spreading Islam to nearly every household. In the Second Pledge, 75 Madinese disciples swore unwavering defense of the Prophet [pbuh].""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "لَا نُشْرِكُ بِاللَّهِ شَيْئًا وَلَا نَسْرِقُ وَلَا نَزْنِي",
                        romanUrduTranslation = "Hum Allah ke sath kisi ko shareek na thehrayenge, na chori karenge aur na badkaari karenge.",
                        englishTranslation = "We shall not associate anything with Allah, nor steal, nor commit adultery.",
                        reference = "Sahih Al-Bukhari 1/550"
                    )
                ),
                reflectionUrdu = "Dawat-e-deen mein musalman safeer ka kirdaar aur narm guftagu dilon ko fatah kar leti hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Dar-un-Nadwah Ki Sazish Aur Ghar-e-Saur",
                titleEnglish = "The Assassination Plot & Cave of Thawr",
                contentUrdu = """Jab musalman aahista aahista Madinah hijrat karne lagey toh Quraish ne Dar-un-Nadwah (apni parliament) mein aakhri sazish tay ki: har qabeelay ka ek noujawan talwar le kar ek sath Muhammad ﷺ par hamla karega taakay khoon-baha tamam qabail par taqseem ho jaye aur Banu Hashim badla na le sakein.

Hazrat Jibreel (A.S) ne aakar Nabi ﷺ ko aagah kiya aur farmaya ke aaj raat apnay bistar par na soyein. Nabi Kareem ﷺ ne Hazrat Ali (R.A) ko farmaya: 'Mere bistar par meri sabz chadar odh kar so jao aur logon ki amanatein subah wapas kar ke Madinah aa jana.'

Nabi Kareem ﷺ raat ke waqt Quran ki aayat padhte hue dushmanon ke gird se mitti phenk kar nikal gaye aur Allah ne unki aankhon par parda daal diya.

Aap ﷺ Hazrat Abu Bakr (R.A) ke sath Ghar-e-Saur mein 3 din aur 3 raatein muqeem rahe. Quraish dhoondte hue ghaar ke munh tak pohanch gaye. Abu Bakr (R.A) ghabraaye toh Nabi Kareem ﷺ ne azeem tareekhi jumla farmaya:
'La tahzan! Inna Allaha ma'ana' (Ghabrao mat! Beshak Allah hamare sath hai).""",
                contentEnglish = """Surrounded by assassins chosen from every Makkan clan, the Prophet instructed Ali (R.A) to sleep in his bed to return deposits. Reciting Surah Ya-Sin, the Prophet slipped past them unseen. Sheltered in Cave Thawr for three nights with Abu Bakr, he comforted his companion: 'Grieve not, for Allah is with us.'""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "لَا تَحْزَنْ إِنَّ اللَّهَ مَعَنَا",
                        romanUrduTranslation = "Gham na kijiye, beshak Allah hamare sath hai!",
                        englishTranslation = "Do not grieve; indeed Allah is with us.",
                        reference = "Surah At-Tawbah 9:40"
                    )
                ),
                reflectionUrdu = "Khatarnak tareen lamhaat mein bhi momin ka sahara sirf aur sirf Allah Ta'ala ki zaat hoti hai."
            ),
            BookPage(
                pageNumber = 3,
                titleUrdu = "Madinah Munawwarah Mein Aamad Aur Tale'a Al-Badru Alayna",
                titleEnglish = "Triumphant Entry into Madinah",
                contentUrdu = """Safar-e-Hijrat ke doran Suraqah bin Malik ne in'am ke lalach mein ta'aqub kiya magar uske ghoray ke paaon zameen mein dhas gaye. Usne maafi maangi aur Nabi ﷺ ne usay Kisra ke kangan pehne ki bashaarat di.

Monday 8 Rabi-ul-Awwal ko Rasoolullah ﷺ Quba pohanche jahan pehli Masjid-e-Quba ki buniyad rakhi gayi.

Friday ko Nabi ﷺ Madinah Munawwarah daakhil hue. Madinah ke koochon mein khushi ka samaa tha. Bachiyan aur aurtein daf baja kar tarana gaa rahi theen:
'Tala'a al-badru 'alayna, min thaniyyat-il-wada'...' (Hum par chodhvin ka chaand tulu hua, wada' ki pahadiyon se!).

Har Ansar ki khwahish thi ke Huzoor ﷺ unke ghar thehrein. Aap ﷺ ne farmaya: 'Meri oontni (Qaswa) ko chhorr do, yeh mamoor (hukum paai hui) hai.' Oontni chaltay chaltay Hazrat Abu Ayyub Ansari (R.A) ke ghar ke samnay baith gayi aur unhein Nabi-e-Rehmat ﷺ ki mehmaandari ka azeem sharaf hasil hua.""",
                contentEnglish = """Arriving at Quba on 8 Rabi' Al-Awwal, the Prophet laid the foundation of Quba Mosque. Entering Madinah on Friday, girls chanted 'Tala'al Badru Alayna' in joyous celebration. The camel knelt before the house of Abu Ayyub Al-Ansari, granting him the eternal honor of hosting the Messenger of Allah.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "طَلَعَ الْبَدْرُ عَلَيْنَا ۝ مِن ثَنِيَّاتِ الْوَدَاعِ ۝ وَجَبَ الشُّكْرُ عَلَيْنَا ۝ مَا دَعَا لِلَّهِ دَاعٍ",
                        romanUrduTranslation = "Hum par wada' ki pahadiyon se chodhvin ka chaand chamak utha! Hum par shukr ada karna wajib hai jab tak Allah ko pukaarne wala pukaare.",
                        englishTranslation = "The full moon rose upon us from the valley of Wada'! Gratitude is upon us for as long as a caller calls unto Allah.",
                        reference = "Al-Bidayah wan-Nihayah 3/197"
                    )
                ),
                reflectionUrdu = "Madinah Munawwarah ki sar-zameen ne Rehmat-e-Do Aalam ﷺ ko khulay dil se gale lagaya aur tareekh ka rukh morr diya."
            )
        )
    )

    val chapter10 = SeerahChapter(
        id = 10,
        titleUrdu = "Riyasat-e-Madinah, Masjid-e-Nabwi Aur Meesaq-e-Madinah",
        titleEnglish = "Building the Islamic State in Madinah",
        era = "Madani Daur",
        summaryUrdu = "Masjid-e-Nabwi ki tameer, Muhajireen aur Ansar ke darmiyan be-misaal Muwakhat, aur tareekh-e-insaniyat ka pehla aaeen Meesaq-e-Madinah.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Masjid-e-Nabwi Aur Muwakhat-e-Madinah",
                titleEnglish = "The Prophet's Mosque & Golden Brotherhood",
                contentUrdu = """Madinah tashreef laane ke baad sab se pehla kaam Masjid-e-Nabwi ki tameer thi. Zameen do yateem bachon se qeemat ada kar ke khareedi gayi. Rasoolullah ﷺ ne khud sahaba ke sath mil kar pathar aur eentein uthaeen aur farmaya:
'Allahumma la aisha illa aishul aakhirah, faghfir lil-ansari wal-muhajirah' (Aye Allah! Aakhirat ki zindagi ke siwa koi zindagi nahi, pas Tu Ansar aur Muhajireen ki maghfirat farma!).

Masjid ke sath 'Suffah' ka chabootra banaya gaya jo be-ghar aur taalib-e-ilm sahaba ki rehaish-gaah bana.

Is ke baad Nabi Kareem ﷺ ne Anas bin Malik ke ghar mein 90 sahaba (aadhe Muhajireen aur aadhe Ansar) ko jama farmaya aur do do afrad ke darmiyan 'Muwakhat' (Bhaichara) qayam farmaya. Ansar ne apnay be-sar-o-samaan bhaiyon ke liye aysi qurbani pesh ki jiski nazeer tareekh-e-aalam mein nahi milti: aadhi jaidad, aadhay baghat aur ghar taqseem kar diye.""",
                contentEnglish = """The Prophet personally carried adobe bricks to construct the Prophet's Mosque in Madinah, incorporating Suffah platform for dedicated scholars. He established fraternal brotherhood (Muwakhat) pairing 90 Emigrants and Helpers, where Ansar generously shared half their homes and wealth with their brethren.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "اللَّهُمَّ لَا عَيْشَ إِلَّا عَيْشُ الْآخِرَةِ، فَاغْفِرْ لِلْأَنْصَارِ وَالْمُهَاجِرَةِ",
                        romanUrduTranslation = "Aye Allah! Aakhirat ki zindagi ke siwa koi zindagi nahi, pas Tu Ansar aur Muhajireen ki bakhshish farma!",
                        englishTranslation = "O Allah! No bliss is there but that of the Hereafter; I beseech You to forgive the Emigrants and the Helpers.",
                        reference = "Sahih Al-Bukhari 1/71"
                    )
                ),
                reflectionUrdu = "Eesar aur bhaichara hi kisi bhi qawi aur ba-barkat muashray ki buniyad hoti hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Meesaq-e-Madinah: Pehla Tehreeri Dastoor",
                titleEnglish = "The Charter of Madinah",
                contentUrdu = """Madinah mein azeem amno-amaan qayam karne ke liye Rasoolullah ﷺ ne musalmano aur Yahoodi qabail (Banu Qainuqa, Banu Nadeer, Banu Quraiza) ke darmiyan ek tareekhi muahida likhwaaya jo 'Meesaq-e-Madinah' ke naam se mashhoor hua:

1. Tamaam musalman doosray logon ke muqablay mein ek azeem ummat hain.
2. Yahood ko apnay deen par amal karne ki poori aazaadi hogi aur musalmano ko apnay deen par.
3. Madinah par kisi bhi dushman ke hamlay ki soorat mein sab mil kar difa karenge.
4. Quraish-e-Makkah ya unke madad-garon ko Madinah mein koi panah nahi di jayegi.
5. Kisi bhi jhagday ya naza' ki soorat mein aakhri faisla Allah aur Uske Rasool Hazrat Muhammad ﷺ ka hoga.

Is dastoor ne Madinah ko ek muttahida, ba-waqaar aur munazzam riyasat bana diya jiski sarbarahi Nabi Kareem ﷺ ke mubarak hathon mein thi.""",
                contentEnglish = """The Prophet codified the Charter of Madinah, establishing mutual defense, religious freedom for Jewish tribes, commercial boycott of hostile Quraish, and supreme arbitration under Allah and His Messenger, uniting Madinah into a cohesive constitutional state.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "وَإِنَّهُ مَا كَانَ بَيْنَ أَهْلِ هَٰذِهِ الصَّحِيفَةِ مِنْ حَدَثٍ أَوْ اشْتِجَارٍ فَإِنَّ مَرَدَّهُ إِلَى اللَّهِ وَإِلَى مُحَمَّدٍ رَسُولِ اللَّهِ",
                        romanUrduTranslation = "Aur is tehreer walon ke darmiyan jo bhi ikhtilaaf ya jhagda paida ho, uska ruju Allah aur Muhammad Rasoolullah ﷺ ki taraf hoga.",
                        englishTranslation = "Whenever any dispute arises among the parties of this document, it shall be referred to Allah and Muhammad, the Messenger of Allah.",
                        reference = "Seerat Ibn Hisham 1/503"
                    )
                ),
                reflectionUrdu = "Islam aaeen, qanoon ki baala-dasti aur aqliyaton ke huqooq ka sab se bada alambardaar hai."
            )
        )
    )

    val chapter11 = SeerahChapter(
        id = 11,
        titleUrdu = "Ghazwa-e-Badr: Pehli Azeem Fatah",
        titleEnglish = "The Battle of Badr - The Day of Criterion",
        era = "Madani Daur",
        summaryUrdu = "17 Ramadan 2 Hijri, 313 be-sar-o-samaan musalman 1000 ke musallah kuffar ke muqablay mein, farishton ki nusrat aur Abu Jahl ka ibrat-naak anjam.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Maidan-e-Badr Aur Rasoolullah ﷺ Ki Aaho-Zari",
                titleEnglish = "The Night Before Battle & Earnest Supplication",
                contentUrdu = """17 Ramadan 2 Hijri ko tareekh-e-Islam ka pehla faisla-kun marka pesh aaya. Abu Sufyan ka tijarati qafla bach nikla tha magar Abu Jahl takabbur mein 1000 ka lashkar le kar Badr pohanch gaya.

Musalmano ki tadaad sirf 313 thi jin ke paas sirf 2 ghoray aur 70 oont thay, aksar ke paas talwarein tak poori na theen. Jang se pehli raat Rasoolullah ﷺ ne apnay chhappar (Areesh) mein saari raat ro ro kar Allah ke huzoor sajdon mein guzaari:
'Allahumma in tuhlik haazihil i'sabata min ahlil islami la tu'bad fil ardi...' (Aye Allah! Agar musalmano ki yeh mukhtasir jama'at halak ho gayi toh zameen par Teri ibadat karne wala koi na rahega!).

Aap ﷺ ke kandhon se chadar dhalak gayi. Hazrat Abu Bakr (R.A) ne chadar utha kar kandhon par rakhi aur arz kiya: 'Aye Allah ke Rasool! Aap ki duaen kafi hain, Allah apna waada zaroor poora farmayega.'""",
                contentEnglish = """On Friday, 17th Ramadan 2 A.H., 313 ill-equipped Muslims faced 1,000 Makkan warriors at Badr. The Prophet spent the night weeping in supplication until his mantle fell: 'O Allah! If this band of Muslims is defeated today, You will no longer be worshipped on earth.' Abu Bakr gently placed the cloak back, consoling him with Allah's promise.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "اللَّهُمَّ إِنْ تُهْلِكْ هَٰذِهِ الْعِصَابَةَ مِنْ أَهْلِ الْإِسْلَامِ لَا تُعْبَدْ فِي الْأَرْضِ",
                        romanUrduTranslation = "Aye Allah! Agar ahle Islam ki yeh jama'at aaj halak ho gayi toh zameen par phir kabhi Teri ibadat na ki jayegi.",
                        englishTranslation = "O Allah! Should this group of Muslims be defeated today, You will no longer be worshipped on earth.",
                        reference = "Sahih Muslim 3/1384"
                    )
                ),
                reflectionUrdu = "Maadi asbaab kitnay hi kam hon, agar Allah ki nusrat aur roohani isteqamat sath ho toh fatah yaqeeni hoti hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Farishton Ki Nusrat Aur Kuffar Ki Shikast",
                titleEnglish = "Divine Reinforcement & Fall of the Tyrant",
                contentUrdu = """Subah hote hi jang shuru hui. Rasoolullah ﷺ ne ek mutthi mitti utha kar dushman ke lashkar ki taraf phenki aur farmaya: 'Shaahatil wujooh!' (Chehray bigad gaye!). Allah Ta'ala ne hawa ke zariye woh mitti har mushrik ki aankhon mein daal di.

Allah Ta'ala ne aasmaan se ek hazaar farishton ka lashkar nazil farmaya jo musalmano ke dosh-ba-dosh ladey. Hazrat Hamzah, Hazrat Ali aur deegar sahaba ne shuja'at ke azeem jawhar dikhaye.

Islam ka sab se bada dushman Abu Jahl do ansari noujawan bhaiyon (Mu'adh aur Mu'awwadh) ke hathon zakhmi hua aur Hazrat Abdullah bin Mas'ud (R.A) ne uska sar tan se juda kiya.

Kuffar ke 70 bade sardaar maare gaye aur 70 qaidi banaye gaye jabkay 14 musalman shaheed hue. Badr ki fatah ne sabit kar diya ke Islam ab Arab ki sab se taaqatwar quwwat ban chuka hai.""",
                contentEnglish = """Hurling a handful of dust, the Prophet shouted: 'Confusion seize their faces!'. Allah sent 1,000 angels in successive ranks. Hamzah and Ali displayed unmatched heroism. Abu Jahl was struck down by two young Ansar brothers and finished by Ibn Mas'ud. Seventy pagans were slain and seventy captured, marking an immortal triumph for Truth.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "وَمَا رَمَيْتَ إِذْ رَمَيْتَ وَلَٰكِنَّ اللَّهَ رَمَىٰ",
                        romanUrduTranslation = "Aur (Aye Nabi) aap ne nahi phenka jab aap ne phenka, balkay Allah ne phenka.",
                        englishTranslation = "And you threw not when you threw, but it was Allah who threw.",
                        reference = "Surah Al-Anfal 8:17"
                    )
                ),
                reflectionUrdu = "Ghamand aur takabbur ka anjam hamesha zillat aur ruswai hota hai."
            )
        )
    )

    val chapter12 = SeerahChapter(
        id = 12,
        titleUrdu = "Ghazwa-e-Uhud: Sabr Aur Ita'at Ka Dars",
        titleEnglish = "The Battle of Uhud - Lessons in Obedience",
        era = "Madani Daur",
        summaryUrdu = "Shawwal 3 Hijri, Badr ka intiqam lene 3000 kuffar ka hamla, Jabal-e-Rumaat ke teer-andazon ki ghalti, aur Hazrat Hamzah R.A ki shahadat.",
        pages = listOf(
            BookPage(
                pageNumber = 1,
                titleUrdu = "Uhud Ka Maidan Aur Teer-andazon Ka Dasta",
                titleEnglish = "The Archers' Strategic Hill",
                contentUrdu = """Badr ki shikast ka badla lene ke liye Quraish ne Abu Sufyan ki sarbarahi mein 3,000 ka bhari lashkar tayyar kiya. Nabi Kareem ﷺ 700 sahaba ke sath Uhud ke maidan mein pohanche.

Nabi Kareem ﷺ ne 50 mahir teer-andazon ka dasta Hazrat Abdullah bin Jubair (R.A) ki qiyadat mein ek pahaadi (Jabal-e-Ainain / Jabal-e-Rumaat) par taaynaat kiya aur sakht taakeed farmai:
'Chahe hum fatah paayein ya tum dekho ke parinday hamara gosht noach rahe hain, jab tak mera hukum na aaye apni jagah se hargiz mat hilna!'

Jang ke aaghaz mein musalmano ne kuffar ke chhakkay chhura diye aur dushman maidan chhorr kar bhaagne laga. Hazrat Abu Dujana (R.A) ne Nabi ﷺ ki talwar le kar shuja'at ki dastaan raqam ki.""",
                contentEnglish = """Seeking vengeance for Badr, Quraish mobilized 3,000 warriors at Mount Uhud. The Prophet stationed 50 skilled archers under Abdullah bin Jubair on Mount Ainain with strict orders never to abandon their post whether Muslims won or lost. Initially, Muslims swept through the pagan ranks in total victory.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "إِنْ رَأَيْتُمُونَا تَخْطَفُنَا الطَّيْرُ فَلَا تَبْرَحُوا مَكَانَكُمْ هَٰذَا حَتَّىٰ أُرْسِلَ إِلَيْكُمْ",
                        romanUrduTranslation = "Agar tum dekho ke parinday humein uchaak rahe hain, tab bhi apni is jagah se hargiz mat hilna jab tak main paigham na bhejun.",
                        englishTranslation = "If you see us snatched away by birds, do not leave this position of yours until I send for you.",
                        reference = "Sahih Al-Bukhari 1/426"
                    )
                ),
                reflectionUrdu = "Nabi Kareem ﷺ ke hukum ki mukammal pairwi hi dunya o aakhirat ki kamiyabi ki zamin hai."
            ),
            BookPage(
                pageNumber = 2,
                titleUrdu = "Aazmaish, Hazrat Hamzah (R.A) Ki Shahadat Aur Difaa-e-Rasool ﷺ",
                titleEnglish = "The Reversal & Valiant Defense",
                contentUrdu = """Fatah dekh kar 40 teer-andazon ne yeh samajh kar ke jang khatam ho gayi hai maal-e-ghaneemat jama karne ke liye pahaadi chhorr di, sirf 10 sahaba apnay ameer ke sath datay rahe.

Khalid bin Waleed (jo us waqt musalman nahi hue thay) ne peechay se ghoom kar pahaadi par hamla kiya, baaqi teer-andazon ko shaheed kiya aur musalmano par achanak peechay se hamla kar diya. Maidan mein achanak afra-tafri phail gayi.

Hazrat Hamzah bin Abdul Muttalib (R.A) ko Wahshi ne neza maar kar shaheed kar diya aur Hind bint Utbah ne unka kaleja chabaya.

Rasoolullah ﷺ par dushman ne hamla kiya, aap ke dandan-e-mubarak shaheed hue, rukhsaar zakhmi hua aur khod ki kadiyan dhas gayeen. Hazrat Talha bin Ubaidullah (R.A) ne apna haath dhaal bana kar Nabi ﷺ ke samnay kiya jis se unka haath shall ho gaya, aur Hazrat Abu Dujana (R.A) ne apni peeth par teeron ke waar sahay.

70 azeem sahaba shaheed hue magar musalmano ne Nabi ﷺ ke gird shairon ki tarah lad kar dushman ke naapaak iradon ko khaak mein mila diya.""",
                contentEnglish = """Forty archers deserted their post for spoils. Khalid bin Al-Waleed charged the exposed rear, turning the tide. Hamzah (R.A) was martyred by Wahshi. The Prophet's lower incisor was broken and helmet rings pierced his cheek. Talha (R.A) shielded him with his bare hand until paralyzed, and Abu Dujana absorbed arrows with his back.""",
                arabicQuotes = listOf(
                    ArabicQuote(
                        arabicText = "وَلَا تَهِنُوا وَلَا تَحْزَنُوا وَأَنتُمُ الْأَعْلَوْنَ إِن كُنتُم مُّؤْمِنِينَ",
                        romanUrduTranslation = "Aur sust mat bano aur gham na karo, tum hi ghalib raho ge agar tum momin ho.",
                        englishTranslation = "So do not weaken and do not grieve, and you will be superior if you are [true] believers.",
                        reference = "Surah Aal-e-Imran 3:139"
                    )
                ),
                reflectionUrdu = "Uhud ka waqia ummat-e-muslima ke liye qayamat tak ek sabak hai ke ita'at-e-Rasool ﷺ mein hi asil kamiyabi hai."
            )
        )
    )
}
