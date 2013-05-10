# Use Case Scenario

* **No. and name**            : **3** Change diagnosis [User Requirements](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/requirements_document/requirements-document.md#3-change-diagnosis)
* **Scenario**                : Change an existing diagnosis for a patient (own patient of the therapist)
* **Description**             : There are new informations concering the medical situation of the patient and a diagnosis has to be changed.
* **Engaged party**           : Therapist / MHC_PMS
* **Trigger / Pre condition** : The patient must already have an existing diagnosis and must exist in the database. 
* **Results / Post condition**: The patients diagnosis now is updated

## Sequence

| Nr.  | Who       | What                                                                 				 				|
|:----:|:----------|:---------------------------------------------------------------------------------------------------|
| 1    |Therapist  |Login with personal username and password                             								|
| 2    |Therapist  |Choose the patient in the patient table                               								|
| 3    |Therapist  |Choose the diagnosis tab in the sidebar menu                          								|
| 4    |MHC_PMS    |The application changes to the diagnosis screen                       								|
| 5    |Therapist  |Choose the diagnosis, which has to be changed                         								|
| 6    |Therapist  |Click the "Bearbeiten" Button for the choosen diagnosis               								|
| 7    |MHC_PMS    |The change diagnosis screen will be opened                            								|
| 8    |Therapist  |The therapist enters the new ICD-10 Code in the ICD-Code Combo-Field  								|
| 9    |MHC_PMS    |While typing the application looks up the proper diagnosis from the database  						|
| 10   |MHC_PMS    |If the diagnosis exists, the Combo-Field "Diagnose" will show the diagnosis for the choosen ICD-Code|
| 11   |MHC_PMS    |The textfield "Beschreibung" will show the description for the choosen diagnosis  					|
| 12   |Therapist  |The therapist write an new comment in the "Kommentar" textfield  									|
| 13   |Therapist  |The therapist clicks the "Speichern" button															|
| 14   |MHC_PMS    |The changed diagnosis is stored in the database                                                     |
| 15   |MHC_PMS    |The application closes the change diagnosis screen and returns to the diagnosis screen              |


## Exceptions, variations

| Nr.  | Who       | What                                                                 |
|:----:|:----------|:---------------------------------------------------------------------|
| 1.1  |Therapist  |Therapist must have a user account and password    					  |
| 2.1  |MHC_PMS    |The patient must exist in the database             					  |
| 5.1  |MHC_PMS    |The diagnosis to this patient must exist in the database    		  |
| 9.1  |MHC_PMS    |The diagnosis does not exist: A short message will be displayed       |
| 9.2  |MHC_PMS    |The same diagnosis as before the search is displayed		          |
