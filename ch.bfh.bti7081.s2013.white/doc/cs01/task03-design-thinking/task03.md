Task 03
=======
(see also the file "[questions.md](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/questions.md)")


### 1. Scoping (Defining the problem) 

- Developing a patient management system of patients suffering from mental health problems. 
- The target users are psychotherapists (doctors or psychologists) in mental health hospitals or local practices (named as "institution" in this text).
- The application can be used on tablets and notebooks (a smartphones-app is not convenient for psychotherapists needs).
- Focus on treatment related functionality and not general medical administration.
- Short time horizon: Constrains the feature scope of the application to a few key features.
- The success can be measured by a closely interaction with the target users (demo and validation for each functionality of the software).

### 2. Research 

- Interview with a doctor (inner medicine) from the "Inselspital".
- Short demo of the "Krankenhausinformationssystem" (KIS) (CGM Phoenix) from the "Inselspital".
- A KIS is a highly complex system with a huge amount of functionality related to a hospital.

#### Some general questions:
Which is the most important part of the KIS from the doctors perspective?
- Patient treatment (diagnosis, medication management, orders to other staff, process (Verlauf)).

What is the most important information about a patient from the doctors perspective?
- Personal data (name, age, gender, ...)
- Diagnosis
- Drugs
- Treatment process

How are the appointments of a doctor fixed?
- The appointments are fixed outside the KIS.
- Every doctor manges his own peripheral appointment plan.
- The appointment time often changes in short term.

Communication between doctors and other hospital staff?
- A doctor have the possibility to give orders (Aufträge) to the other hospital staff (nurses, administration) via the KIS.
- Diffrent person groups (doctors, nurses, administration) use different versions of the KIS (specifically tailored for their purposes).

#### Some specific questions about psychiatry:
Differentiation of psychiatrist and clinical psychologist?
- both are psychotherapists
- A psychiatrist is a doctor, who is specialized in psychiatry and can prescribe drugs.
- A clinical psychologist is a psychologist, who has a special education in psychotherapy, but can't prescribe drugs (in general).

How are consultations in the psychiatry organized?
- In general, a psychotherapist has a fixed room and the consultations are carried out in this room.


### 3. Synthesize 

#### User requirements
(date: 18.03.2013)

Functional:
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

Non-functional:
- The application can be used on tablet during a consultation (main use).
- The application can be used on desktop when a psychotherapist is doing office work.
- Only a psychiatrist can do manipulations in medication management, a clinical psychologist has a read only access to the medication management functionality.
- The psychotherapist has full access (change, delete) to the data of patients, who are treated by him and read only access to the other patients.
- A psychotherapist can only change self created diagnosis entries, drug entries, order entries, process entries.
- The language of the application is german.

#### Persona

##### Psychiatrist: 
- Name and Title: Dr. med. Max Müller
- Age: 45
- Married
- 2 children

Max Müller has received his doctorate from the University of Berne. He successfully completed his post doc in New York.
He's been working as a psychiatrist in a large psychiatrie near Berne for over 7 years. A year ago he became the assistant medical doctor.
He often visits conferences and is a fan of new technologies. His hobbies include reading, biking, hiking, and his family.

##### Psychologist:
- Name and Title:  M.Sc. Selina Schmid
- Age: 30
- Single
- no children

Selina Schmid has just received her master of science degree in psychology at the University of Berne.
She has just begun working at the same large psychiatrie near Berne.
Her hobbies include pc gaming and hiking.

#### Use case scenario

* **No. and name**            : **2** New diagnosis
* **Scenario**                : Create a new diagnosis for an existing user
* **Description**             : An existing patient visits a doctor with a new problem, so he has to open a new case/diagnosis
* **Engaged party**           : Therapist
* **Trigger / Pre condition** : A patient comes with a new problem, patient must exist in database
* **Results / Post condition**: The new diagnosis is logged in the patient medical record database

Sequence

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 1    |Therapist  |Login with personal username and password  |
| 2    |Therapist  |Search for the patient  |
| 3    |Therapist  |Select patient from list  |
| 4    |Therapist  |Open medical history of patient  |
| 5    |Therapist  |Click select an exisiting record  |
| 6    |Therapist  |Click on add new information  |
| 7    |Therapist  |Add a name for the record  |
| 8    |Therapist  |Insert a description  |
| 9    |Therapist  |Save the new record to the medical record database  |

Exceptions, variations

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 2.1  |Nurse  |Patient record must have been created before  |
| 3.1  |Therapist  |Wrong user selected   |
| 3.2  |Therapist  |Click on back to return to search list   |
| 8.1  |Therapist  |Optional: Select different doctor or hospital  |
| 8.2  |Therapist  |Optional: Insert comments  |
| 4    |  |  |
| 5    |  |  |
| 6    |  |  |

#### Use case Diagram
Please check [Use Cases](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/03-synthesize/use-cases.jpg).

### 4. Design

#### Some (non-functional) system requirements 
(in addition to user requirements; extensive system requirements are not yet possible at this point of the project; date: 18.03.2013)

- An encrypted authentication is needed to enter the application.
- The data of all patients are stored in a central database.
- The database contains data of all patients and institutions who are using the application.
- A special tool is required to continuous update the database with changed patient and institution data (not in scope of this project). This will be done by the administration staff of an institution. 
- Medical catalogs (diagnosis, treatment, drugs) are integrated into the database and can be used in the application.
- Data protection act must be considered when the patient data will be stored in a central database.

#### Storyboard

- Therapist and patient meet
- Therapist informs himself about the patients history
- The patient tells the therapist about his condition
- The therapist informs himself by using the ICD10 (references) (optionally)
- Therapist creates a diagnosis
- Therapist prescribes medicine (optionally) (only psychiatrist, not psychologist)
- Therapist passes an order (optionally)
- The patient leaves


### 5. Prototype 

- The prototype is signed on several sketchboards (see separate pictures)
- It shows the functionality described in the user requirements and the storyboard.

***Files***:
- [Home](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/01_Prototype_Home.jpg)
- [Patient](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/02_Prototype_Patient.jpg)
- [Diagnose](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/03_Prototype_Diagnosen.jpg)
- [Diagnose bearbeiten](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/04_Prototype_Diagnosen_bearbeiten.jpg)
- [Medikamente](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/05_Prototype_Medikamente.jpg)
- [Medikamente bearbeiten](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/06_Prototype_Medikamente_bearbeiten.jpg)
- [Kataloge](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/07_Prototype_Kataloge.jpg)
- [Verlauf](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/08_Prototype_Verlauf.jpg)
- [Auftraege](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task03/05-prototype/02-final_task03/09_Prototype_Auftraege.jpg)


### 6. Validate 

- Functionality added to prototype during the validation: diagnosis catalog (ICD-10) and drugs catalog.
- Finally the prototype covers the main functionality used by a psychotherapist in his daily work with patients.
- Full validation by users is not possible at the moment because of the short time horizon. 
 
