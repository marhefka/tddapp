package com.training360.tdd;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class TanarDTO {
    public String azonosito;
    public String teljesNev;
    public String szuletesiDatum;

    public TanarDTO() {
    }

    // for tests only
    public TanarDTO(String azonosito, String teljesNev, String szuletesiDatum) {
        this.azonosito = azonosito;
        this.teljesNev = teljesNev;
        this.szuletesiDatum = szuletesiDatum;
    }

    // for tests only
    @Override
    public boolean equals(Object o) {
        TanarDTO that = (TanarDTO) o;

        return Objects.equals(this.azonosito, that.azonosito) &&
                Objects.equals(this.teljesNev, that.teljesNev) &&
                Objects.equals(this.szuletesiDatum, that.szuletesiDatum);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("azonosito", azonosito)
                .add("teljesNev", teljesNev)
                .add("szuletesiDatum", szuletesiDatum)
                .toString();
    }
}
