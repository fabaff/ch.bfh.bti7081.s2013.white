#Requirements document (team white)

## Preface 
### Target audience
This document was written to describe the requirements for the MHC-PMS (MHC patient management system) in details. It includes every aspect of the system and focuses on the technical side. The reader should have a basis understanding of the healthcare section and information technology. 

### Authors
The author of this document is Team White (Marc Schärer, Arthur van Ommen, Patrick Kofmel, Fabian Affolter, and Alejandro Nuñez). 

### Document history

For details about the evolution of this document please check the 
[commit history](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/commits/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/requirements-document.md)
in the [git][1] repository. Or the command mentioned below:

```bash
$ git log
``` 

### Document releases

Major and minor releases of this document are listed in the table below.

| Release | Who             | Summary of changes                             |
|:--------|:----------------|:-----------------------------------------------|
| 0       | Team            | Creation of the document                       |
| 0.1     | Team            | Release after first day. Content added         |
| 0.2     | Team            | Content added                                  |

## Introduction 
Your regional health authority wishes to introduce a patient management system (PMS) to manage the care of patients suffering from mental health problems. The overall goals of the system will be:

1. To provide medical staff with timely information to facilitate the 
   treatment of patients.
2. To generate management information that allows health service managers
   to assess performance against local and government targets.

Most mental health patients do not require dedicated hospital treatment but need to attend specialist clinics regularly where they can meet a doctor who has detailed knowledge of their problems. The health authority has a number of clinics that patients may attend. To make it easier for patients to attend, these clinics are not just run in hospitals. They may also be held in local medical practices or community centres. Patients need not always attend the same clinic and some clinics may support ‘drop in’ as well as pre-arranged appointments.

The nature of mental health problems is such that patients are often disorganised so may miss appointments, deliberately or accidentally lose prescriptions and medication, forget instructions and make unreasonable demands on medical staff. In a minority of cases, they may be a danger to themselves or to other people. They may regularly change address and may be omeless on a long-term or short-term basis. Where patients are dangerous, they may need to be ‘sectioned’ – confined to a secure hospital for treatment and observation.

Users of the system include clinical staff (doctors, nurses, health visitors), receptionists who make appointments and medical records staff. Reports are generated for hospital management by medical records staff. Management have no direct access to the system.

The system is affected by two pieces of legislation:

1. Data Protection Act that governs the confidentiality of personal information
2. Mental Health Act that governs the compulsory detention of patients deemed
   to be a danger to themselves or others.

The system will NOT become a complete medical records system where all information about a patients medical treatment is maintained. It will solely intended to support mental health care so if a patient is suffering from some other unrelated  condition (such as high blood pressure) this would not be formally recorded in the system.

## Glossary
This section define the technical terms used in the document.

- **Clinic**: A clinic is a health care facility that provide ambulatory or hospitalized care for patients.
- **Diagnosis**: Medical diagnosis refers both to the process of attempting to determine or identify a possible disease or disorder (and diagnosis in this sense can also be termed (medical) diagnostic procedure), and to the opinion reached by this process (also being termed (medical) diagnostic opinion). From the point of view of statistics the diagnostic procedure involves classification tests. It is a major component of, for example, the procedure of a doctor's visit.
- **Drugs**: A drug is a substance which may have medicinal, intoxicating, performance enhancing or other effects when taken or put into a human body or the body of another animal and is not considered a food or exclusively a food.
- **DSM**: The Diagnostic and Statistical Manual of Mental Disorders is a classification system by the American Psychiatric Association. It's a complement to the corresponding sections in the ICD. 
- **History**: In this context, history means the complete list of past events all around the patient. For example, this includes treatment, drug prescriptions, orders given to nursing staff and so on.
- **ICD**: The International Statistical Classification of Diseases and Related Health Problems is a medical classification list published by the World Health Organization (WHO). It contains codes for diseases, signs and symptoms, abnormal findings, complaints, social circumstances, and external causes of injury or diseases. The postifx number marks the revision, ICD-10 is the 10th revision.
- **Order**: In this context, an order means an assignment from a therapist to nursing staff, administration staff or any other person, which is involved in the treatment and administrative process of the patient.
- **Patient**: A patient is any recipient of health care services. The patient is in need of treatment by a health care provider. In this case, this provider is a therapist.
- **Psychiatrist**: A psychiatrist is a physician who specializes in psychiatry. Psychiatrists are authorized to prescribe medicine, conduct physical examinations, order and interpret laboratory tests, and may order brain imaging studies such as computed tomography (CT/CAT Scan), magnetic resonance imaging (MRI), and positron emission tomography (PET) scanning. A psychiatrist has an MD.
- **Psychologist**: A psychologist evaluates, diagnoses, treats, and studies behavior and mental processes. Some psychologists, such as clinical and counseling psychologists, provide mental health care, and some psychologists, such as social or organizational psychologists conduct research, usually in university or other academic settings. A psychologist has a graduate degree (usually a PhD or MA).
- **PMS**: **P**atient **M**anagement **S**ystem
- **Therapist**: Psychotherapists employ a range of techniques based on experiential relationship building, dialogue, communication and behavior change that are designed to improve the mental health of a client or patient, or to improve group relationships (such as in a family).

