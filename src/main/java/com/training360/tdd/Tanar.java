package com.training360.tdd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "TANAR")
public class Tanar {
    @Id
    @Column(name = "AZONOSITO")
    private String azonosito;

    @Column(name = "TELJES_NEV")
    private String teljesNev;

    @Column(name = "SZULETESI_DATUM")
    private LocalDate szuletesiDatum;

    protected Tanar() {
    }

    public Tanar(String teljesNev, LocalDate szuletesiDatum, String azonosito) {
        this.teljesNev = teljesNev;
        this.szuletesiDatum = szuletesiDatum;
        this.azonosito = azonosito;
    }

    public void modositAdatokat(String teljesNev, LocalDate szuletesiDatum) {
        this.teljesNev = teljesNev;
        this.szuletesiDatum = szuletesiDatum;
    }
}
