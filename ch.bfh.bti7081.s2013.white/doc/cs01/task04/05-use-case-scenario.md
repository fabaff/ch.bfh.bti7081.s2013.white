# Use Case Scenario

* **No. and name**            : **5** Change medication [User Requirements](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/requirements-document.md#5-change-medication)
* **Scenario**                : The medication for a user has to be changed
* **Description**             : A patient has major side effects with a prescribed medication. The psychiatrist wants to try a different dosage.
* **Engaged party**           : Psychiatrist
* **Trigger / Pre condition** : The patient must have an existing record and e previously perscribed medication
* **Results / Post condition**: The new prescription is added to the patients medical record

## Sequence

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 1    |Psychiatrist  |Login with personal username and password  |
| 2    |Psychiatrist  |Search for the patient, by name, address or from list -> patients are loaded from database  |
| 3    |Psychiatrist  |Select patient from search list -> opens detailed view of patient including medical and drug records  |
| 4    |Psychiatrist  |Click on Medication button to open the detailed drugs view of patient  |
| 3    |Psychiatrist  |Select medication by clicking on it |
| 4    |Psychiatrist  |Search for affected prescription by keywords or from list  |
| 5    |Psychiatrist  |Deactivate affected prescription by marking a checkbox  |
| 6    |Psychiatrist  |Create new prescription by clicking on add button |
| 7    |Psychiatrist  |Search for drug in drug-database, by keywords or from filtered and sorted list -> channel to drug database is opened  |
| 8    |Psychiatrist  |Select drug from drug-database by clicking on it  |
| 9    |Psychiatrist  |Define dosage and frequency either with dropdown or by entering the numbers  |
| 10   |Psychiatrist  |On save: changes are written to patient medical record database  |
| 11   |Psychiatrist  |Log Out   |

## Exceptions, variations

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 1.1    |Psychiatrist  |Psychiatrist must have a user account and password |
| 2.1    |Nurse  |Patient must be added to database before comming to psychiatrist  |
| 2.2    |Psychiatrist  |Patient not found: Check name used to query database |
| 4.1    |Psychiatrist  |Patient must have existing prescriptions  |
| 9.1    |Psychiatrist  |Dosage is checked against drug database for validity. Error returns if not valid  |
| 6    |  |  |

