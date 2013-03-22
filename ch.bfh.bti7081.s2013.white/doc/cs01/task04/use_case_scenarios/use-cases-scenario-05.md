# Use Case Scenario

* **No. and name**            : **5** Change medication [User Requirements](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/requirements_document/requirements-document.md#5-change-medication)
* **Scenario**                : The medication for a user has to be changed
* **Description**             : A patient has major side effects with a prescribed medication. The psychiatrist wants to try a different dosage (morning).
* **Engaged party**           : Psychiatrist / MHC_PMS / DRUGS2000
* **Trigger / Pre condition** : The patient must have an existing record and e previously perscribed medication
* **Results / Post condition**: The changed prescription is stored in the patients medical record

## Sequence

| Nr.  | Who       | What                                                                 				 				|
|:----:|:----------|:---------------------------------------------------------------------------------------------------|
| 1    |Therapist  |Login with personal username and password                             								|
| 2    |Therapist  |Choose the patient in the patient table                               								|
| 3    |Therapist  |Choose the medication tab in the sidebar menu                          								|
| 4    |MHC_PMS    |The application changes to the medication screen                       								|
| 5    |Therapist  |Choose the medication, which has to be changed                         								|
| 6    |Therapist  |Click the "Bearbeiten" Button for the choosen medication               								|
| 7    |MHC_PMS    |The change medication screen will be opened                            								|
| 8    |Therapist  |The therapist enters the new dose in the field "Dosierung am Morgen"   								|
| 13   |Therapist  |The therapist clicks the "Speichern" button															|
| 14   |MHC_PMS    |The changed medication is stored in the database                                                    |
| 15   |MHC_PMS    |The application closes the change medication screen and returns to the medication screen            |


## Exceptions, variations

| Nr.  | Who       | What                                                                 |
|:----:|:----------|:---------------------------------------------------------------------|
| 1.1  |Therapist  |Therapist must have a user account and password    					  |
| 2.1  |MHC_PMS    |The patient must exist in the database             					  |
| 5.1  |MHC_PMS    |The medication to this patient must exist in the database    		  |
| 8.1  |MHC_PMS    |Wrong input format (characters): an error message is displayed        |
| 8.2  |MHC_PMS    |The old dose value is restored                      		          |