Feature: Tanár létrehozása

Scenario: Tanár létrehozása
  When Hozzáadok egy új tanárt "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "MI" azonosítóval
  Then A tanárok listájában 1 névnek kell szerepelnie

Scenario: Tanár létrehozása nem lehetséges ugyanazzal az azonosítóval
  Given Egy tanár a rendszerben "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "MI" azonosítóval
  When Hozzáadok egy új tanárt "Meredek Ilona" teljes névvel, "1980.01.01" születési dátummal és "MI" azonosítóval
  Then Hibaüzenetet kapok
  And A tanárok listájában 1 névnek kell szerepelnie

  Scenario: Tanár létrehozása nem lehetséges ugyanazzal a teljes névvel és azonosítóval
  Given Egy tanár a rendszerben "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "MI" azonosítóval
  When Hozzáadok egy új tanárt "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "XY" azonosítóval
  Then Hibaüzenetet kapok
  And A tanárok listájában 1 névnek kell szerepelnie
