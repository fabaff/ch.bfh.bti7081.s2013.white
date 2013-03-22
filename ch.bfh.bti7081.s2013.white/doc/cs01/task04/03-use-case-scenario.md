# Use Case Scenario

* **No. and name**            : **3** Change diagnosis [User Requirements](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/requirements-document.md#3-change-diagnosis)
* **Scenario**                : Change an existing diagnosis for a patient
* **Description**             : There are new informations concering the medical situation of the patient which must be added to the diagnosis
* **Engaged party**           : Therapist
* **Trigger / Pre condition** : The patient must already have an existing record, the patient must exist in the database
* **Results / Post condition**: The patients record database now has the newest information

## Sequence

| Nr.  | Who       | What                                              |
|:----:|:----------|:--------------------------------------------------|
| 1    |Therapist  |Login with personal username and password          |
| 2    |Therapist  |Search for the patient -> query database |
| 3    |Therapist  |Select patient from list -> opens information about the patient  |
| 4    |Therapist  |Open medical histroy of patient -> opens table view of diagnoses |
| 5    |Therapist  |Filter and/or search diagnosis
| 6    |Therapist  |Select the desired diagnosis  |
| 7    |Therapist  |Change/add the description for the diagnosis  |
| 8    |Therapist  |On save: the new record to the medical record database -> Changed diagnosis, date, time and actor are written to the patient medical record database  | 

## Exceptions, variations

| Nr.  | Who       | What                                              |
|:----:|:----------|:--------------------------------------------------|
| 1.1  |Nurse      |Patient record must have been created before       |
| 7.1  |Therapist  |Optional: Select different doctor or hospital      |
| 7.2  |Therapist  |Optional: Insert comments                          |

