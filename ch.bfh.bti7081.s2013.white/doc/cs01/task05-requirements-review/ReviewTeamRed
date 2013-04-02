Review of the requirements document of team RED (by team WHITE)

Comprehensibility: Is the requirement properly understood?
Verständlichkeit:
- Die Anforderungen des Kunden wurden verstanden und in den einzelnen Anforderungsbeschreibungen ebenso beschrieben.


Validity: Will the system provide the functions which best support the customer’s needs?
Gültigkeit:
- Tagebucheinträge nur bei bestehender Verbindung zur DB möglich, nicht über lokalen Speicher und nachträgliche Replikation...
  Nachträgliche Erfassung, z.B. Stunden später ergibt nicht mehr dieselben Einträge, gerade bei psychisch Kranken.


Consistency: Are there any requirement conflicts?
Kontinuität:
- Anforderung 4 (Medikamente verwalten) Seite 12 enthält Fehler:
  Vorbedingung, Nachbedingung, Seiteneffekte handeln von Terminen anstelle von Medikamenten.
  Laut Architektur auf Seite 9 sind Medikamente eigenständig.
  

Completeness: Are all functions required by the customer included?
Vollständigkeit:
- Viele Anforderungen sind nur bei bestehender Verbindung zur DB möglich. Wie sieht es aus mit einer Kontrolle betreffend dieser Verbindung?
  Wann wurde die App das letzte mal gestartet? Wann die letzte Replikation / Synchronisation?
  Eine Überwachung / Alarm bei zuständigem Arzt nötig bei zu langen Offlinezeiten? --> Konfigurierbar pro Patient
  Siehe auch Anwendungsfall #5, Erinnerung darstellen: Nr. 1.1, "Patient startet die App"

  
Realism: Can the requirements be implemented given available budget and technology
Realismus:
- Die Anforderungen können wie beschrieben in einem vertretbaren Zeit- / Kostenaufwand umgesetzt werden.
  Die erforderliche Technologie ist bereits von Drittanbietern umgesetzt und hat sich bewährt: Datenbank, GPS, HTTPS usw.
  Ebenso gestaltet sich die Anbindung an diese Systeme problemlos.
  Die zu entwickelnden Komponenten benötigen keine neuen Technologien.


Verifiability: Can the requirements be checked?
Prüfbarkeit:
- Die funktionalen wie auch die nichtfunktionalen Anforderungen können durch geignete Systemtests auf Korrektheit / Performance / Sicherheit geprüft werden.
  Durch Usertests können ebenfalls nichtfunktionale Anforderungen wie Effizienz und Bedienbarkeit geprüft werden.
  Die nichtfunktionale Anforderung "Portierbarkeit der Daten" kann durch eine geeignete Schnittstellenbeschreibung gewährleistet, aber kaum geprüft werden.
  

Traceability: Is the origin of the requirement clearly stated?
Rückführbarkeit:
- Die Originalanforderungen des Kunden sind auf Seite 4, Kapitel 3 klar beschrieben.


Adaptability: Can the requirement be changed without a large impact on other requirements?
Adaptionsfähigkeit:
- Die einzelnen Anforderungen sind Modulweise aufgebaut, ebenso die Systemarchitektur. Die Komponenten scheinen deshalb beliebig erweiterbar, bzw. verzichtbar zu sein.
  Auf fehlende Dienste (wie GBS, DB) wird bereits in allen Anforderungen entsprechend reagiert.
