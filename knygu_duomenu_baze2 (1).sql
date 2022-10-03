-- phpMyAdmin SQL Dump
-- version 5.1.1
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 30, 2022 at 02:36 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- https://www.phpmyadmin.net/
--
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `knygu_duomenu_baze2`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;
CREATE TABLE IF NOT EXISTS `kategorija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pavadinimas` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kategorija`
--

INSERT INTO `kategorija` (`id`, `pavadinimas`) VALUES
(1, 'Meilės romanai'),
(2, 'Fantastika'),
(3, 'Detektyvai'),
(4, 'Trileriai'),
(5, 'Biografija'),
(7, 'Poezija');

-- --------------------------------------------------------

--
-- Table structure for table `knygos`
--

DROP TABLE IF EXISTS `knygos`;
CREATE TABLE IF NOT EXISTS `knygos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) DEFAULT NULL,
  `autorius` varchar(255) DEFAULT NULL,
  `nuotrauka` varchar(255) DEFAULT NULL,
  `pavadinimas` varchar(255) DEFAULT NULL,
  `puslapiu_skaicius` int(11) NOT NULL,
  `santrauka` varchar(1000) DEFAULT NULL,
  `kategorijos_id` int(11) DEFAULT NULL,
  `skaitytojo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhues2n341r5m9bgg7krc1ov83` (`kategorijos_id`),
  KEY `FKnr53qn6rwet71dwjtute6j8qm` (`skaitytojo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `knygos`
--

INSERT INTO `knygos` (`id`, `isbn`, `autorius`, `nuotrauka`, `pavadinimas`, `puslapiu_skaicius`, `santrauka`, `kategorijos_id`, `skaitytojo_id`) VALUES
(2, '9786094444531', 'Laura Madeleine', 'https://thumb.knygos-static.lt/O3S_DmxuPG7EZag3Ju2kLIHLQ3w=/fit-in/0x800/images/books/2671485/1648206040_Skandalo_atgarsiai_768x1152_1.jpg', 'Skandalo atgarsiai', 300, 'Alechandra, už akių vadinama mišrūne, nepažinojo savo tėvų ir augo prižiūrima viešnamio šeimininkės. Nepatyrusi šilumos ir atjautos, saugų prieglobstį rado tik viešnamio virėjo Ifrahimo kompanijoje – jis išmokė merginą įvairiausių gudrybių, kaip pamaloninti įnoringų klientų gomurius. ', 1, 3),
(3, '9786090307700', 'Virginia Heath', 'https://thumb.knygos-static.lt/QleEmEqHQR41Cu-lYD8o0UPMPmY=/fit-in/0x800/images/books/2660452/1644564333_3D-Negailestingi_mainai_150dpi.jpg', 'Negailestingi mainai', 400, 'prieš kelerius metus Ovenas Vulfas buvo neteisingai apkaltintas ledi Lidijos Barton šeimos brangakmenių vagyste ir griežtai nubaustas. Dabar jis grįžo iš tremties ir Lidijai vėl tenka susitikti su juo! Vis dėlto ji turi ir rimtesnių rūpesčių – laukia santuoka iš išskaičiavimo. Netikėtai Ovenas, siekdamas gauti Lidijos ranką, pateikia jos tėvui patrauklų pasiūlymą.', 1, 3),
(6, '9786094844263', '	Christoffer Hols ', '	https://thumb.knygos-static.lt/Crf3QlHRLcYo6epzMSl9NAofh5I=/fit-in/0x800/images/books/2666991/1644586163_Purpurinis_vasaros_sapnas_virselis_3D_obuolys_LT_04-1.jpg	', 'Purpurinis vasaros sapnas', 304, 'Silos Storm, gyvenimo būdo žurnalistės, karjera klostosi nekaip, o dar skyrybos su mylimuoju ir tuščios sąskaitos... Svajones apie tolimus fjordus tenka pamiršti, nes santaupų užtenka tik sodo sklypeliui su miniatiūriniu nameliu Bulholmene – turistų pamėgtame spalvingame Stokholmo archipelage. ', 3, 3),
(7, '9786094444500', '	M.W. Craven ', 'https://thumb.knygos-static.lt/1d788vt8Y6TlTThUuuruAYqQBIg=/fit-in/0x800/images/books/2660438/1642412600_marioneciu-pasirodymas.jpg', 'Marionetės', 352, 'Kambrijos grafystėje siautėja šiurpą keliantis serijinis žudikas, pramintas Aukotoju. Jis degina vyrus iki pelenų ir laidoja juos ypatingoje kapavietėje – neolito laikus menančiuose akmeniniuose ratuose. ', 3, 3),
(8, '9786094900716', '	Peter James', 'https://thumb.knygos-static.lt/La5aKD_7-_VDXmnBs-iSwRIqXhM=/fit-in/0x800/images/books/2657186/1639738566_9786094900716_susimausi_galas_1639395625.jpg', '	Susimausi – galas (Rojus Greisas, #14)', 368, '	Sėkmingas verslininkas Kipas Braunas ypač priklausomas nuo lošimo ir dabar išgyvena baisiausią gyvenime pralaimėjimų seriją. Viskas ima slysti iš rankų, gresia bankrotas. Visgi, jis nusprendžia su savo sūnumi Mangu apsilankyti šeštadieninėse namų komandos futbolo varžybose, kad nors kiek praskaidrintų nuotaiką. Tačiau futbolo stadione ir prasideda jo baisiausias košmaras.', 3, 4),
(9, '9786094666384', '	Mason Cross ', '	https://thumb.knygos-static.lt/HyPAHtrT7B8e1CqPeh2FnmZBnz4=/fit-in/0x800/images/books/2612791/1623911785_neieskok-manes-1.jpg', 'Neieškok manęs. Karteris Bleikas. 4', 352, '	MASON CROSS (Meisonas Krosas) – britų autorius, išgarsėjęs trilerių serija apie Karterį Bleiką – žmogų, kuris neturi nei vardo, nei tapatybės, tik talentą rasti tuos, kurie daro viską, kad jų būtų neįmanoma rasti. Nors Bleiko pašonėje visuomet atsiduria netikėtas partneris, padedantis narplioti nusikaltimus, Karteris Bleikas yra vienišas kovotojas, trokštantis ramybės, tačiau niekaip jos nerandantis. Lietuviškai jau išleistos pirmosios trys Karterio Bleiko serijos knygos: „Žudymo sezonas“, „Samarietis“ ir „Metas žudyti“. Ketvirtajame trileryje „Neieškok manęs“ Bleikui tenka surasti ir gelbėti su pavojingais žmonėmis susidėjusią mylimą moterį.', 3, 4),
(10, '9786090148495', '	Karsten Dusse ', 'https://thumb.knygos-static.lt/_P1ANBpPhTcq2Pt0uWzxAgABkH8=/fit-in/0x800/images/books/2642681/1635402132_Demesingo-isisamoninimo-vadovas-zudikui.jpg', 'Dėmesingo įsisąmoninimo vadovas žudikui', 400, 'Žmona Bjornui Dymeliui tėškė ultimatumą, todėl dabar jis turi lankyti dėmesingo įsisąmoninimo kursus, arba jo santuoka nutrūks. Bjornas – sėkmingai dirbantis baudžiamosios teisės advokatas ir rasti laiko šeimai jam labai sunku. Vis dėlto jis pats siekia tapti geresniu tėvu, be to, nori surasti darbo ir asmeninio gyvenimo pusiausvyrą, todėl ima lankytis pas koučerį Jošką Breitnerį.', 4, 4),
(11, '9786094900402', 'Sebastian Fitzek ', '	https://thumb.knygos-static.lt/mPTPD-d3Sh8GbrMxFI0u2vmiRv4=/fit-in/0x800/images/books/2640621/1633516419_dovana_1633501761.jpg', 'Dovana', 352, 'Milanas Bergas laukia prie šviesoforo, kai šalia sustoja automobilis. Ant užpakalinės sėdynės sėdi persigandusi, nevilties apimta mergaitė ir spaudžia raštelį prie stiklo. Ar tai pagalbos prašymas? Milanas negali jo perskaityti, nes jis beraštis! Vienas iš daugiau nei šešių milijonų Vokietijoje gyvenančių rašto nepažįstančių žmonių. Vis dėlto vyras įtaria — mergaitei gresia mirtinas pavojus. ', 4, 5),
(12, '9786094034428', 'Alfonso Signorini ', '	https://thumb.knygos-static.lt/r02mBdtvhqiAjvxjhcIEU2_z69I=/fit-in/0x800/images/books/13469/1613547476_Gyvenu_tik_karta_COCO_virselis_3D_obuolys_LT_04.jpg', '	COCO CHANEL: Gyvenu tik kartą – intriguojanti legendinės mados ikonos biografija!', 384, '	Yra daug hercogienių, bet tik viena Chanel. Taip Coco Chanel atsakė Vestminsterio hercogui, kai šis pasiūlė jai tekėti. Chanel – vardas, simbolizuojantis didingą mados imperiją, amžiną stilių, tobulą kvepalų aromatą ir šiuolaikinę moterį, nebijančią imti gyvenimo vairo į savo rankas. Intriguoja? Žinoma! ', 5, 5),
(13, '9789986094982', '	Deirdre Bair', 'https://thumb.knygos-static.lt/-LeyD0cmqhG-_ja_2G-yM7bkYZs=/fit-in/0x800/images/books/1476748/1574080772_123.png', '	Jung: biografija', 864, '	Analitinės psichologijos kūrėjas Carlas Gustavas Jungas, su kurio vardu siejamos sąvokos kolektyvinė pasąmonė, archetipai, anima, animus, šešėlis, persona ir kt., buvo viena iš dviejų (šalia Freudo) iškiliausių asmenybių nesutarimų kupinoje XX a. psichoanalizės istorijoje. Ir kartu bene prieštaringiausiai vertinama. Minios žmonių iš viso pasaulio plūdo į Ciurichą susipažinti su jo darbo metodais ar gydytis pas jį. Jis turėjo daugybę ištikimų šalininkų, tačiau netrūko ir aršių priešininkų, kurie kaltino jį būtais ir nebūtais dalykais.', 5, 5),
(14, '9789955605867', '	Andrzej Franaszek', '	https://thumb.knygos-static.lt/TpLdZuL-PQFgmtz1Uur3FGM7RQE=/fit-in/0x800/images/books/786762/1462886469_6649.jpg', '	Miloszas. Biografija', 976, '	Iki šiol išsamiausia vieno žymiausių XX amžiaus pasaulio poetų – vienintelio iš Lietuvos kilusio Nobelio literatūros premijos laureato – Czesławo Miłoszo (Česlovo Milošo, 1911–2004) biografija, kurioje artimai siejamas asmeninis jo gyvenimas, kultūrinė, intelektualinė ir politinė aplinka bei jo kūrybos bruožai ir tendencijos. ', 5, 6),
(15, '9786094441486', '	Anthony Burgess ', 'https://thumb.knygos-static.lt/QFHxaYM81UYLnjEMXmN59vZ9xzU=/fit-in/0x800/images/books/892004/1462887202_9786094441486sekspyrasbiografija.jpg', 'Šekspyras. Biografija', 320, '	Vos išgirdę Šekspyro pavardę pagalvojame apie „Hamletą“ ar „Romeo ir Džiuljetą“. Puikiai žinome kūrinius, tačiau didžiausio pasaulio rašytojo gyvenimą, net ir prabėgus daugiau kaip 400 metų, gaubia paslaptis. Ar Šekspyro santuoka buvo laiminga? O gal širdį atveriančius meilės sonetus jis rašė paslaptingai meilužei?.. Kas buvo jo geriausias draugas ir kam atiteko palikimas?.. ', 5, 6),
(25, '9786090147320', 'Ramūnas Kasparavičius', 'https://thumb.knygos-static.lt/vf1bULA7x_ALK7aflusJf968c_k=/fit-in/0x800/filters:cwatermark(static/wm.png,500,75,30)/images/books/1450492/1562247498_kasparavicius-poezija_1561992093.jpg', 'Poezija', 304, '„Ramūnas Kasparavičius šiandien geriau žinomas kaip itin įdomus ir savitas prozininkas. Tačiau pirmiausia jis debiutavo kaip poetas ir yra išleidęs tris eilėraščių rinkinius: „Ramios saulės metai Laimingiausias rugsėjis', 7, 1),
(26, '9786090306604', 'Leila Meachem', 'https://thumb.knygos-static.lt/E0e_BQEAy2ZtZxfQcqt7UO5kYbA=/fit-in/0x800/filters:cwatermark(static/wm.png,500,75,30)/images/books/2318642/1603871810_3D-ROZES_150dpi.jpg', 'Rožės', 609, '„Rožės\" – pirmą kartą lietuvių kalba leidžiamas Leilos Meacham romanas, pelnęs jai pasaulinę šlovę, lyginamas su tokiais laikui nepavaldžiais kūriniais kaip „Erškėčių paukščiai\" ir „Vėjo nublokšti\". Knyga yra išversta į daugiau nei dvidešimt kalbų ir turi daugiau nei 65 leidimus.', 1, 1),
(27, '9786090147320', 'Elizabeth Macneal', 'https://thumb.knygos-static.lt/p2pC_dkteHoiJK3rAVOSPT_oGqU=/fit-in/0x800/images/books/2637198/1631775839_Stebuklu-cirkas.jpg', 'Dėstytojo Dovydo knyga', 300, 'Gotikinis romanas, kuriame vienos moters gyvenimą iš pagrindų pakeičia karalienėsViktorijos laikais taip mėgtas keistenybių cirkas', 1, 1),
(28, '9786090147320', 'Elizabeth Macneal', 'https://thumb.knygos-static.lt/p2pC_dkteHoiJK3rAVOSPT_oGqU=/fit-in/0x800/images/books/2637198/1631775839_Stebuklu-cirkas.jpg', 'Prieraišumo galia', 300, 'Gotikinis romanas, kuriame vienos moters gyvenimą iš pagrindų pakeičia karalienėsViktorijos laikais taip mėgtas keistenybių cirkas', 1, 3),
(29, '9786094844263', '	Christoffer Hols ', '	https://thumb.knygos-static.lt/Crf3QlHRLcYo6epzMSl9NAofh5I=/fit-in/0x800/images/books/2666991/1644586163_Purpurinis_vasaros_sapnas_virselis_3D_obuolys_LT_04-1.jpg	', 'labas labas', 304, 'Silos Storm, gyvenimo būdo žurnalistės, karjera klostosi nekaip, o dar skyrybos su mylimuoju ir tuščios sąskaitos... Svajones apie tolimus fjordus tenka pamiršti, nes santaupų užtenka tik sodo sklypeliui su miniatiūriniu nameliu Bulholmene – turistų pamėgtame spalvingame Stokholmo archipelage. ', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `privilegijos`
--

DROP TABLE IF EXISTS `privilegijos`;
CREATE TABLE IF NOT EXISTS `privilegijos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vardas` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `privilegijos`
--

INSERT INTO `privilegijos` (`id`, `vardas`) VALUES
(1, 'READ_PRIVILEGE'),
(2, 'WRITE_PRIVILEGE');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vardas` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `vardas`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `roles_privilegijos`
--

DROP TABLE IF EXISTS `roles_privilegijos`;
CREATE TABLE IF NOT EXISTS `roles_privilegijos` (
  `roles_id` bigint(20) NOT NULL,
  `privilegijos_id` bigint(20) NOT NULL,
  PRIMARY KEY (`privilegijos_id`,`roles_id`),
  KEY `FKq5e7yfko37wouu08uykpi53h` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles_privilegijos`
--

INSERT INTO `roles_privilegijos` (`roles_id`, `privilegijos_id`) VALUES
(1, 1),
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `skaitytojas`
--

DROP TABLE IF EXISTS `skaitytojas`;
CREATE TABLE IF NOT EXISTS `skaitytojas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `prisijungimo_vardas` varchar(255) DEFAULT NULL,
  `slaptazodis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skaitytojas`
--

INSERT INTO `skaitytojas` (`id`, `enabled`, `prisijungimo_vardas`, `slaptazodis`) VALUES
(1, b'1', 'Test', 'test'),
(2, b'1', 'Mantas', 'Mantauskas'),
(3, b'1', 'Dovydas', 'Raizekas'),
(5, b'1', 'Test', 'test'),
(6, b'1', 'Test', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `sujungimas_megstamos_knygos`
--

DROP TABLE IF EXISTS `sujungimas_megstamos_knygos`;
CREATE TABLE IF NOT EXISTS `sujungimas_megstamos_knygos` (
  `skaitytojas_id` bigint(20) NOT NULL,
  `knygos_id` bigint(20) NOT NULL,
  PRIMARY KEY (`knygos_id`,`skaitytojas_id`),
  KEY `FKp5u1okfncowhd096e1w5na4` (`skaitytojas_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sujungimas_megstamos_knygos`
--

INSERT INTO `sujungimas_megstamos_knygos` (`skaitytojas_id`, `knygos_id`) VALUES
(1, 3),
(1, 6),
(1, 9),
(1, 10),
(1, 14),
(2, 8),
(2, 12),
(2, 13),
(2, 15),
(3, 3),
(3, 6),
(3, 7),
(3, 11);

-- --------------------------------------------------------

--
-- Table structure for table `vartotoju_roles`
--

DROP TABLE IF EXISTS `vartotoju_roles`;
CREATE TABLE IF NOT EXISTS `vartotoju_roles` (
  `skaitytojo_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`roles_id`,`skaitytojo_id`),
  KEY `FKdq8o5quilumhd5ba782ker4bg` (`skaitytojo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vartotoju_roles`
--

INSERT INTO `vartotoju_roles` (`skaitytojo_id`, `roles_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 1),
(5, 2),
(6, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `knygos`
--
ALTER TABLE `knygos`
  ADD CONSTRAINT `FKhues2n341r5m9bgg7krc1ov83` FOREIGN KEY (`kategorijos_id`) REFERENCES `kategorija` (`id`),
  ADD CONSTRAINT `FKnr53qn6rwet71dwjtute6j8qm` FOREIGN KEY (`skaitytojo_id`) REFERENCES `skaitytojas` (`id`);

--
-- Constraints for table `roles_privilegijos`
--
ALTER TABLE `roles_privilegijos`
  ADD CONSTRAINT `FKcstidwkko1i18oq8n5iaufaqw` FOREIGN KEY (`privilegijos_id`) REFERENCES `privilegijos` (`id`),
  ADD CONSTRAINT `FKq5e7yfko37wouu08uykpi53h` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`);

--
-- Constraints for table `sujungimas_megstamos_knygos`
--
ALTER TABLE `sujungimas_megstamos_knygos`
  ADD CONSTRAINT `FK50da11q18huap2sbqk5ljkmva` FOREIGN KEY (`knygos_id`) REFERENCES `knygos` (`id`),
  ADD CONSTRAINT `FKp5u1okfncowhd096e1w5na4` FOREIGN KEY (`skaitytojas_id`) REFERENCES `skaitytojas` (`id`);

--
-- Constraints for table `vartotoju_roles`
--
ALTER TABLE `vartotoju_roles`
  ADD CONSTRAINT `FK8phbiv1buvkfbiedsxa86ymg0` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKdq8o5quilumhd5ba782ker4bg` FOREIGN KEY (`skaitytojo_id`) REFERENCES `skaitytojas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
