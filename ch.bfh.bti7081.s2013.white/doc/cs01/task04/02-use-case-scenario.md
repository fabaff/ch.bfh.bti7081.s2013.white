# Use Case Scenario

* **No. and name**            : **2** New case
* **Scenario**                : Create a new case for an existing user
* **Description**             : An existing patient visits a doctor with a new problem, so he has to open a new case
* **Engaged party**           : Therapist
* **Trigger / Pre condition** : A patient comes with a new problem, patient must exist in database
* **Results / Post condition**: The new case is logged in the patient medical record database

## Sequence

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 1    |Therapist  |Login with personal username and password  |
| 2    |Therapist  |Search for the patient  |
| 3    |Therapist  |Select patient from list  |
| 4    |Therapist  |Open medical record of patient  |
| 5    |Therapist  |Click on add new record  |
| 6    |Therapist  |Add a name for the record  |
| 7    |Therapist  |Insert a description  |
| 8    |Therapist  |Save the new record to the medical record database  |

## Exceptions, variations

| Nr.  | Who     | What |
|:----:|:--------|:-----|
| 1.1  |Nurse  |Patient record must have been created before  |
| 7.1  |Therapist  |Optional: Select different doctor or hospital  |
| 7.2    |Therapist  |Optional: Insert comments  |
| 4    |  |  |
| 5    |  |  |
| 6    |  |  |

