#Task 04


## User Requirements

### Functional user requirements

#### 1. Read patient data 
- Show all patients in a table: show status, name, psychotherapist (current), clinics (hospitals or local medical practices).
- Search a specific patient: search by status, name, psychotherapist (current), clinics (hospitals or local medical practices).
- Sort the patient table: sort by status, name, psychotherapist (current), clinics (hospitals or local medical practices).
- Filter the patient table: filter own patients, clinic patients, all patients.
- Show the dossier of a specific patient: personal data, diagnosis, drugs, orders to other staff, history.
- Show personal data of a specific patient: first name, last name, gender, birthday, civil status, mother language, communication language, nationality, religion, adress, home location, postal code, country, phone private, phone business, mobile phone number, e-mail.

#### 2. Read diagnosis 
- Show diagnosis of a patient in a table and details view.
- The details view shows: name of the patient (optional), name of the diagnosis, ICD-code, date of creation, description of diagnosis, comment of therapist, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- The table view shows: name of the patient (optional), name of the diagnosis, ICD-code, date of creation, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- Filter the diagnosis of one patient: self created diagnosis, diagnosis created by therapists from the same clinic, diagnosis created by all existing therapists.
- Filter the diagnosis of multiple patients: current patient, all own patients, all patients from the same clinic, all existing patients.
- Search diagnosis: search by name of the patient, name of the diagnosis, ICD-code, date of creation, description of diagnosis, comment of therapist, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- Sort diagnosis: Sort by name of the patient, name of the diagnosis, ICD-code, date of creation, description of diagnosis, comment of therapist, diagnosis creator (therapist), clinic (hospital or local medical practice). 

#### 3. Change diagnosis
- Add a new diagnosis for the current patient: select and save the name of the diagnosis, ICD-code, date of creation, description of diagnosis, comment of therapist, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- Change an existing diagnosis for the current own patient: change and save the name of the diagnosis, ICD-code, date of creation, description of diagnosis, comment of therapist, diagnosis creator (therapist), clinic (hospital or local medical practice). 
- Delete an existing diagnosis for the current own patient.

#### 4. Read medication
 

- Medication management (point in time (morning, noon, evening, night), frequency, duration, dose, responsible person, institution): show, search, add, change, delete a drug
- Orders to other staff (acceptor (Empfänger), description, date, remitter (Auftraggeber), status, institution): show, search, add, change, delete an order
- Process and event handling of a patient (event, comment, date, responsible person, institution): show, search, add, change, delete an event
- Filter function: own patients, institution patients, all patients.
- Sort patients, diagnosis, drugs, processes and orders by different attributes.
- Start the ICD-10 diagnosis catalog from the diagnosis screen.
- Diagnosis catalog (ICD-10): search and show a diagnosis.
- Drugs catalog: search and show a drug.
- Start the help system from every screen of the application.

### Non-functional user requirements

- theparist can only change data from own patients.
- Login to the application with username and password.
- The application can be used on tablet during a consultation (main use).
- The application can be used on desktop when a psychotherapist is doing office work.
- Only a psychiatrist can do manipulations in medication management, a clinical psychologist has a read only access to the medication management functionality.
- The psychotherapist has full access (change, delete) to the data of patients, who are treated by him and read only access to the other patients.
- A psychotherapist can only change self created diagnosis entries, drug entries, order entries, process entries.
- The language of the application is german.

## System Requirements

### Functional system requirements

- Show and search a specific patient in the home screen (status, name, psychotherapist (current), institution).
- valid values
- search starts while typing
- Naviagationsliste
- 1. dimension Filter the diagnosis of this patient: self created diagnosis, diagnosis created by therapists from the same clinic, diagnosis created by all therapists.
- 2. dimension Filter the diagnosis of multiple patients: current patient, all own patients, all patients from the same clinic, all existing patients.
- search filter show filter
- change of icd-code, diag nmae change of description linked

- Show and search a specific patient (status, name, psychotherapist (current), institution).
- Show the dossier of a specific patient (personal data, diagnosis, drugs, orders to other staff, process (Verlauf)).
- Show personal data of a specific patient (name, birthday, gender, ...).
- Diagnosis of a patient (name, ICD-code, description, comment, date, responsible person, institution): show, search, add, change, delete a diagnosis
- Medication management (point in time (morning, noon, evening, night), frequency, duration, dose, responsible person, institution): show, search, add, change, delete a drug
- Orders to other staff (acceptor (Empfänger), description, date, remitter (Auftraggeber), status, institution): show, search, add, change, delete an order
- Process and event handling of a patient (event, comment, date, responsible person, institution): show, search, add, change, delete an event
- Filter function: own patients, institution patients, all patients.
- Sort patients, diagnosis, drugs, processes and orders by different attributes.
- Diagnosis catalog (ICD-10): search and show a diagnosis.
- Drugs catalog: search and show a drug.

### Non-functional system requirements

- login logout
- verschlüsselungsprotokoll angeben
- An encrypted authentication is needed to enter the application.
- The data of all patients are stored in a central database.
- The database contains data of all patients and institutions who are using the application.
- A special tool is required to continuous update the database with changed patient and institution data (not in scope of this project). This will be done by the administration staff of an institution. 
- Medical catalogs (diagnosis, treatment, drugs) are integrated into the database and can be used in the application.
- Data protection act must be considered when the patient data will be stored in a central database.

- TODO: interfaces to other systems

### Domain requirements

- Dosierung, Mengen, Einheiten der Medikamente
- drugs catalog

## Summary

