package com.training360.tdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class TanarManagementStepdefs {
    @Autowired
    private TanarController tanarController;

    @Autowired
    private TestHelper testHelper;

    private boolean hiba;

    @Before
    public void before() {
        testHelper.truncateTables();
    }

    @Given("Egy tanár a rendszerben {string} teljes névvel, {string} születési dátummal és {string} azonosítóval")
    @When("Létrehozok egy új tanárt {string} teljes névvel, {string} születési dátummal és {string} azonosítóval")
    public void hozzáadokEgyÚjTanártTeljesNévvelSzületésiDátummalÉsAzonosítóval(String teljesNev, String sSzuletesiDatum, String azonosito) throws Exception {
        try {
            LetrehozTanartCommand command = new LetrehozTanartCommand();
            command.azonosito = azonosito;
            command.teljesNev = teljesNev;
            command.szuletesiDatum = LocalDate.parse(sSzuletesiDatum, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

            tanarController.letrehozTanart(command);
            hiba = false;
        } catch (Exception ex) {
            hiba = true;
        }
    }

    @Then("A tanárok listájában {int} névnek kell szerepelnie")
    public void aTanárokListájábanNévnekKellSzerepelnie(int count) {
        assertThat(tanarController.listTanarok().size()).isEqualTo(count);
    }

    @Then("Hibaüzenetet kapok")
    public void hibaüzenetetKapok() {
        assertThat(hiba).isTrue();
    }
}
