package com.training360.tdd;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TANAR")
public class Tanar {
    @Id
    @Column(name = "AZONOSITO")
    private String azonosito;

    @Column(name = "TELJES_NEV")
    private String teljesNev;

    @Column(name = "SZULETESI_DATUM")
    private Date szuletesiDatum;

    protected Tanar() {
    }

    public Tanar(String teljesNev, Date szuletesiDatum, String azonosito) {
        this.teljesNev = teljesNev;
        this.szuletesiDatum = szuletesiDatum;
        this.azonosito = azonosito;
    }
}
