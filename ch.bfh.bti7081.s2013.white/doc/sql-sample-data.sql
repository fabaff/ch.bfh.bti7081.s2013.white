USE mhcPms
Go


DELETE FROM MedicationTime
DELETE FROM MedicationDate
DELETE FROM Medication
TRUNCATE TABLE Diagnosis
TRUNCATE TABLE PatientProgress
DELETE FROM PCase
DELETE FROM PmsUser
GO

--IDENTITY zurücksetzen
DBCC CHECKIDENT('Medication', RESEED, 0)
DBCC CHECKIDENT('MedicationDate', RESEED, 0)
DBCC CHECKIDENT('MedicationTime', RESEED, 0)
DBCC CHECKIDENT('Diagnosis', RESEED, 0)
DBCC CHECKIDENT('PatientProgress', RESEED, 0)
DBCC CHECKIDENT('PCase', RESEED, 0)
DBCC CHECKIDENT('PmsUser', RESEED, 0)
GO

--Test-User anlegen
INSERT INTO PmsUser
	VALUES (
			'Waldau'
			,'Psychiatrie'
			,'Hans'
			,'Muster'
			,'debb46e7cd40c4dbbfa80c96491e7ad7'
			--,hansemann
			,'PSYCHIATRIST'
			,'HANS.MUSTER'
		   )
GO
		   
INSERT INTO PmsUser
	VALUES (
			'Waldau'
			,'Psychiatrie'
			,'Peter'
			,'Müller'
			,'bdefdc3b4f94b958bbbecff7e70ac44e'
			--,peterli
			,'PSYCHOLOGIST'
			,'PETER.MUELLER'
		   )
GO

INSERT INTO PmsUser
	VALUES (
			'Münsingen'
			,'Betreuung'
			,'Maria'
			,'Himmelfahrt'
			,'263bce650e68ab4e23f28263760b9fa5'
			--,maria
			,'MEDICAL_STAFF'
			,'MARIA.HIMMELFAHRT'
		   )
GO

INSERT INTO PmsUser
	VALUES (
			'Bern'
			,'Verwaltung'
			,'Kurt'
			,'Baer'
			,'b3904b4bb923c33d8df46472981ef2c3'
			--,kurtli
			,'ADMIN_STAFF'
			,'KURT.BAER'
		   )
GO

INSERT INTO PmsUser
	VALUES (
			'Waldau'
			,'Betreuung'
			,'Nicole'
			,'Glauser'
			,'766baba8c0a0d4ae751256aa664b2446'
			--,niggi
			,'NURSE'
			,'NICOLE.GLAUSER'
		   )
GO

--Test-Patienten anlegen
INSERT INTO PCase
	VALUES (
			'Mustergasse 15'	--[ADDRESS]
			,'???'	--[ASSIGNMENT]
			,'CLOSED'	--[CASESTATUS]
			,'UNMARRIED'	--[CIVILSTATUS]
			,'Deutsch'	--[COMMUNICATIONLANGUAGE]
			,'CH'	--[COUNTRY]
			,'2013-05-10'	--[DATECASECLOSED]
			,'2011-07-06'	--[DATECASEOPENED]
			,'1963-01-02'	--[DATEOFBIRTH]
			,'Ungefährlich'	--[DEGREEOFDANGER]
			,'macker@musterdomain.com'	--[EMAIL]
			,'Bundesplatz'	--[FAMILYDOCTORADDRESS]
			,'012 / 345 67 89'	--[FAMILYDOCTORFAX]
			,'Dr. Pierre'	--[FAMILYDOCTORFIRSTNAME]
			,'Wirz'	--[FAMILYDOCTORLASTNAME]
			,'Bern'	--[FAMILYDOCTORLOCATION]
			,'3000'	--[FAMILYDOCTORPOSTALCODE]
			,'Max'	--[FIRSTNAME]
			,'MALE'	--[GENDER]
			,'Free'	--[GOOUTSTATUS]
			,''	--[HOMELOCATION]
			,''	--[JUDICIALSTATUS]
			,'INPATIENT'	--[KINDOFTREATMENT]
			,'Macker'	--[LASTNAME]
			,'Deutsch'	--[MOTHERLANGUAGE]
			,'CH'	--[NATIONALITY]
			,'???'	--[NEXTOFKIN]
			,'???'	--[NEXTOFKINADDRESS]
			,'???'	--[NEXTOFKINFIRSTNAME]
			,'???'	--[NEXTOFKINHOMELOCATION]
			,'???'	--[NEXTOFKINLASTNAME]
			,'???'	--[NEXTOFKINPHONE]
			,'???'	--[NEXTOFKINPOSTALCODE]
			,'NO'	--[ORDEROFPATIENT]
			,'-'	--[PHONEBUSINESS]
			,'012 / 345 67 00'	--[PHONEMOBILE]
			,'012 / 345 67 01'	--[PHONEPRIVATE]
			,'1234'	--[POSTALCODE]
			,'LIMITED'	--[REANIMATIONSTATUS]
			,'Unknown'	--[RELIGION]
			,'None'	--[SANCTION]
			,'Low'	--[SUICIDALTENDENCY]
			,''	--[VACATION]
			,'1'	--[THERAPIST_UID]
		   )

