package com.training360.tdd;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@Transactional
public class TanarController {
    @Autowired
    private TanarService tanarService;

    @Autowired
    private TanarRepository tanarRepository;

    @PostMapping("/tanar/letrehoz")
    public void letrehozTanart(@RequestBody @Valid LetrehozTanartCommand command) {
        tanarService.letrehozTanart(command);
    }

    @PostMapping("/tanar/{azonosito}/modosit")
    public void modositTanarAdatait(@PathVariable String azonosito, @RequestBody ModositTanarAdataitCommand command) {
        tanarService.modositTanarAdatait(azonosito, command);
    }

    @GetMapping("/tanar")
    public List<TanarDTO> listTanarok() {
        return tanarRepository.findAll();
    }
}
