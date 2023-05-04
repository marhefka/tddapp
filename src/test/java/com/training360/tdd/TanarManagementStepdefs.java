package com.training360.tdd;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class TanarManagementStepdefs {
    @Autowired
    private TanarService tanarService;

    private boolean hiba;

    @When("Hozzáadok egy új tanárt {string} teljes névvel, {string} születési dátummal és {string} azonosítóval")
    public void hozzáadokEgyÚjTanártTeljesNévvelSzületésiDátummalÉsRövidNévvel(String teljesNev, String sSzuletesiDatum, String azonosito) throws Exception {
        Date szuletesiDatum = new SimpleDateFormat("yyyy.MM.dd").parse(sSzuletesiDatum);

        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.teljesNev = teljesNev;
        command.szuletesiDatum = szuletesiDatum;
        command.azonosito = azonosito;

        try {
            tanarService.letrehozTanart(command);
            hiba = false;
        } catch (Exception ex) {
            hiba = true;
        }
    }

    @Then("A tanárok listájában {int} névnek kell szerepelnie")
    public void aTanárokListájábanNévnekKellSzerepelnie(int count) {
        assertThat(tanarService.listTanarok().size()).isEqualTo(count);
    }

    @Then("Hibaüzenetet kapok")
    public void hibaüzenetetKapok() {
        assertThat(hiba).isTrue();
    }
}
