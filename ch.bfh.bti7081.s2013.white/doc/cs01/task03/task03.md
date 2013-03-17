Task 03
=======
(see also the file "questions.md")


### 1. Scoping (Defining the problem) 
(presentation: Fabian)

- Developing a patient management system of patients suffering from mental health problems. 
- The target users are psychotherapists (doctors and psychologists) in clinics (mental health hospials and local medical practices).
- The application can be used on tablets and notebooks (a smartphones-app is not convenient for psychotherapists needs).
- Focus on treatment related functionality and not general medical administration.
- Short time horizon: Constrain the feature scope of the application to a few key features.
- The success can be measured by a closely interaction with the target users (demo and validation for each functionality of the software).


### 2. Research 
(presentation: Patrick)

- Interview with a doctor (inner medicine) from the "Inselspital".
- Short demo of the "Krankenhausinformationssystem" (KIS) (CGM Phoenix) from the "Inselspital".
- A KIS is a highly complex system with a huge amount of functionality related to a hospital.

#### Some general questions:
Which is the most important part of the KIS from the doctors perspective?
- Patient treatment (diagnosis, medication management, process (Verlauf)).

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
- A doctor have the possibility to give orders (Aufträge) to the other hospital staff (doctors, nurses, administration) via the KIS.
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

- Persona: see separate pictures
- Use case diagram: see separate pictures


#### User requirements (high level):
Functional:
- Show personal data of each patient
- Diagnosis of a patient: show, add, update, delete
- Drug management (point in time, frequency, dose): show, add, update, delete
- Orders to other clinical staff: show, add, update, delete
- Process and event handling of a patient: show, add, update, delete
Non-functional:
- psychotherapists tablet
- Berechtungungen psych


### 4. Design 
(presentation: Marc)

- Story board: see separate pictures

#### System requirements (high level)
Functional:
- The application shows only the relevant patients from a specific doctor
Non-functional:
- Datenschutz
- Tablet application, which can also be used on desktop computers.
- Central data management
- Berechtigung psych med


### 5. Prototype 
(presentation: Patrick)

- briefly document the what and how of your prototype

### 6. Validate 
(presentation: Fabian)

test your prototype with teammates, friends & family, or your teacher
- first define your evaluation questions
- then how you will find the answer
and document the results

- Full validation is not possible at the moment because of the short time horizon. 
 