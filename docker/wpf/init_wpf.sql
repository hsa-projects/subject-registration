/*
 * WPF MySQL Creation Script - wpf.sql.
 */
-- Database-Level
-- DROP DATABASE IF EXISTS wpf; -- Delete if exists
-- CREATE DATABASE wpf; -- Create new database
USE wpf; --  Set the default (current) database
-- Table-Level
CREATE TABLE hsa_subject (
    id BINARY(16) NOT NULL,
    capacity SMALLINT NOT NULL,
    cp DECIMAL(3,1) NOT NULL,
    description MEDIUMTEXT,
    name VARCHAR(255) NOT NULL,
    professor VARCHAR(255) NOT NULL,
    specialization VARCHAR(255),
    status BIT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE hsa_registration (
    id BINARY(16) NOT NULL,
    semester TINYINT DEFAULT 1,
    student VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE hsa_registration_window (
    id VARCHAR(36) NOT NULL,
    end_date VARCHAR(255) NOT NULL,
    semester VARCHAR(255) NOT NULL,
    start_date VARCHAR(255) NOT NULL,
    primary key (id)
);

CREATE TABLE hsa_subject_selection
(
    id BINARY(16) NOT NULL,
    points SMALLINT NOT NULL,
    registration_id BINARY(16) NULL,
    subject_id      BINARY(16) NULL,
    PRIMARY KEY (id)
);

ALTER TABLE hsa_subject_selection
    ADD CONSTRAINT FK_registration_subject
        FOREIGN KEY (registration_id)
            REFERENCES hsa_registration (id);

ALTER TABLE hsa_subject_selection
    ADD CONSTRAINT FK_subject_registration
        FOREIGN KEY (subject_id)
            REFERENCES hsa_subject (id);

INSERT INTO hsa_subject (id, name, professor, cp, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Advanced Industrial Process and Information Management', 'Dipl.-Ing., Dipl.-Wirtschaftsing. Claudia Stöhler', 2.5, 'Es werden die Themen: Prozess-, Informations-, und Change- Ma-nagement aufgrund aktueller Konferenzunterlagen (Engl/Deutsch)und praktischer Beispiele erarbeitet. Diese werden über das Projekt-management in Bezug gesetzt zu den industriellen Kernprozessen:der Produktentwicklung und der Produktion. Eine Exkursion ist geplant.', '', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Advanced Security Testing', 'Dr.-Ing. Matthias Niedermaier', 5, 'Im Rahmen der Vorlesung werden folgende Themenbereicheder IT-Sicherheit beleuchtet: Netzwerksicherheit, Hardwaretests, Softwaretestmethoden. Es werden Schwachstellen und Schutzmaßnahmen praktischan aktuellen Geräten und Software durchgeführt. Die  Studierenden  müssen  in  Projektgruppen  eine  wissenschaftliche Fragestellung bearbeiten, hier werden Themenfel-der vertieft und der Stand der Forschung aufgegriffen', 'IT-Sicherheit (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Advanced Topics in Artificial Intelligence', 'Prof. Dr. Thomas Rist', 2.5, 'Im Modul werden ausgewählte aktuelle Forschungsarbeiten und An-wendungsfelder aus dem Bereich der Künstlichen Intelligenz behan-delt, darunter industrielle Anwendungen bis hin zu Computerspie-len, in denen Ansätzen zum Deep Learning und Reinforcement Lear-ning  zum  Einsatz  kommen.  Anhand  von  Forschungspublikationenarbeiten sich die Teilnehmer selbstständig in ein abgegrenztes The-menfeld  ein  und  stellen  dieses  im  Rahmen  eines  Seminarvortragsden anderen Modulteilnehmern vor.', 'Medieninformatik (A), Softwareengineering (A), IT-Sicherheit (A), Technische Informatik (C), Data Science (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Agile Innovationsentwicklung', 'Staber/Scharrer', 2.5, 'Innovationsprozesse  im  DIG  Zeitalter:  Ëin  komprimierter  GoogleVenture-style Design Sprint. Design Sprints sind ein praxiserprobter Mix aus Lean Startup,Design Thinking und Innovation, und sind bestens geeignet,um große Probleme oder Herausforderungen schnell zu lösen,neue Produkte zu entwickeln oder bestehende zu verbessern. Angesichts des kurzen Zeitrahmens konzentrieren sich DesignSprints nur auf einen Teil der Lösung, aber es ist eine hervor-ragende  Möglichkeit,  wirklich  schnell  zu  lernen,  ob  wir  aufdem richtigen Weg sind oder nicht. In einem Hands-on Workshop werden wir lernen wie man üblicherweise monatelange Arbeit auf wenige Tage komprimieren kann. Es werden keine Programmierkenntnisse vorausgesetzt.', '', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Agile meets Classic Project Management (ACPM)', 'Prof. Dr. Wolfgang Kowarschick', 2.5, 'Die Teilnehmer verstehen die grundlegenden Vorgehensweisen imklassischen und agilem Projektmanagement. Sie können verschiede-ne Projektmanagement Methoden anwenden und verstehen die Un-terschiede zwischen verschiedenen Projektmanagementart. Sie kön-nen diese miteinander verbinden und im Rahmen einer Fallstudieentwickeln Sie eigene Lösungsansätze für die Kombination von klassischen und agilen Projektmanagement.', 'Softwareengineering (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Agile Softwareentwicklung (Scrum)', 'Dipl.-Inf. (FH) Gregor Liebermann, M.Sc.', 5, 'Grundlagen:  Klassische und agile Entwicklungsmethoden, Agiles Manifest, Iteratives Vorgehen. Scrum:  Grundlagen und Motivation,  Anforderungsmanagement, Rollen und Meetings,  Sprints und Vorgehen, Releaseplanung. Das Team: Phasen der Teamentwicklung, Persönlichkeitsprofile, Kommunikation und Vier-Seiten-Modell, Teambuilding. Scrum Tools und Praxis: Scrum in der Praxis und mögliche Probleme, Continious Integration, Pair Programming, CVS und SVN, Bugtracking, Review Tools, Digital Taskboards. Weitere Agile Methoden: Extreme Programming, Crystal, FDD, Exkurs: Kanban, Exkurs: Design Thinking', 'Medieninformatik (A), Softwareengineering (A)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Agiles Projektmanagement', 'Prof. Dr. Claudia Reuter', 5, 'Das  Modul  vermittelt  den  Teilnehmenden  Wissen,  um  IT  Projekte nach agilen Projektmethoden zu planen, aufzusetzen und durchzuführen.', 'Softwareengineering (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Agile Webanwendungen mit Python', 'Dipl.-Inf. (FH) Dipl.-Designer (FH) Erich Seifert, MA', 5, 'Agile Entwicklungsmethoden, Test Driven Development, Webtechnologien (HTML, CSS, JavaScript), Softwarearchitektur für Webanwendungen, Einführung in verschiedene Python-Frameworks für die Web-entwicklung', 'Medieninformatik (A), Softwareengineering (B)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Anwendungen der Künstlichen Intelligenz', 'Prof. Dr. Thomas Rist', 5, 'Jeder Modulteilnehmer erhält eine konkrete praxisnahe Aufgaben-stellung und identifiziert dort mögliche Ansatzpunkte, für den Ein-satz einer oder mehrerer KI-Techniken, wie z.B. heuristische Suche,Constraint Verarbeitung, Handlungsplanung, regelbasierte Wissens-verarbeitung, logische und probabilistische Inferenz, Ma-schinellesLernen, Deep Learning, oder Data Mining. Aufgabenstellungen kön-nen auch von den Modulteilnehmern vorgeschlagen werden, wobeiinsbesondere auf einer Vorarbeit (z.B. aus dem Praxissemester oderder Bachelorarbeit) aufgebaut werden darf.In  Absprache  mit  der  Lehrkraft  erarbeiten  die  Modulteilnehmereinen Lösungsansatz, der einen Teilaspekt der Aufgabenstellung miteiner oder mehreren KI-Techniken bearbeitet. Im Anschluss erstel-len die Modulteilnehmer rudimentäre Proof-of-Concept Implemen-tierungen ihrer Lösungsansätze, wobei vorzugsweise verfügbare KI-Werkzeuge  und  KI-Bibliotheken  zum  Einsatz  kommen.  Bei  hinrei-chender Komplexität und in Absprache mit der Lehrkraft kann eineImplementierung auch im Team bearbeitet werden.Abschließend erfolgt eine Bewertung des Lösungsansatzes hinsicht-lich gängiger Gütekriterien wie Performance, Ressourcenbedarf, Ska-lierbarkeit, Entwicklungsaufwand und Wartbarkeit.', 'Medieninformatik (A), Softwareengineering (A), IT-Sicherheit (A), Technische Informatik (C), Data Science (A)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Business Process Application Programming', 'Dipl.-Inf. (FH) Dipl.-Designer (FH) Erich Seifert, MA', 5, 'Grundlagen   der   Anbieter-unabhängigen   Webprogrammierung; Einführung in aktuelle Web-UI-Technologien mit praktischen Übungen; Recherchen, Analysen und Bewertungen aktueller Veröffentlichungen zu Themen rund um Anwendungsprogrammierung mit Schwerpunkt auf Webanwendungen im kommerziellenBereich.', 'Softwareengineering (A)', true, '10');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Business Process Modelling', 'Prof. Dr. Nikolaus Müssigmann', 5, 'Die fortschreitende Digitalisierung hat in den Unternehmen zur Folge, dass die Prozesse auch immer stärker digitalisiert und wenn mög-lich automatisiert werden. Deshalb beschäftigt sich das Modul mit dem Business Process Livecycle; der Darstellung der Prozesslandkarte; der BPMN – Business Process Modeling and Notation; der DMN – Decision Model and Notation; der CMMN – Case Management Model and Notation; des Einsatzes von t.BPM; der Automatisierung von Prozessen; den Aufgaben einer Business Process Engine; dem praktischen Einsatz von Automatisierungswerkzeugen.', '', false, '10');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Chancen- & Risikomanagement in Digitalisierten Wertschöpfungsnetzen', 'Häckel', 2.5, '', '', false, '10');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Compiler', 'Prof. Dr. Jürgen Scholz', 5, 'In dieser Vorlesung wird die Funktionsweise und der von Parsernüber Scanner bis zu Compilern erarbeitet. Hierbei wird der sinnvolle Einsatz von Werkzeugen basierend auf den theoretischen Grundlagen beschrieben. Zunächst werden die theoretischen Grundlagen des Compilerbaus - die formalen Sprachen und die Automaten - erarbeitet. Hier wird ein Schwerpunkt auf CH-2 und CH-3 Sprachen gesetzt, die für Compiler besonders relevant sind. Aufbauend auf der Theorie wird danndie praktische Realisierung des Übersetzerbaus besprochen. Der Wegführt zur Konstruktion von Programmen zur lexikalischen und syn-taktischen Analyse. Deren konkrete Realisierung wird an Hand allgemein verwendeter Programme veranschaulicht. Hierbei wird ein Compiler mit Hilfe gängiger Werkzeuge erstellt. Formale Sprachen; Lexikalische Analyse; Die Syntaxanalyse; Semantische Analyse; Compiler-Generatoren; AST: Abstrakter Syntax-Baum; Code-Optimierung', 'Softwareengineering (A), IT-Sicherheit (A), Technische Informatik (C)', false, '10');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Computer Games Development', 'B.A. Philip McClenaghan', 5, 'Das Modul wird in englischer Sprache unterrichtet. The aim of this course is to provide students with an understandingof computer game theory and design. This is not a technical course.Conceptual design and critical analysis exercises allow students toexplore a range of relevant topics in order to gain the ability to lookat computer games objectively and from an informed standpoint. In-dependent research projects enable students to gain indepth know-ledge of specific aspects of computer games design. Students presenttheir work (in English) both verbally and in written form throughpresentations, analysis documentation and research reports.', 'Medieninformatik (A), Softwareengineering (A)', false, '10');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Computer Vision: Algorithmen und Hardware Strukturen', 'Kiefer', 5, '', 'Technische Informatik (C)', false, '10');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Control & Automation', 'Elektrotechnik', 5, '', 'Technische Informatik (C)', true, '20');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Critical-Chain-Projektmanagement', 'Prof. Dr. Wolfgang Kowarschick', 2.5, 'Zu Beginn der Veranstaltung werden die wesentlichen Begriffe desCritical-Chain-Projektmanagements  definiert:  Projektziele,  Projekt-beteiligte, Aufgaben des Managements (Menschenführung, Risiko-management, Planung, Kontrolle) und Projekterfolg. Nach einer Ein-führung  in  das  Risikomanagement  wird  der  Projektverlauf  näheruntersucht: Phasen und Vorgänge, Wasserfall- und Spiralmodell, V-Modell XT. Darauf aufbauend werden verschiedene Schätzmethodensowie  deren  Vor-  und  Nachteile  vorgestellt.  Anschließend  werdengängige Planungstechniken diskutiert: Work Breakdown Structures,Netzpläne, Balkendiagramme, Kostenplanung. Ein Schwerpunktthe-ma  ist  dabei  die  Methode  der  kritischen  Kette  (an  Stelle  des  kri-tischen Pfades) und das damit verbundene Puffermanagement (alssehr wichtiger Bestandteil des Risikomanagements). Abschließendwerden die Themengebiete „Projektkontrolle anhand des Puffermanagements“ und „Earned-Value-Analyse“ diskutiert. Parallel zu den klassischen Planungs- und Kontrollthemen wird während  des  gesamten  Semesters  immer  wieder  die  Wichtigkeit  derMenschenführung betont. Wichtige Aspekte sind hierbei: Führungsstile, Teamarbeit, Motivation und Vermeidung von Druck.', '', false, '20');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Cryptography and Security', 'Prof. Dr. rer. nat. Helia Hollmann', 5, 'Das Modul wird in englischer Sprache unterrichtet. IT security deals with the protection of IT systems against attacks.Today, not only servers and PCs are interconnected and exposed toattackers, but also industrial systems are more and more digitalizedand  vulnerable.  Therefore,  security  engineering  and  managementbecome mandatory topics in almost any industry sector.This course teaches the fundamentals of cryptography and IT security and details common security management practices. It providesstudents with a solid knowledge how to approach typical securitychallenges. The topics of this course are: Fundamentals of IT Security (Basic Terms, Protection Goals and Attacker Classification, Common Attacks); Cryptography (Symmetric and asymmetric cryptographic algorithms, Cryptographic protocols, Secure hash functions, Pseudo random number generators and tests); Secure Development Lifecycle (Threat and Risk Analysis, Secure Engineering Principles, Penetration Testing, Incident Response Handling);  Everyday Security Topics (Device Protection, Secure Communication, Network Security, Key Management, Identity and Access Management)', 'IT-Sicherheit (A), Technische Informatik (C)', true, '20');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Data Mining und Informationssysteme', 'Gestaltung', 5, '', 'Data Science (A)', false, '20');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Data Science', 'Prof. Dr.-Ing. Honorary Doctor of ONPU Thorsten Schöler', 5, 'Das Modul wird in englischer Sprache unterrichtet, wenn erforderlich auch in deutscher Sprache. Statistics and classification, Machine Learning, Deep learning, Toolkits, Datenkraken, Sensor data fusion', 'Data Science (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Datenbanken Vertiefung', 'Prof. Dr. Sabine Müllenbach', '5', 'Schwerpunkt ist die Architektur eines Datenbanksystems von der Ab-laufintegrität des DBMS bis zur physischen Organisation der Daten-bank.  Ausgehend  von  den  Transaktionsanforderungen  werden  dieTransaktionslevel  und  die  Sperrkonzepte  erarbeitet  sowie  die  Me-chanismen für Logging, Recovery und Memory-Verwaltung erlernt.Die physische Organisation beleuchtet die Struktur der Datenspei-cherung  sowie  die  Zugriffsunterstützung.  Datenbank-Tuning  wirdam Beispiel des RDBMS Oracle sowohl von der physischen Seite undder Zugriffsunterstützung wie von der Seite des RDBMS mittels der Optimizer und auch vom Zusammenspiel mit dem Betriebssystemuntersucht. Weitere Themen sind die Skalierbarkeit von Datenbanksystemen wie z.B. mittels RAC (Real Application Cluster).', 'Softwareengineering (A), Technische Informatik (C), Data Science (A)', false, '20');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Datenkommunikation im Fahrzeug', 'Prof. Dr.-Ing. Thomas Kirchmeier', 5, 'Die Veranstaltung veranschaulicht anhand von praktischen Beispielen den grundlegenden Aufbau und Funktionsweise eines Fahrzeuges aus Sicht der Datenübertragung. Dabei werden in kleinen Teams einzelne Fahrzeugfunktionen programmiert, die anschließend mittels CommonAPI und SOMEIP miteinander interagieren. Dies verdeutlicht die Fahrzeugdaten kommunikation simulativ und adressiert die folgenden Themenbereiche: Crash course in C++ und cmake; Verwendung einer C++ GUI wie wxWidgets;  Fahrzeugarchitektur; Umsetzung einfacher Fahrzeugfunktionen in C++ und dessen; Visualisierung; Grundlegende  Kommunikationssysteme  im  Fahrzeug,  vom
Feldbus zur IP-Kommunikation; SOMEIP und ServiceDiscovery; Bedatung und Schnittstellenmodelierung; Trace- und Fehleranalyse; Funktionale  Sicherheit  und  der  Umgang  mit  „unsicheren“; Kommunikationskanälen; Zeitsynchronisation im Fahrzeug; Security in der Fahrzeugkommunikation', 'Technische Informatik (C)', false, '20');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Datenvisualisierung', 'Prof. Dr. Wolfgang Kowarschick', 5, 'Die Studierenden arbeiten in Kleingruppen mit verteilten Schwer-punkten.  Jede  Arbeitsgruppe  befasst  sich  –  von  einer  Kommuni-kationsaufgabe ausgehend – mit entsprechenden Datenpools und -schemata. Im Laufe der Veranstaltung entwickelt jede Gruppe Kon-zepte,  die  schlüssig  von  der  Datenbeschaffung  über  Datenanalysehin zu statischen oder dynamischen Datenvisualisierungen führen.Realisiert werden diese Visualisierungen mit Hilfe moderner Web-Technologien.Potenzielle  und  auftretende  Herausforderungen  und  Lösungsmög-lichkeiten werden regelmäßig mit allen Kursteilnehmern analysiertund diskutiert. Die Ergebnisse und ihr Entstehungsprozess werdengruppenweise allen Kursteilnehmern zum Semesterende präsentiert.', 'Medieninformatik (A), Data Science (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Digital Biz Implementation - Go to Market', 'Schwager', 5, '', '', true, '20');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Digital Business Leadership Skills', 'Prof. Dr. Norbert Gerth', 7.5, '', '', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Digital Innovation Thinking', 'Seemiller', 2.5, '', '', false, '20');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Digitale Bildverarbeitung ', 'Prof. Dr. Peter Rösch', 7.5, '', 'Medieninformatik (A), Technische Informatik (C), Data Science (A)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'E-Commerce', 'Prof. Dr. Norbert Gerth', 7.5, '', '', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Effiziente Rechner- und Systemarchitekturen', 'Prof. Dr. Gundolf Kiefer', 5, '', 'Technische Informatik (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Einführung in die IT Forensik', 'Schulik', 7.5, '', 'IT-Sicherheit (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Embedded Linux', 'Prof. Dr. Hubert Högl', 7.5, '', 'Softwareengineering (A), Technische Informatik (C)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Embedded Security', 'Prof. Dr.-Ing. Dominik Merli', 5, '', 'IT-Sicherheit (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Enterprise Architecture Management', 'Prof. Dr. Stephan Zimmermann', 5, '', '', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Existenzgründung', 'Prof. Dr. Norbert Gerth', 6, '', '', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Fahrzeug zu Fahrzeug Kommunikation', 'Prof. Dr. Alexander von Bodisco', 5, '', 'IT-Sicherheit (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Führungsmanagement', 'M.A. Katharina Heimrath', 5, '', '', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'General Management', 'Prof. Dr. Norbert Gerth', 5, '', '', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Hardware und Software für das Internet der Dinge ', 'Prof. Dr. Volodymyr Brovkov', 5, '', 'Medieninformatik (A), Softwareengineering (A), Technische Informatik (C)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Haskell: Introduction to Functional Programming', 'Armyanov', 2.5, '', 'Softwareengineering (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Incident Response', 'Elektrotechnik', 5, '', 'IT-Sicherheit (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Informationssysteme', 'Prof. Dr. Sabine Müllenbach', 5, '', 'Medieninformatik (A), Softwareengineering (A), Technische Informatik (C), Data Science (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Interaction Engineering', 'Prof. Dr. Michael Kipp', 5, '', 'Medieninformatik (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Interaktive Computergrafik', 'Prof. Dr. Peter Rösch', 7.5, '', 'Medieninformatik (A), Technische Informatik (C)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'International Project Management', 'Espe', 5, '', '', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'IT-Sicherheit ', 'Prof. Dr.-Ing. Dominik Merli/Prof. Lothar Braun', 7.5, '', 'IT-Sicherheit (A), Technische Informatik (C)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Javascript', 'Johannes Ewald, M.Sc.', 2.5, '', 'Medieninformatik (A), Softwareengineering (B), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Klassische Projekttechniken modernisiert', 'Prof. Dr. Wolfgang Kowarschick', 5, '', '', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Management Of Large Projects', 'Dipl.-Ing., Dipl.-Wirtschaftsing. Claudia Stöhler', 2.5, '', 'Softwareengineering (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Medizinische Bildverarbeitung', 'Prof. Dr. Peter Rösch', 5, '', 'Medieninformatik (A), Data Science (A)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Mustererkennung und maschinelles Lernen', 'Prof. Dr.-Ing. Alexandra Teynor', 5, '', 'Medieninformatik (A), Technische Informatik (C), Data Science (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Nebenläufige Programmierung', 'Meixner', 5, '', 'Softwareengineering (A), IT-Sicherheit (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Nebenläufigkeit', 'Prof. Dr.-Ing. Christian Märtin', 5, '', 'Softwareengineering (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Network Penetration Testing', 'Dr. Lothar Braun', 5, '', 'IT-Sicherheit (A), Technische Informatik (C)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Network Programming ', 'Prof. Dr. Rolf Winter', 5, '', 'Softwareengineering (A), IT-Sicherheit (A), Technische Informatik (B)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Neuronale Netze und Deep Learning', 'Prof. Dr. Michael Kipp', 5, '', 'Softwareengineering (A)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Object Oriented Software Development for Business Processes', 'Dipl.-Inf. (FH) Dipl.-Designer (FH) Erich Seifert, MA', 5, '', 'Softwareengineering (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Open-Source Softwareentwicklung', 'Prof. Dr. Hubert Högl', 5, '', 'Medieninformatik (A), Softwareengineering (A), Technische Informatik (C)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Personalführung', 'Dipl.-Ing. Ulrich Rose', 2.5, '', '', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Plattformübergreifende Entwicklung mit Qt', 'Prof. Dr. Rolf Winter', 6, '', 'Medieninformatik (A), Softwareengineering (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Praktische Robotik mit Matlab', 'Prof. Dr. Rolf Stark', 7.5, '', 'Technische Informatik (C), Data Science (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Project Jupyter', 'Prof. Dr. Nik Klever', 5, '', '', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Robotik mit Matlab', 'Prof. Dr. Rolf Stark', 5, '', 'Technische Informatik (C), Data Science (A)',false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Security', 'Prof. Dr.-Ing. Dominik Merli', 2.5, '', 'Softwareengineering (A), IT-Sicherheit (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Sichere Geschäftsprozesse', 'Prof. Dr. Björn Häckel/Weide', 5, '', 'IT-Sicherheit (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Sichere Konzepte und Protokolle', 'Elektrotechnik', 5, '', 'IT-Sicherheit (A), Technische Informatik (B)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Sicheres C Programmieren in Embedded Systemen', 'Elektrotechnik', 2.5, '', 'Softwareengineering (A), IT-Sicherheit (A), Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Simulationsgestützte Leistungsbewertung', 'Prof. Dr. Alexander von Bodisco', 5, '', 'IT-Sicherheit (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Single-Page Webanwendungen mit TS und Angular', 'Prof. Dr. Phillip Heidegger', 5, '', 'Medieninformatik (A), Softwareengineering (B)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Software Defined Radio', 'Franz G. Aletsee, M.Sc.', 5, '', 'IT-Sicherheit (A),  Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Software-Projektmanagement', 'Märtin', 5, '', 'Softwareengineering (A)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Softwareentwicklung mit Cloud-Technologie', 'Prof. Dr. Phillip Heidegger', 5, '', 'Softwareengineering (A, B),  Technische Informatik (C)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'SW-Architekturen in Java', 'Meixner', 7.5, '', 'Softwareengineering (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Usability Engineering', 'Prof. Dr.-Ing. Christian Märtin/Dipl.-Wirt.-Inf. (FH) Christian Herdin, M.Sc.', 5, '', 'Softwareengineering (A)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Vermittlung informationstechnischer Inhalte', 'Prof. Dr. Jürgen Scholz', 2.5, '', '', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Web-Entwicklung Node.js ', 'Michael Jaser, M. Sc.', 5, '', 'Medieninformatik (A), Softwareengineering (B)', false, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Web-Technologien', 'Dipl. Designer (FH) Fabian Ziegler', 5, '', 'Medieninformatik (A), Softwareengineering (B)', true, '30');

INSERT INTO hsa_subject (id, name, professor, CP, description, specialization, status, capacity)
VALUES (UNHEX(REPLACE((SELECT uuid()), '-', '')),'Zertifizierungsmodul', 'Elektrotechnik', 5, '', 'IT-Sicherheit (A), Technische Informatik (C)', false, '30');