## User requirements 

### Functional user requirements

#### 1. Read patient data 
- 1.1 Show all patients in a table on the home screen (from current case).
- 1.2 Search a specific patient.
- 1.3 Sort the patient table.
- 1.4 Filter the patient table.
- 1.5 Open the dossier of a specific patient from the start screen.
- 1.6 Show personal data of a specific patient.

#### 2. Read diagnosis 
- 2.1 Show all diagnosis of a patient (current case) in a table view. 
- 2.2 Show all diagnosis of a patient (current case) in a details view.
- 2.3 Filter the diagnosis of a patient.
- 2.4 Sort diagnosis of a patient.

#### 3. Change diagnosis
- 3.1 Add a new diagnosis for the current patient. 
- 3.2 Diagnose bearbeiten
- 3.3 Diagnose löschen

#### 4. Read medication
- 4.1 Show medication of a patient in a table view.
- 4.2 Filter the medication of a patient.
- 4.3 Sort medication of a patient.

#### 5. Change medication
- 5.1 Add a new medication for the current patient.  
- 5.2 Change an existing medication for the current patient.
- 5.3 Medikation löschen (nur möglich, wenn verordnete Medikation noch in der Zukunft liegt).

#### 6. Read ICD-10 catalog
- 6.1 Start the ICD-10 diagnosis catalog from the diagnosis screen.
- 6.2 Show the ICD-10 catalog in a table view.
- 6.3 Search in the ICD-10 catalog.
- 6.4 Sort the ICD-10 catalog entries.

#### 7. Read medication catalog
- 7.1 Start the medication catalog from the medication screen.
- 7.2 Show medication catalog in a table view.
- 7.3 Search in the medication catalog.
- 7.4 Sort the medication catalog entries.
 
#### 8. Verlauf lesen
- 8.1 Show Verlauf of a patient in a table view.
- 8.2 Show Verlauf of a patient in a details view.
- 8.3 Filter the Verlauf of a patient.
- 8.4 Search Verlauf entries.
- 8.5 Sort Verlauf entries.
 
#### 9. Verlauf bearbeiten
- 9.1 Add a new entry for the current patient.
- 9.2 Change an entry for the current patient.
- 9.3 Delete an entry for the current patient.

#### 10. Read Orders
- 10.1 Show orders to other medical staff in a table view.
- 10.2 Filter orders.
- 10.3 Sort orders.

#### 11. Change Orders
- 11.1 Add a new order for the current patient.
- 11.2 Change order for the current patient (Nur möglich, solange Auftrag noch nicht durch den Empfänger angenommen (bestätigt) wurde).
- 11.3 Auftrag für aktuellen Patienten löschen (Nur möglich, solange Auftrag noch nicht durch den Empfänger angenommen (bestätigt) wurde).
 
#### 12. Help system
- 12.1 Start the help system from every screen of the application.
- 12.2 Show the diffrent help topics: Navigation tree and description of selected topic.
- 12.3 Search with keywords in the help system.

#### 13. Fallinformationen anzeigen und bearbeiten
- 13.1 Fallinformationen anzeigen
- 13.2 Fallinformationen bearbeiten

#### 14. Neuen Patienten erfassen und Fall eröffnen
(falls Therapeut Nachtdienst macht und Eröffnung nicht durch die Administration durchgeführt werden kann)
- 14.1 Neuen Patienten erfassen
- 14.2 Fall eröffnen

#### 15. Neuen Fall eröffnen oder Fall abschliessen
(falls Therapeut Nachtdienst macht und Eröffnung nicht durch die Administration durchgeführt werden kann)
- 15.1 Neuen Fall eröffnen 
- 15.2 Fall abschliessen


