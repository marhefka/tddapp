Feature: Tanár létrehozása
  Az iskola igazgatóhelyetteseként tanárokat akarok létrehozni, hogy a későbbiekben
  az órarendhez tudjam őket rendelni.

  Acceptance criteria:
  - ha létrehozok egy új tanárt, akkor az adatait (azonosító, teljes név, születési idő) eltárolja a rendszer
  - két ugyanolyan azonosítójú tanárt nem enged felvinni a rendszer
  - két ugyanolyan (teljes nevű és születési idejű) tanárt nem enged felvinni a rendszer

  Example: Tanár létrehozása
    When Létrehozok egy új tanárt "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "MI" azonosítóval
    Then A tanárok listájában 1 névnek kell szerepelnie

  Example: Második tanár létrehozása
    Given Egy tanár a rendszerben "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "MI" azonosítóval
    When Létrehozok egy új tanárt "Kovács Attila" teljes névvel, "2001.01.01" születési dátummal és "KA" azonosítóval
    Then A tanárok listájában 2 névnek kell szerepelnie

  Example: Tanár létrehozása nem lehetséges ugyanazzal az azonosítóval
    Given Egy tanár a rendszerben "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "MI" azonosítóval
    When Létrehozok egy új tanárt "Meredek Ilona" teljes névvel, "1980.01.01" születési dátummal és "MI" azonosítóval
    Then Hibaüzenetet kapok
    And A tanárok listájában 1 névnek kell szerepelnie

  Example: Tanár létrehozása nem lehetséges ugyanazzal a teljes névvel és azonosítóval
    Given Egy tanár a rendszerben "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "MI" azonosítóval
    When Létrehozok egy új tanárt "Marhefka István" teljes névvel, "1979.12.04" születési dátummal és "XY" azonosítóval
    Then Hibaüzenetet kapok
    And A tanárok listájában 1 névnek kell szerepelnie