INSERT INTO PCase
	VALUES (
			'Laubenweg 1'	--[ADDRESS]
			,'???'	--[ASSIGNMENT]
			,'ACTIVE'	--[CASESTATUS]
			,'DIVORCED'	--[CIVILSTATUS]
			,'Deutsch'	--[COMMUNICATIONLANGUAGE]
			,'CH'	--[COUNTRY]
			,NULL	--[DATECASECLOSED]
			,'2009-12-09'	--[DATECASEOPENED]
			,'1981-05-12'	--[DATEOFBIRTH]
			,'Gewalttätig'	--[DEGREEOFDANGER]
			,'bastard@musterdomain.com'	--[EMAIL]
			,'Bundesplatz'	--[FAMILYDOCTORADDRESS]
			,'012 / 345 67 89'	--[FAMILYDOCTORFAX]
			,'Dr. Pierre'	--[FAMILYDOCTORFIRSTNAME]
			,'Wirz'	--[FAMILYDOCTORLASTNAME]
			,'Bern'	--[FAMILYDOCTORLOCATION]
			,'3000'	--[FAMILYDOCTORPOSTALCODE]
			,'Max'	--[FIRSTNAME]
			,'MALE'	--[GENDER]
			,'Locked'	--[GOOUTSTATUS]
			,''	--[HOMELOCATION]
			,''	--[JUDICIALSTATUS]
			,'INPATIENT'	--[KINDOFTREATMENT]
			,'Bastard'	--[LASTNAME]
			,'Deutsch'	--[MOTHERLANGUAGE]
			,'CH'	--[NATIONALITY]
			,'???'	--[NEXTOFKIN]
			,'???'	--[NEXTOFKINADDRESS]
			,'???'	--[NEXTOFKINFIRSTNAME]
			,'???'	--[NEXTOFKINHOMELOCATION]
			,'???'	--[NEXTOFKINLASTNAME]
			,'???'	--[NEXTOFKINPHONE]
			,'???'	--[NEXTOFKINPOSTALCODE]
			,'NO'	--[ORDEROFPATIENT]
			,'-'	--[PHONEBUSINESS]
			,'012 / 345 67 10'	--[PHONEMOBILE]
			,'012 / 345 67 11'	--[PHONEPRIVATE]
			,'1234'	--[POSTALCODE]
			,'LIMITED'	--[REANIMATIONSTATUS]
			,'Unknown'	--[RELIGION]
			,'None'	--[SANCTION]
			,'Low'	--[SUICIDALTENDENCY]
			,''	--[VACATION]
			,'1'	--[THERAPIST_UID]
		   )

