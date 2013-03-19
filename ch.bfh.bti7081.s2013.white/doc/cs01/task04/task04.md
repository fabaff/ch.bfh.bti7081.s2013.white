#Task 04

(see also the file "[questions.md](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/questions.md)")


## User Requirements


### Functional user requirements

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

### Non-functional requirements

- The application can be used on tablet during a consultation (main use).
- The application can be used on desktop when a psychotherapist is doing office work.
- Only a psychiatrist can do manipulations in medication management, a clinical psychologist has a read only access to the medication management functionality.
- The psychotherapist has full access (change, delete) to the data of patients, who are treated by him and read only access to the other patients.
- A psychotherapist can only change self created diagnosis entries, drug entries, order entries, process entries.
- The language of the application is german.

## System Requirements

### Functional system requirements

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

- An encrypted authentication is needed to enter the application.
- The data of all patients are stored in a central database.
- The database contains data of all patients and institutions who are using the application.
- A special tool is required to continuous update the database with changed patient and institution data (not in scope of this project). This will be done by the administration staff of an institution. 
- Medical catalogs (diagnosis, treatment, drugs) are integrated into the database and can be used in the application.
- Data protection act must be considered when the patient data will be stored in a central database.

## Summary