### Non-functional user requirements

- The application can be used on tablet during a consultation or a meeting (main use).
- The application can be used on desktop when a theparist is doing office work.
- The language of the application is german. It should be possible to integrate a french language version at a later point (clinics in the romandie). 
- A therapist can only change data from own patients and the current case.
- Only a psychiatrist can do change in medication, a  psychologist has a read only access to the medication management functionality.
- Ein Psychologe darf keine medizinischen Verordnungen/ Aufträge durchführen.
- Login to the application with encrypted username and password.
- The data protection act must be considered.

## System architecture and system models 

The basic layout of the architecture will be a client-server web application with multiple layers. Details are visible in [this picture](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/system_architecture/Server.jpg).
- Web interface running in the browser
- Webserver
- Application server
- Database server

For maximum performance the database will be hosted on a dedicated server. Every connection between the participient of the backend will be encrypted with industrial standards. The clients will only access the web server on a encrypted channels. No unencrypted communication between the client and the server will be established or allowed. 


## System requirements specification 

### Functional system requirements

#### 0. General
- 0.1 Show basic patient information on all screens: first name, last name, gender, birthday, dangerousness of the patient (Selbstgefährdung, Fremdgefährdung), Reanimationsstatus 
- 0.2 Switch to an ancient case of the current patient if necessary (read only access) with the filter.
 - case status values: "Offen", "Abgeschlossen"
- 0.3 Show possible search results while typing (cp. Google).
- 0.4 The search and filter results show additional information: case status
- 0.5 The navigation list can be used as a sidebar in all details screens (On the left side of the screen). It can be expanded. This opens the home screen.
- 0.6 The selection of a medication implies an automatic selection of the "Wirkstoff".

#### 1. Read patient data 
- 1.1 Show all patients in a table on the home screen (current case): show status (only in search mode), first name, last name, birthdate, gender, kind of treatment (Behandlungsart), psychotherapist (current), clinics (hospitals or local medical practices).
 - Kind of treatment values: "ambulant", "teilstationär", "stationär" 
- 1.2 Search a specific patient: search by status ("Offen", "Abgeschlossen", "Alle"), first name, last name, birthdate, gender.
- 1.3 Sort the patient table: sort by all column names.
- 1.4 Filter the patient table: case status, own patients, department patients, clinic patients (Klinik/ Praxis), all patients.
- 1.5 Open the dossier of a specific patient from the start screen: personal data, diagnosis, drugs, history (Verlauf), orders to other staff.
- 1.6 Show personal data of a specific patient: 
 - case status: "Datum Falleröffnung", Datum Fallabschluss" (if available)
 - Zuweiser: "Selbst", "Psychiater"/ "Psychologe", "Hausarzt"
 - mother language, communication language, civil status, nationality, religion, adress, home location, postal code, country, phone private, phone business, mobile phone number, e-mail.
 - next of kin (Angehöriger): kind ("Bekannter", "Ehemann", "Ehefrau"), first name, last name, adress, phone.
 - family doctor (Hausarzt): first name, last name, adress, fax, ... 

#### 2. Read diagnosis 
- 2.1 Show all diagnosis of a patient (current case) in a table view. 
- 2.2 Show all diagnosis of a patient (current case) in a details view.
- 2.3 Filter the diagnosis of a patient.
- 2.4 Sort diagnosis of a patient.

- 2.1 Show all diagnosis of a patient (current case) in a table view:
 - diagnosis name, ICD code (ev. DSM code), date of creation, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- 2.2 Show the selected diagnosis of a patient in a details view.
 - name of the diagnosis, ICD code (ev. DSM code), comment of therapist (large field), date of creation, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- 2.3 Filter the diagnosis of one patient: status, self created diagnosis, diagnosis created by therapists from the same clinic, diagnosis created by all existing therapists.
- 2.4 Filter the diagnosis of multiple patients: status, current patient, all own patients, all patients from the same clinic, all existing patients.
- 2.5 Search diagnosis of patients: search by case status, first name, last name, birthdate, gender of the patient, name of the diagnosis, ICD code (ev. DSM code).
- 2.6 Sort diagnosis of patients: sort by all column names.

#### 3. Change diagnosis
- 3.1 Add a new diagnosis for the current patient. 
- 3.2 Diagnose bearbeiten
- 3.3 Diagnose löschen

