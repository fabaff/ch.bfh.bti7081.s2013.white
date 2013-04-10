## System requirements specification 

### Functional system requirements

#### 0. General
- 0.1 Show basic patient information on all screens: first name, last name, gender, birthday
- 0.2 Switch to an ancient case of the current patient if necessary (read only access) with the filter.
 - case status values: "Offen", "Abgeschlossen"
- 0.3 Show possible search results while typing (cp. Google).
- 0.4 The navigation list can be used as a sidebar in all details screens (On the left side of the screen). It can be expanded. This opens the home screen.
- 0.5 Mit Vor-/ Zurück-Button links unten auf dem Screen zum nächsten/ vorherigen Patienten navigieren.
- 0.6 Daten aus abgeschlossenen Fällen sind read-only und farblich gekennzeichnet.

#### 1. Read patient data 
- 1.1 Show all patients in a table on the home screen (current case): show case status, first name, last name, birthdate, gender, kind of treatment (Behandlungsart), psychotherapist (current), clinics (hospitals or local medical practices).
 - Kind of treatment values: "ambulant", "teilstationär", "stationär" 
- 1.2 Search a specific patient: search by status ("Offen", "Abgeschlossen", "Alle"), first name, last name, birthdate, gender, Zeitfenster (Anfangs- und Enddatum).
- 1.3 Sort the patient table: sort by all column names.
- 1.4 Filter the patient table: case status, own patients, department patients, clinic patients (Klinik/ Praxis), all patients.
- 1.5 Open the dossier of a specific patient from the start screen: personal data, Fallinformation, diagnosis, drugs, Verlauf, orders to other staff.
- 1.6 Show personal data of a specific patient:  
 - mother language, communication language, civil status, nationality, religion, adress, home location, postal code, country, phone private, phone business, mobile phone number, e-mail.
 - next of kin (Angehöriger): kind ("Bekannter", "Ehemann", "Ehefrau"), first name, last name, adress, phone.
 - family doctor (Hausarzt): first name, last name, adress, fax, ... 

#### 2. Read diagnosis 
- 2.1 Show all diagnosis of a patient (current case) in a table view. 
 - diagnosis name, ICD code, date of creation, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- 2.2 Show all diagnosis of a patient (current case) in a details view.
 - diagnosis name, ICD code, Beschreibung, Kommentar, date of creation, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- 2.3 Filter the diagnosis of a patient: aktueller Fall, abgeschlossene Fälle, alle Fälle
- 2.4 Sort diagnosis of a patient: sort by all column names.

#### 3. Change diagnosis
- 3.1 Add a new diagnosis for the current patient. 
 - 3.1.1 select and save the name of the diagnosis (free text), ICD code (drop down menu), Beschreibung der Diagnose (Textfeld), comment of therapist (free text in large field)
 - 3.1.2 automatic completion: date of creation, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- 3.2 Diagnose bearbeiten (wird in der Datenbank als geändert markiert und geloggt).
- 3.3 Diagnose löschen (wird in Datenbank als gelöscht markiert und geloggt).

#### 4. Read medication
- 4.1 Show medication of a patient in a table view.
 - 4.1.1 medication name ("Markenname"), "Wirkstoffe", "Verabreichungsform"
 - 4.1.2 timeline with all dates und aktuellem Status: verordnet (durchgezogene Linie), pausiert (gestrichelt), offen (leer),  gestoppt (gepunktet), verweigert
 - 4.1.3 Details für einen Tag mit Mouseover oder Finger-Touch auf Feld: Einnahmezeitpunkte an diesem Tag, Dosierungen, Einheiten.
- 4.2 Filter the medication of a patient: aktueller Fall, abgeschlossene Fälle, alle Fälle.
- 4.3 Sort medication of a patient: sort by all column names.
- 4.4 Vor- und Zurück-Button zur Datums-Navigation (Tage, Monate).

#### 5. Change medication
- 5.1 Add a new medication for the current patient. 
 - 5.1.1 medication name ("Markenname"), "Wirkstoffe", "Verabreichungsform", start date, end date (empty = "bis auf weiteres"), frequency (Häufigkeit), "Ausführungszeit", dose, unit
  - attributes of "Verabreichungsform": "per OS" (Mund), "I.V." (intravenös), "S.C." (subcutan = unter die Haut gespritzt), "I.M." (intramuskulär = in Muskel gespritzt), "topisch" (Oberflächlich, Salbe)
  - units: "Tropfen", "ml", "mg", "Applikation" (z.B. Salbe) 
  - frequency: "täglich", "jeden zweiten Tag",..., "Anzahl Tage", "jede Woche", "MO", "DI", "MI",...
  - "Ausführungszeit": "genaue Uhrzeit", "Morgen", "Mittag", "Abend", "Nacht"
 - 5.1.2 automatic completion: date of prescribing, prescribing person (doctor), clinic (hospital or local medical practice).   
- 5.2 Change an existing medication for the current patient.
- 5.3 Medikation löschen (nur möglich, wenn verordnete Medikation noch in der Zukunft liegt).
- 5.4 Medikation stoppen.

#### 6. Read ICD-10 catalog
- 6.1 Start the ICD-10 diagnosis catalog from the diagnosis screen.
- 6.2 Show the ICD-10 catalog in a table view: diagnosis name, ICD-10 code, diagnosis description.
- 6.3 Search in the ICD-10 catalog: Suche nach Stichworten.
- 6.4 Sort the ICD-10 catalog entries. sort by all column names.

