#Requirements document


## Preface 
### Target audience
This document was written to describe the requirements for the MHC-PMS (MHC patient management system) in details. It includes every aspect of the system and focuses on the technical side. The reader should have a basis understanding of the healthcare section and information technology. 

### Document history

For details about the evolution of this document please check the 
[commit history](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/commits/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/requirements-document.md)
in the [git][1] repository. Or the command mentioned below:

```bash
$ git log
``` 

### Document releases

Major and minor releases of this document are tagged by [git][1].

| Release | Who             | Summary of changes                             |
|:--------|:----------------|:-----------------------------------------------|
| 0       | Fabian Affolter | Creation of the document (not tagged)          |
| 0.1     | Fabian Affolter | Release after first day. Content added         |

## Introduction 
Your regional health authority wishes to introduce a patient management system
(PMS) to manage the care of patients suffering from mental health problems. 
The overall goals of the system will be:

1. To provide medical staff with timely information to facilitate the 
   treatment of patients.
2. To generate management information that allows health service managers
   to assess performance against local and government targets.

Most mental health patients do not require dedicated hospital treatment but
need to attend specialist clinics regularly where they can meet a doctor who
has detailed knowledge of their problems. The health authority has a number of
clinics that patients may attend. To make it easier for patients to attend,
these clinics are not just run in hospitals. They may also be held in local
medical practices or community centres. Patients need not always attend the
same clinic and some clinics may support ‘drop in’ as well as pre-arranged
appointments.

The nature of mental health problems is such that patients are often
disorganised so may miss appointments, deliberately or accidentally lose
prescriptions and medication, forget instructions and make unreasonable
demands on medical staff. In a minority of cases, they may be a danger to
themselves or to other people. They may regularly change address and may be 
omeless on a long-term or short-term basis. Where patients are dangerous,
they may need to be ‘sectioned’ – confined to a secure hospital for treatment
and observation.

Users of the system include clinical staff (doctors, nurses, health visitors),
receptionists who make appointments and medical records staff. Reports are
generated for hospital management by medical records staff. Management have
no direct access to the system.

The system is affected by two pieces of legislation

1. Data Protection Act that governs the confidentiality of personal information
2. Mental Health Act that governs the compulsory detention of patients deemed
   to be a danger to themselves or others.

The system will NOT become a complete medical records system where all information about
a patients medical treatment is maintained. It will solely intended to support
mental health care so if a patient is suffering from some other unrelated
condition (such as high blood pressure) this would not be formally recorded
in the system.



## Glossary
- **Therapist**: Psychotherapists employ a range of techniques based on experiential relationship building, dialogue, communication and behavior change that are designed to improve the mental health of a client or patient, or to improve group relationships (such as in a family).
- **Psychologist**: A psychologist evaluates, diagnoses, treats, and studies behavior and mental processes. Some psychologists, such as clinical and counseling psychologists, provide mental health care, and some psychologists, such as social or organizational psychologists conduct research, usually in university or other academic settings. A psychologist has a graduate degree (usually a PhD or MA).
- **Psychiatrist**: A psychiatrist is a physician who specializes in psychiatry. Psychiatrists are authorized to prescribe medicine, conduct physical examinations, order and interpret laboratory tests, and may order brain imaging studies such as computed tomography (CT/CAT Scan), magnetic resonance imaging (MRI), and positron emission tomography (PET) scanning. A psychiatrist has an MD.
- **Diagnosis**: Medical diagnosis refers both to the process of attempting to determine or identify a possible disease or disorder (and diagnosis in this sense can also be termed (medical) diagnostic procedure), and to the opinion reached by this process (also being termed (medical) diagnostic opinion). From the point of view of statistics the diagnostic procedure involves classification tests. It is a major component of, for example, the procedure of a doctor's visit.
- **Drugs**: A drug is a substance which may have medicinal, intoxicating, performance enhancing or other effects when taken or put into a human body or the body of another animal and is not considered a food or exclusively a food.
- **History**: In this context, history means the complete list of past events all around the patient. For example, this includes treatment, drug prescriptions, orders given to nursing staff and so on.
- **Patient**: A patient is any recipient of health care services. The patient is in need of treatment by a health care provider. In this case, this provider is a therapist.
- **Order**: In this context, an order means an assignment from a therapist to nursing staff, administration staff or any other person, which is involved in the treatment and administrative process of the patient.
- **PMS**: *p*atient *m*anagement *s*ystem

## User requirements definition 



## System architecture 
The basic layout of the architecture will be a multi layer web application. With the help of separation of the core components of the system an accurate design will become reality. MVC (Model View Controller) archtecture of the web application will guarant a contemporary implementation of the patient management system.
For maximum performance the database will be hosted on a dedicated server. Every connection between the participient of the backend will be encrypted with industrial standards.

The clients will only access the web server on a encrypted channel. No unencrypted communication between the client and the server will be established.

- TODO: picture about system architecture

## System requirements specification 



## System models 



## System evolution 




## Testing 
For testing purposes a dummy database is needed. This means that a patient underlying data source must be ready at the start of the implementing phase. The format is open (full implemented database, simplified database, flat text file, etc.) but a source close to the layout which will be used for the final product is preferred.

## Appendices 

- [Use cases](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/task04/use-cases.md)
- []()
- []()

## Index 



[1]: http://git-scm.com/ "Git"