- 3.1 Add a new diagnosis for the current patient: 
 - 3.1.1 select and save the name of the diagnosis (free text), ICD code (ev. DSM code) (drop down menu), comment of therapist (free text in large field)
 - 3.1.2 automatic completion: date of creation, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- 3.2 Diagnose bearbeiten
- 3.3 Diagnose löschen

#### 4. Read medication
- 4.1 Show medication of a patient in a table view.
- 4.2 Filter the medication of a patient.
- 4.3 Sort medication of a patient.

- 4.1 Show medication of patients in a table view:
 - 4.1.1 medication name ("Markenname"), "Wirkstoffe", "Verabreichungsform"
 - 4.1.2 timeline with all dates and a selectable date. Attributes: "verabreicht", "pausiert", "offen"
 - 4.1.3 point in time (Einnahmezeitpunkt am selektierten Tag), dose, unit 
- 4.2 Filter the medication of one patient: case status, self created medication, medication created by doctors from the same clinic, medication created by all existing doctors.
- 4.3 Filter the medication of multiple patients: case status, current patient, all own patients, all patients from the same clinic, all existing patients.
- 4.4 Search medication of patients: search by case status, first name, last name, gender, birthday, medication name ("Markenname"), "Wirkstoffe"
- 4.5 Sort medication of patients: sort by all column names.

#### 5. Change medication
- 5.1 Add a new medication for the current patient.  
- 5.2 Change an existing medication for the current patient.
- 5.3 Medikation löschen (nur möglich, wenn verordnete Medikation noch in der Zukunft liegt).

- 5.1 Add a new medication for the current patient: 
 - 5.1.1 medication name ("Markenname"), "Wirkstoffe", "Verabreichungsform", start date, end date (empty = "bis auf weiteres"), frequency (Häufigkeit), "Ausführungszeit", dose, unit
  - attributes of "Verabreichungsform": "per OS" (Mund), "I.V." (intravenös), "S.C." (subcutan = unter die Haut gespritzt), "I.M." (intramuskulär = in Muskel gespritzt), "topisch" (Oberflächlich, Salbe)
  - units: "Tropfen", "ml", "mg", "Applikation" (z.B. Salbe) 
  - frequency: "täglich", "jeden zweiten Tag",..., "Anzahl Tage", "jede Woche", "MO", "DI", "MI",...
  - "Ausführungszeit": "genaue Uhrzeit", "Morgen", "Mittag", "Abend", "Nacht"
 - 5.1.2 automatic completion: date of prescribing, prescribing person (doctor), clinic (hospital or local medical practice).  
- 5.2 Change an existing medication for the current own patient.

#### 6. Read ICD-10 catalog
- 6.1 Start the ICD-10 diagnosis catalog from the diagnosis screen.
- 6.2 Show the ICD-10 catalog in a table view.
- 6.3 Search in the ICD-10 catalog.
- 6.4 Sort the ICD-10 catalog entries.

- 6.1 Start the ICD-10 diagnosis catalog from the diagnosis screen.
- 6.2 Show the ICD-10 catalog in a table view: diagnosis name, ICD-10 code, diagnosis description.
- 6.3 Search in the ICD-10 catalog: search by diagnosis name, ICD-10 code.
- 6.4 Sort the ICD-10 catalog entries: sort by all column names.

#### 7. Read medication catalog
- 7.1 Start the medication catalog from the medication screen.
- 7.2 Show medication catalog in a table view.
- 7.3 Search in the medication catalog.
- 7.4 Sort the medication catalog entries.

- 7.1 Start the medication catalog from the medication screen.
- 7.2 Show medication catalog in a table view: medication name, "Wirkstoffe", medication description.
- 7.3 Filter medication catalog entries: Filter by "Wirkstoffe".
- 7.4 Search in the medication catalog: medication name, "Wirkstoffe".
- 7.5 Sort the medication catalog entries: sort by all column names.
 
#### 8. Verlauf lesen
- 8.1 Show Verlauf of a patient in a table view.
- 8.2 Show Verlauf of a patient in a details view.
- 8.3 Filter the Verlauf of a patient.
- 8.4 Search Verlauf entries.
- 8.5 Sort Verlauf entries.

