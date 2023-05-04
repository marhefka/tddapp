package com.training360.tdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class TanarManagementStepdefs {
    @Autowired
    private TanarManagementDriver tanarManagementDriver;

    private boolean hiba;

    @Given("Egy tanár a rendszerben {string} teljes névvel, {string} születési dátummal és {string} azonosítóval")
    @When("Hozzáadok egy új tanárt {string} teljes névvel, {string} születési dátummal és {string} azonosítóval")
    public void hozzáadokEgyÚjTanártTeljesNévvelSzületésiDátummalÉsAzonosítóval(String teljesNev, String sSzuletesiDatum, String azonosito) throws Exception {
        try {
            tanarManagementDriver.letrehozTanart(azonosito, teljesNev, sSzuletesiDatum);
            hiba = false;
        } catch (Exception ex) {
            hiba = true;
        }
    }

    @Then("A tanárok listájában {int} névnek kell szerepelnie")
    public void aTanárokListájábanNévnekKellSzerepelnie(int count) {
        assertThat(tanarManagementDriver.listTanarok().size()).isEqualTo(count);
    }

    @Then("Hibaüzenetet kapok")
    public void hibaüzenetetKapok() {
        assertThat(hiba).isTrue();
    }
}
