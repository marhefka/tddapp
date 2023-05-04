package com.training360.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private Date parseHungarianDateFormat(String sSzuletesiDatum) {
        try {
            if (sSzuletesiDatum == null) {
                return null;
            }

            return new SimpleDateFormat("yyyy.MM.dd").parse(sSzuletesiDatum);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}