- 8.2 Show history of patients in a table view: comment of therapist, date, responsable therapist, clinic.
- 8.5 Filter the history of one patient: case status, own entry, entries created by therapists from the same clinic, entries created by all existing therapists.
- 8.6 Filter the history of multiple patients: case status, current patient, all own patients, all patients from the same clinic, all existing patients.
- 8.7 Search history entries: search by case status, first name, last name, gender, birthday, date.
- 8.8 Sort history entries: sort by all column names.
 
#### 9. Verlauf bearbeiten
- 9.1 Add a new entry for the current patient.
- 9.2 Change an entry for the current patient.
- 9.3 Delete an entry for the current patient.

- 9.1 Add a new entry for the current patient: comment of therapist
 - automatic completion: date, responsable therapist, clinic.

#### 10. Read Orders
- 10.1 Show orders to other medical staff in a table view.
- 10.2 Filter orders.
- 10.3 Sort orders.

- 10.1 Show orders to other medical staff in a table view: acceptor of order, responsabe therapist, description, date, status, clinic, department of clinic.
 - acceptor of order: "Pflege", "Psychiater", "Psychologe", "Physiotherapeut", "Ergotherapeut", "Sozialarbeiter".
 - status: "verordnet", "begonnen", "beendet", "abgebrochen"
- 10.2 Search orders: serach by acceptor of order, responsabe therapist, date, status.
- 10.3 Sort orders: sort by all column names.

#### 11. Change Orders
- 11.1 Add a new order for the current patient.
- 11.2 Change order for the current patient (Nur möglich, solange Auftrag noch nicht durch den Empfänger angenommen (bestätigt) wurde).
- 11.3 Auftrag für aktuellen Patienten löschen (Nur möglich, solange Auftrag noch nicht durch den Empfänger angenommen (bestätigt) wurde).

- 11.1 Add new order for the current own patient: acceptor of order, responsabe therapist, description, date, status, clinic.
- 11.2 Change an existing order for the current own patient: status.
 
#### 12. Help system
- 12.1 Start the help system from every screen in the application.
- 12.2 Show the diffrent help topics: Navigation tree and description of selected topic.
- 12.3 Search with keywords in the help system.

#### 13. Fallinformationen anzeigen und bearbeiten
- 13.1 Fallinformationen anzeigen
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

### Domain requirements

- More information about the used medication parameters is needed: duration, frequency, point in time (morning, noon, evening, night), dose and dose unit by point in time (-> new meeting with a doctor).
- More information about the current used ICD-10 catalog is needed (-> new meeting with a doctor).
- More information about the current used medication catalogs is needed (-> new meeting with a doctor).


## System evolution
Based on the delivered information the initial hardware requirements will be set with a buffer. This reserve will make it possible to work with a larger user base and higher load on the systems. If the reserve runs out, extra hardware can be integrated easily. Due to the usage of state of the art virtualization technologies the whole life cycle of the MHC-PMS will be covered.

The software part of the system architecture will take into account that customer requirements may change. The design will allow easy upscaling of the application. The main focus will lie on more users and more patients.

Maintenance and bug fixing will be provided. Data protection issues will be fixed with a high priority.


## Testing 

For testing purposes a dummy database is needed. This means that a patient underlying data source must be ready at the start of the implementing phase. The format is open (full implemented database, simplified database, flat text file, etc.) but a source close to the layout which will be used for the final product is preferred.

The efficiency testing of the hardware and the software is planned as a simulation. According to the delivered information from the customer the test load will be specified in detail at a later point in time. 

There will be diffrent levels of testing:

Unit tests:
- All components of the system must be tested with Unit tests and all Units must run successfully before a new release.

System tests:
- There must be also integration tests for testing the functionality of the whole application.

Acceptance tests:
- It is important that the user (therapists) will be ready to accept the new application. A strong interaction with the users is required during the development of the applicarion.

Usability tests:
- The interface of the application will be tested by an Usability test with future users of the system. This shall avoid and minimize interface design faults. This test will increase the level of accteptance, too.

Security tests:
- To test the security of the application, the network connections, and the system design in general in short periods security test will provide detailed information about the level of security. This is necessary to gain and prove the grade which is required according to the Data protection.


## Appendices 

- [Use cases](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/use_cases/use-cases.md)
- [Use case scenario 2](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/use_case_scenarios/old_02-use-case-scenario.md)
- [Use case scenario 3](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/use_case_scenarios/use-cases-scenario-03.md)
- [Use case scenario 5](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/use_case_scenarios/use-cases-scenario-05.md)

[1]: http://git-scm.com/ "Git"
