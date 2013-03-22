# Use Case Scenario

* **No. and name**            : **2** New diagnosis
* **Scenario**                : Create a new diagnosis for an existing user
* **Description**             : An existing patient visits a doctor with a new problem, so he has to open a new diagnosis
* **Engaged party**           : Therapist
* **Trigger / Pre condition** : A patient comes with a new problem, patient must exist in database
* **Results / Post condition**: The new diagnosis is logged in the patient medical record database

## Sequence

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

## Exceptions, variations

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

