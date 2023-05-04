API design

- letrehozTanart
  - teljes név
  - születési dátum (kettő együtt egyedi)
  - egyedi rövid azonosító 
  - CHECK egyediség
- letrehozTargyat
  - név
  - CHECK egyediség

------------------------------------

- megkezdUjEvet
  - év
- letrehozOsztalyt
  - évfolyam
  - osztály neve
  - CHECK egyedi éven belül
- hozzaadOratOsztalyhoz
  - tárgy neve
  - nap
  - óra
- hozzarendelTanartOsztalyhoz
  - tanár 
  - osztály neve
- hozzarendelOsztalyfonokotOsztalyhoz
- elinditEvet
  - CHECK minden osztálynak van osztályfőnöke
  - CHECK egy tanár max. 1 osztálynak lehet osztályfőnöke

- modositOrarendet
  - CHECK egy orarend lehet folyamatban csak - az aktuális évet lehet csak módosítani