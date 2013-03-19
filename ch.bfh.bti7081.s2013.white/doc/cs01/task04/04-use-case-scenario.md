# Use Case Scenario

* **No. and name**            : **4** Change medication
* **Scenario**                : The medication for a user has to be changed
* **Description**             : A patient has major side effects with a prescribed medication. The psychiatrist wants to try a different dosage.
* **Engaged party**           : Psychiatrist
* **Trigger / Pre condition** : The patient must have an existing record and e previously perscribed medication
* **Results / Post condition**: The new perscription is added to the patients medical record

## Sequence

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 1    |Psychiatrist  |Login with personal username and password  |
| 2    |Psychiatrist  |Search for the patient, by name, address or from list (like contacts) |
| 3    |Psychiatrist  |Select patient from search list  |
| 4    |Psychiatrist  |Click on Medication button to open the medical history of patient  |
| 3    |Psychiatrist  |Select medication  |
| 4    |Psychiatrist  |Search for affected perscription  |
| 5    |Psychiatrist  |Deactivate affected perscription by marking a checkbox  |
| 6    |Psychiatrist  |Create new perscription  |
| 7    |Psychiatrist  |Search for drug in drug-database, by name or ingredients   |
| 8    |Psychiatrist  |Select drug from drug-database  |
| 9    |Psychiatrist  |Define dosage and frequency   |
| 10   |Psychiatrist  |Save changes to database  |
| 11   |Psychiatrist  |Log Out   |

## Exceptions, variations

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 5.1    |Psychiatrist  |Add reason for deaktivation  |
| 2    |  |  |
| 3    |  |  |
| 4    |  |  |
| 5    |  |  |
| 6    |  |  |

