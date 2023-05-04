package com.training360.tdd;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
@Validated
@Transactional
public class TanarService {
    @Autowired
    private TanarRepository tanarRepository;

    public void letrehozTanart(@RequestBody @Valid LetrehozTanartCommand command) {
        Tanar tanar = new Tanar(command.teljesNev, command.szuletesiDatum, command.azonosito);
        tanarRepository.persist(tanar);
    }

    public List<TanarDTO> listTanarok() {
        return tanarRepository.findAll();
    }
}
