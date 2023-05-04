package com.training360.tdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.training360.tdd.Response.isNotOk;
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
        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.azonosito = azonosito;
        command.teljesNev = teljesNev;
        command.szuletesiDatum = LocalDate.parse(sSzuletesiDatum, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        hiba = isNotOk(tanarController.letrehozTanart(command));
    }

    @Then("A tanárok listájában {int} névnek kell szerepelnie")
    public void aTanárokListájábanNévnekKellSzerepelnie(int count) {
        assertThat(tanarController.listTanarok().getPayload().size()).isEqualTo(count);
    }

    @Then("Hibaüzenetet kapok")
    public void hibaüzenetetKapok() {
        assertThat(hiba).isTrue();
    }
}
