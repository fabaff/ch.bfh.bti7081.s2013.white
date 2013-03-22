# Use Case Scenario

* **No. and name**            : **5** Change medication [User Requirements](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/requirements-document.md#5-change-medication)
* **Scenario**                : The medication for a user has to be changed
* **Description**             : A patient has major side effects with a prescribed medication. The psychiatrist wants to try a different dosage.
* **Engaged party**           : Psychiatrist / MHC_PMS / DRUGS2000
* **Trigger / Pre condition** : The patient must have an existing record and e previously perscribed medication
* **Results / Post condition**: The new prescription is added to the patients medical record

## Sequence

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 1    |Psychiatrist  |Login with personal username and password  |
| 2    |Psychiatrist  |Search for the patient, by name, address or from list  |
| 3    |MHC_PMS       |patients are loaded from database and displayed on screen
| 4    |Psychiatrist  |Select patient from search list  |
| 5    |MHC_PMS       |Opens detailed view of patient including medical and drug records  |
| 6    |Psychiatrist  |Click on Medication button to open the detailed drugs view of patient  |
| 7    |MHC_PMS       |Detailed list of medications an prescriptions is displayed  |
| 8    |Psychiatrist  |Select medication by clicking on it |
| 9    |MHC_PMS       |List of current prescriptions and drugs ist listed  |
| 10    |Psychiatrist  |Search for affected prescription by keywords or from list  |
| 11   |Psychiatrist  |Deactivate affected prescription by marking a checkbox  |
| 12   |Psychiatrist  |Create new prescription by clicking on add button |
| 13   |MHC_PMS       |A new form is displayed  |
| 14   |Psychiatrist  |Search for drug in drug-database, by keywords or from filtered and sorted list  |
| 15   |DRUGS2000     |Query on drug-database, List of drugs is returend  |
| 16   |Psychiatrist  |Select drug from drug-database by clicking on it  |
| 17   |MHC_PMS       |New prescription form is displayed  |
| 18   |Psychiatrist  |Define dosage and frequency either with dropdown or by entering the numbers  |
| 19   |MHC_PMS  |On save: changes are written to patient medical record database  |
| 20   |Psychiatrist  |Log Out   |

## Exceptions, variations

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 4.1   |MHC_PMS  |If patient is marked as violent, a warning is displayed on screen  |
| 18.1    |MHC_PMS  |Dosage is checked against drug database for validity. Error returns if not valid  |


