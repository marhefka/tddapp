package com.training360.tdd;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TANAR")
public class Tanar {
    @Id
    @Column(name = "ROVID_NEV")
    private String rovidNev;

    @Column(name = "TELJES_NEV")
    private String teljesNev;

    @Column(name = "SZULETESI_DATUM")
    private Date szuletesiDatum;

    protected Tanar() {
    }

    public Tanar(String teljesNev, Date szuletesiDatum, String rovidNev) {
        this.teljesNev = teljesNev;
        this.szuletesiDatum = szuletesiDatum;
        this.rovidNev = rovidNev;
    }
}
