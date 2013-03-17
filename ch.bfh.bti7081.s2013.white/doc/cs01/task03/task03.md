Task 03
=======
(see also the file "questions.md")


### 1. Scoping (Defining the problem) 
(presentation: Fabian)

- Developing a patient management system of patients suffering from mental health problems. 
- The target users are psychotherapists (doctors or psychologists) in mental health hospitals or local practices (named as "institution" in this text).
- The application can be used on tablets and notebooks (a smartphones-app is not convenient for psychotherapists needs).
- Focus on treatment related functionality and not general medical administration.
- Short time horizon: Constrains the feature scope of the application to a few key features.
- The success can be measured by a closely interaction with the target users (demo and validation for each functionality of the software).


### 2. Research 
(presentation: Patrick)

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
(presentation: Arthur)

- Persona (psychiatrist and clinical psychologist): see separate pictures
- Use case diagram: see separate pictures

#### User requirements (high level):
Functional:
- Show and search a specific patient.
- Show the dossier of a specific patient (personal data, diagnosis, drugs, orders to other staff, process (Verlauf)).
- Show personal data of a specific patient (name, birthday, gender, ...).
- Diagnosis of a patient (name, ICD-code, description, comment, date, responsible person, institution): show, search, add, change, delete a diagnosis
- Medication management (point in time, frequency, dose, responsible person, institution): show, search, add, change, delete a drug
- Orders to other staff (acceptor (Empfänger), description, date, remitter (Auftraggeber), institution): show, search, add, change, delete an order
- Process and event handling of a patient (event, comment, date, responsible person, institution): show, search, add, change, delete an event

Non-functional:
- The application can be used on tablet during a consultation (main use).
- The application can be used on desktop when a psychotherapist is doing office work.
- Only a psychiatrist can do manipulations in medication management, a clinical psychologist has a read only access to the medication management functionality.
- The psychotherapist has full access (change, delete) to the data of patients, who are treated by him and read only access to the other patients.
- A psychotherapist can only change self created diagnosis entries, drug entries, order entries, process entries.
- Data protection act must be considered.
- The language of the application is german.

### 4. Design 
(presentation: Marc)

#### Story board
(see also separate pictures)

#### Some (Non-functional) System requirements 
(in addition to user requirements, extensive system requirements are not yet possible at this point of the project)

- The data of all patients are stored in a central database.
- A special tool is rquired to continuous update the database with changed patient and institution data (not in scope of this project). This will be done by the administration staff of an institution. 
- An encrypted authentication is needed to enter the application.

### 5. Prototype 
(presentation: Patrick)

- Prototype: see separate pictures

- briefly document the what and how of your prototype

### 6. Validate 
(presentation: Fabian)

test your prototype with teammates, friends & family, or your teacher
- first define your evaluation questions
- then how you will find the answer
and document the results

- Full validation by users is not possible at the moment because of the short time horizon. 
 