INSERT INTO PCase
	VALUES (
			'Freudenstrasse 6'	--[ADDRESS]
			,'???'	--[ASSIGNMENT]
			,'ACTIVE'	--[CASESTATUS]
			,'UNMARRIED'	--[CIVILSTATUS]
			,'Deutsch'	--[COMMUNICATIONLANGUAGE]
			,'CH'	--[COUNTRY]
			,NULL	--[DATECASECLOSED]
			,'2013-03-05'	--[DATECASEOPENED]
			,'1972-11-05'	--[DATEOFBIRTH]
			,'Launisch'	--[DEGREEOFDANGER]
			,'lustig@musterdomain.com'	--[EMAIL]
			,'Bundesplatz'	--[FAMILYDOCTORADDRESS]
			,'012 / 345 67 89'	--[FAMILYDOCTORFAX]
			,'Dr. Pierre'	--[FAMILYDOCTORFIRSTNAME]
			,'Wirz'	--[FAMILYDOCTORLASTNAME]
			,'Bern'	--[FAMILYDOCTORLOCATION]
			,'3000'	--[FAMILYDOCTORPOSTALCODE]
			,'Hedi'	--[FIRSTNAME]
			,'FEMALE'	--[GENDER]
			,'Free'	--[GOOUTSTATUS]
			,''	--[HOMELOCATION]
			,''	--[JUDICIALSTATUS]
			,'INPATIENT'	--[KINDOFTREATMENT]
			,'Happy'	--[LASTNAME]
			,'Deutsch'	--[MOTHERLANGUAGE]
			,'CH'	--[NATIONALITY]
			,'???'	--[NEXTOFKIN]
			,'???'	--[NEXTOFKINADDRESS]
			,'???'	--[NEXTOFKINFIRSTNAME]
			,'???'	--[NEXTOFKINHOMELOCATION]
			,'???'	--[NEXTOFKINLASTNAME]
			,'???'	--[NEXTOFKINPHONE]
			,'???'	--[NEXTOFKINPOSTALCODE]
			,'NO'	--[ORDEROFPATIENT]
			,'-'	--[PHONEBUSINESS]
			,'012 / 345 67 20'	--[PHONEMOBILE]
			,'012 / 345 67 21'	--[PHONEPRIVATE]
			,'3210'	--[POSTALCODE]
			,'LIMITED'	--[REANIMATIONSTATUS]
			,'Hindu'	--[RELIGION]
			,'None'	--[SANCTION]
			,'None'	--[SUICIDALTENDENCY]
			,''	--[VACATION]
			,'2'	--[THERAPIST_UID]
		   )
GO

--Test-Diagnosen anlegen
INSERT INTO Diagnosis
	VALUES (
			'Münsingen'	--[CLINICNAME]
			,'2011-07-06'	--[DATEOFCREATION]
			,'No comment'	--[DIAGNOSISCOMMENT]
			,'???'	--[DIAGNOSISCREATOR]
			,'Diagnose 1'	--[DIAGNOSISNAME]
			,'A123456789'	--[ICDCODE]
			,0	--[ISDELETED]
			,'1'	--[PCASE_PCID]
		   )

INSERT INTO Diagnosis
	VALUES (
			'Münsingen'	--[CLINICNAME]
			,'2009-12-09'	--[DATEOFCREATION]
			,'No comment'	--[DIAGNOSISCOMMENT]
			,'???'	--[DIAGNOSISCREATOR]
			,'Diagnose 1'	--[DIAGNOSISNAME]
			,'B98765'	--[ICDCODE]
			,0	--[ISDELETED]
			,'2'	--[PCASE_PCID]
		   )

INSERT INTO Diagnosis
	VALUES (
			'Münsingen'	--[CLINICNAME]
			,'2011-07-06'	--[DATEOFCREATION]
			,'No comment'	--[DIAGNOSISCOMMENT]
			,'???'	--[DIAGNOSISCREATOR]
			,'Eine weitere Diagnose'	--[DIAGNOSISNAME]
			,'C258DUDA'	--[ICDCODE]
			,0	--[ISDELETED]
			,'3'	--[PCASE_PCID]
		   )
GO

--Test-PatientProgress anlegen
INSERT INTO PatientProgress
	VALUES (
			'Münsingen'	--[CLINICNAME]
			,2011-07-06	--[DATEOFCREATION]
			,0	--[ISDELETED]
			,'Sehr fortschrittlich...'	--[PATIENTPROGRESSCOMMENT]
			,'???'	--[PATIENTPROGRESSCREATOR]
			,'1'	--[PCASE_PCID]
		   )