#### 7. Read medication catalog
- 7.1 Start the medication catalog from the medication screen.
- 7.2 Show medication catalog in a table view (Arztneimittel-Kompendium kompendium.ch): medication name, "Wirkstoffe", medication description.
- 7.3 Search in the medication catalog: Markenname, Wirkstoffe
- 7.4 Sort the medication catalog entries: sort by all column names.
 
#### 8. Verlauf lesen
- 8.1 Show Verlauf of a patient in a table view: comment of therapist, date, responsable therapist, clinic.
- 8.2 Show Verlauf of a patient in a details view: comment of therapist, date, responsable therapist, clinic.
- 8.3 Filter the Verlauf of a patient: aktueller Fall, abgeschlossene Fälle, alle Fälle.
- 8.4 Search Verlauf entries:nach Stichwort suchen
- 8.5 Sort Verlauf entries: sort by all column names.
 
#### 9. Verlauf bearbeiten
- 9.1 Add a new entry for the current patient: comment of therapist.
 - automatic completion: date, responsable therapist, clinic.
- 9.2 Change an entry for the current patient.
- 9.3 Delete an entry for the current patient. 

#### 10. Read Orders
- 10.1 Show orders to other medical staff in a table view: acceptor of order, responsabe therapist, description, date, status, clinic, department of clinic.
 - acceptor of order: "Pflege", "Psychiater", "Psychologe", "Physiotherapeut", "Ergotherapeut", "Sozialarbeiter".
 - status: "verordnet", "begonnen", "beendet", "abgebrochen".
- 10.2 Filter orders: aktueller Fall, abgeschlossene Fälle, alle Fälle.
- 10.3 Sort orders: sort by all column names.

#### 11. Change Orders
- 11.1 Add a new order for the current patient: acceptor of order, responsabe therapist, description, date, status, clinic.
- 11.2 Change order for the current patient (Nur möglich, solange Auftrag noch nicht durch den Empfänger begonnen (bestätigt) wurde).
- 11.3 Auftrag für aktuellen Patienten löschen (Nur möglich, solange Auftrag noch nicht durch den Empfänger begonnen (bestätigt) wurde).

#### 12. Help system
- 12.1 Start the help system from every screen in the application.
- 12.2 Show the diffrent help topics: Navigation tree and description of selected topic.
- 12.3 Search with keywords in the help system.

#### 13. Fallinformationen anzeigen und bearbeiten
- 13.1 Fallinformationen anzeigen:
 - Datum Falleröffnung
 - Datum Fallabschluss" (if available)
 - Reanimationsstatus: Ja, eingeschränkt (nur Medikamente), nein, anderer (Freitext)
 - Zuweiser: Psychiater, Psychologe, Hausarzt, Dienstarzt, Spital, andere Institution, Andere (Freitext).
 - Suizidal (Selbstgefährdung): „suizidal und absprachefähig“, „akut und nicht absprachefähig“
 - Fremdgefährdung: Gefährdung gegenüber Personal, andere Patienten, Dritten (Freitext).
 - Ausgang: alleine, Garten, Gruppe -> Freitext
 - Urlaub: spezielle Abwesenheit, Zahnarzt, am WE heim gehen (Freitext).
 - Juristischer Status: Freiwillig, per ärztliche fürsorgerische Unterbringung (äFU) (höchstens 6 Wochen), ordentliche fürsorgerische Unterbringung (von Behörden veranlasst -> KESB (Kindes- und Erwachsenenschutzbehörde oder Gericht)
 - Zwangsmassnahmen: Pat. Fixiert, Zwangsmedikation
 - Patientenverfügung vorhanden: Ja oder nein
- 13.2 Fallinformationen bearbeiten	

#### 14. Neuen Patienten erfassen und Fall eröffnen
(falls Therapeut Nachtdienst macht und Eröffnung nicht durch die Administration durchgeführt werden kann)
- 14.1 Neuen Patienten erfassen
- 14.2 Fall eröffnen

#### 15. Neuen Fall eröffnen oder Fall abschliessen
(falls Therapeut Nachtdienst macht und Eröffnung nicht durch die Administration durchgeführt werden kann)
- 15.1 Neuen Fall eröffnen 
- 15.2 Fall abschliessen

### Non-functional system requirements

#### Platform
- The application can be used on tablet during a consultation or a meeting.
- The application can be used on desktop when a therapist is doing office work.

#### Data access restriction
- A therapist can only change data from own patients and the current case.
- Only a psychiatrist can do change in medication, a  psychologist has a read only access to the medication management functionality.
- Ein Psychologe darf keine medizinischen Verordnungen/ Aufträge durchführen.

#### Data protection and Law
- An encrypted authentication is needed to enter the application (username and password).
- The data protection act must be considered: A https connection is used for all transactions between client and server.

#### Architecture and interfaces
- The data of all patients are stored in a central database. This makes it possible to access the needed data from all clinics.
- Medical catalogs (diagnosis, medication) are integrated into the database and can be used in the application.
- A special tool is required to continuous update the database with changed patient and clinic data (not in scope of this project). This will be done by the administration staff of a clinic. 
- There must be interfaces to PMS applications from other medical users (nurses, administration staff).

#### Multi language
- The language of the application is german. It should be possible to integrate a french language version at a later point (clinics in the romandie). 
