
Kódbemutató

- Domain bemutatása
  - Nem kifejezetten DDD, de annak tudatosságával
- Architektúra bemutatása (Spring Boot, H2, Liquibase, Rest API, Service (Controller) / Repository) - kódot megmutatva
- Walking Skeleton koncepció
  - deployment pipeline
- Cucumber / BDD test bemutatása (service-be itt még nem megyek bele)
- ControREST API Design

- ATDD java teszt bemutatása (majd itt megyek végig a stacken)
  - migrációs szkriptet megmutatni
  - db táblát törölni
  - portra felhívni a figyelmet
  - Mit lehetne unit tesztelni?
- Live coding

----

Tovabbi szolgaltasok:

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