INSERT INTO PatientProgress
	VALUES (
			'Münsingen'	--[CLINICNAME]
			,2009-12-09	--[DATEOFCREATION]
			,0	--[ISDELETED]
			,'Absolut kein Fortschritt...'	--[PATIENTPROGRESSCOMMENT]
			,'???'	--[PATIENTPROGRESSCREATOR]
			,'2'	--[PCASE_PCID]
		   )

INSERT INTO PatientProgress
	VALUES (
			'Waldau'	--[CLINICNAME]
			,2013-03-05	--[DATEOFCREATION]
			,0	--[ISDELETED]
			,'Freude herrscht...'	--[PATIENTPROGRESSCOMMENT]
			,'???'	--[PATIENTPROGRESSCREATOR]
			,'3'	--[PCASE_PCID]
		   )

GO


--Test-Medication anlegen
INSERT INTO Medication
	VALUES (
			'ORAL'	--[APPLICATIONMODE]
			,'Münsingen'	--[CLINICNAME]
			,'2011-07-06'	--[DATEOFPRISCRIBING]
			,'???'	--[DOPE]
			,1	--[ISDELETED]
			,'Fühl gut'	--[MEDICATIONNAME]
			,'Dr. Marihuana'	--[PRISCRIBINGDOCTOR]
			,'1'	--[PCASE_PCID]
		   )

INSERT INTO Medication
	VALUES (
			'ANAL'	--[APPLICATIONMODE]
			,'Münsingen'	--[CLINICNAME]
			,'2011-12-23'	--[DATEOFPRISCRIBING]
			,'???'	--[DOPE]
			,1	--[ISDELETED]
			,'Weihnachtsbalsam'	--[MEDICATIONNAME]
			,'Dr. Marihuana'	--[PRISCRIBINGDOCTOR]
			,'1'	--[PCASE_PCID]
		   )

INSERT INTO Medication
	VALUES (
			'ORAL'	--[APPLICATIONMODE]
			,'Münsingen'	--[CLINICNAME]
			,'2013-01-02'	--[DATEOFPRISCRIBING]
			,'???'	--[DOPE]
			,1	--[ISDELETED]
			,'Fühl gut'	--[MEDICATIONNAME]
			,'Dr. Marihuana'	--[PRISCRIBINGDOCTOR]
			,'1'	--[PCASE_PCID]
		   )

INSERT INTO Medication
	VALUES (
			'ORAL'	--[APPLICATIONMODE]
			,'Münsingen'	--[CLINICNAME]
			,'2009-12-09'	--[DATEOFPRISCRIBING]
			,'???'	--[DOPE]
			,0	--[ISDELETED]
			,'KommZurRuh'	--[MEDICATIONNAME]
			,'Dr. Selig'	--[PRISCRIBINGDOCTOR]
			,'2'	--[PCASE_PCID]
		   )

--Test-MedicationDate anlegen
INSERT INTO MedicationDate
	VALUES (
			'2011-07-06'	--[APPLICATIONDATE]
			,'CLOSED'	--[MEDICATIONSTATUS]
			,'1'	--[MEDICATION_MID]
		   )

INSERT INTO MedicationDate
	VALUES (
			'2011-12-23'	--[APPLICATIONDATE]
			,'CLOSED'	--[MEDICATIONSTATUS]
			,'1'	--[MEDICATION_MID]
		   )

INSERT INTO MedicationTime
	VALUES (
			'10:15:00 AM'	--[APPLICATIONTIME]
			,3	--[MEDICATIONDOSIS]
			,'PILL'	--[MEDICATIONUNIT]
			,'1'	--[MEDDATE_MDID]
		   )

INSERT INTO MedicationTime
	VALUES (
			'13:27:38 PM'	--[APPLICATIONTIME]
			,7.5	--[MEDICATIONDOSIS]
			,'PILL'	--[MEDICATIONUNIT]
			,'2'	--[MEDDATE_MDID]
		   )

GO


SELECT * FROM PmsUser
SELECT * FROM PCase
SELECT * FROM Diagnosis
SELECT * FROM PatientProgress
SELECT * FROM Medication
SELECT * FROM MedicationTime
SELECT * FROM MedicationDate

GO