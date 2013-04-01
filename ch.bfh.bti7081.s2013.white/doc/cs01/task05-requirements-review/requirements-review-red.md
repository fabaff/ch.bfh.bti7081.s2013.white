# Requirements Review - Red

## Source

File: [CS1_Task4_TeamRED.pdf](https://github.com/reubd1/ch.bfh.bti7081.s2013.red/blob/master/ch.bfh.bti7081.s2013.red/doc/cs1_tasks/task04_requirements/CS1_Task4_TeamRED.pdf)

```bash
Git Team Red: db5b9993413bc2be8dc5e1b4a54de77a81213d2e5c1738f7c43611020033aa5c  CS1_Task4_TeamRED.pdf
Review:       db5b9993413bc2be8dc5e1b4a54de77a81213d2e5c1738f7c43611020033aa5c  CS1_Task4_TeamRED.pdf
```

## Comprehensibility
Use case *#5 Erinnerung darstellen* says under 1.4.1 and 1.5.1 something about the next appointment. As mentioned in the last column there is only a variation about the notification. What happens if the patient is already too far away to make it on time to the appointment?

The section *System Architecture* shows in the *Use Case diagram* that the therapist is interacting with the patient's data through a third-party system in the "Cloud". Where is "Cloud", who is responsible for ?

According the  *Use Case diagram* every logic is implemented in the client application and the "Cloud" is used for storing data. Security tests in the *Testing* section are mentioning communication between the application and a server. Is server = "Cloud"?

## Validity
The section *User Requirements* covers the major features which the mobile application must contain. One concern is the topic *#8 Therapiefortschritt visualisieren* because if the treatment is taking a long time (several months to years) the missing progress could frustrate the patients.

## Consistency
It will be hard to prove that storing sensitive data in the "Cloud" (meaning let the data handling be done by a contractor or a third-party provider) will go along with the 
Data Protection Act and the Mental Health Act. 

The picked use case *#5 Erinnerung darstellen* doesn't match the description in the image *Use Case Diagram*. There this case is named *#5) Event darstellen*. This is just a minor issue but for consistency of the document it would be nice to use the same labels everywhere.

## Completeness
In the use case *#4 Medikament verwalten* are some exceptions missing. What is about if the patient make an entry that the medicament was taken but he/she threw it away or lost it?

Section *#4 Medikamente verwalten* of the *System Requirements* and section *#4 Medikament verwalten* don't make a statement about handling of the subscription of medicament. The patient will not be able to buy medicaments which are only available on prescription without the proper paperwork.

The section *System Requirements* mentions in several functions a central database as the origin of the data. But the *Use Case diagram* shows a local storage in between the patient and the "Cloud". This leads to the conclusion that the application will work without data connections. 
 
## Realism
The section *System Requirements* mentions in several functions a central database as the origin of the data. 

As outlined in the *System architecture* section GPS is used to determine the phyiscal location of the patient. There are some doubt that this work proberly because in urban areas and buildings the clear view to the sky is missing which ends in inaccuracy of the patient's position. In the use case scenario *#5 Erinnerung darstellen* this is covered in section 1.3.1. Another issue is that switched on GPS recievers in search mode drains batteries fast because the power consumption of the device is high. 

## Verifiability


## Traceability
Due to the lack of the customers requirement details tracing of the requirements is not possible at this point in time. 

## Adaptability
The design of the application allow easy modifications. The components are separated and devided in layers which makes it possible to add/remove features or functions when the requirements change. 

## Summary
The outlined requirements of the application depends headily on third-party data providers. GIS data change quickly and are not very reliable. 

Heavy usage of mobile data communication may cause high costs for the patients. Almost all functionality requires a data connection.
