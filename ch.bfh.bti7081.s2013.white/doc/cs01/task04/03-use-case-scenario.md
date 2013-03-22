# Use Case Scenario

* **No. and name**            : **3** Change diagnosis [User Requirements](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/requirements-document.md#3-change-diagnosis)
* **Scenario**                : Change an existing diagnosis for a patient
* **Description**             : There are new informations concering the medical situation of the patient which must be added to the diagnosis
* **Engaged party**           : Therapist / MHC_PMS
* **Trigger / Pre condition** : The patient must already have an existing record, the patient must exist in the database
* **Results / Post condition**: The patients record database now has the newest information

## Sequence

| Nr.  | Who       | What                                              |
|:----:|:----------|:--------------------------------------------------|
| 1    |Therapist  |Login with personal username and password          |
| 2    |Therapist  |Search for the patient  |
| 3    |MHC_PMS    |Query on database, return list of patients  |
| 4    |Therapist  |Select patient from search list  |
| 5    |MHC_PMS    |Detailed view of patient with medical and history overview is displayed  |
| 6    |Therapist  |Open medical histroy of patient |
| 7    |MHC_PMS    |A detailed view of the medical history is displayed  |
| 8    |Therapist  |Filter and/or search diagnosis  |
| 9    |MHC_PMS    |List of diagnoses is displayed  |
| 10    |Therapist  |Select the desired diagnosis  |
| 11   |Therapist  |Change/add the description for the diagnosis  |
| 12   |MHC_PMS  |On save: the new record to the medical record database -> Changed diagnosis, date, time and actor are written to the patient medical record database  | 

## Exceptions, variations

| Nr.  | Who       | What                                              |
|:----:|:----------|:--------------------------------------------------|
| 1.1    |Therapist  |Psychiatrist must have a user account and password |
| 4.1    |Nurse  |Patient must be added to database before comming to psychiatrist  |
| 4.2    |Therapist  |Patient not found: Check name used to query database |
| 4.1    |Therapist  |Patient must have at least one existing diagnosis  |
| 5.1    |MHC_PMS    |If Patient is marked as violent, warning is displayed on screen  |
| 11.1  |Therapist  |Optional: Select different doctor or hospital      |
| 11.2  |Therapist  |Optional: Insert comments                          |

