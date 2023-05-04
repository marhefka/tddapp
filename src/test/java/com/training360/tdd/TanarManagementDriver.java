package com.training360.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TanarManagementDriver {
    @Autowired
    private TanarService tanarService;

    public void letrehozTanart(String azonosito, String teljesNev, String sSzuletesiDatum) {
        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.azonosito = azonosito;
        command.teljesNev = teljesNev;
        command.szuletesiDatum = parseHungarianDateFormat(sSzuletesiDatum);

        tanarService.letrehozTanart(command);
    }

    public void letrehozTanartCsakAzonositoval(String azonosito) {
        LetrehozTanartCommand command = new LetrehozTanartCommand();
        command.azonosito = azonosito;
        command.teljesNev = "teljesNev" + azonosito;
        command.szuletesiDatum = parseHungarianDateFormat("1980.01.01");

        tanarService.letrehozTanart(command);
    }

    public List<TanarDTO> listTanarok() {
        return tanarService.listTanarok();
    }

    private LocalDate parseHungarianDateFormat(String sSzuletesiDatum) {
        if (sSzuletesiDatum == null) {
            return null;
        }

        return LocalDate.parse(sSzuletesiDatum, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }
}
