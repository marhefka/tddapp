package com.training360.tdd;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class TanarController {
    @Autowired
    private TanarService tanarService;

    @Autowired
    private TanarRepository tanarRepository;

    @PostMapping("/tanar/letrehoz")
    public Response letrehozTanart(@RequestBody @Valid LetrehozTanartCommand command) {
        try {
            tanarService.letrehozTanart(command);
            return new Response();
        } catch (DataIntegrityViolationException ex) {
            return new Response("ERROR_DUPLICATION");
        }
    }

    @PostMapping("/tanar/{azonosito}/modosit")
    public Response modositTanarAdatait(@PathVariable String azonosito, @RequestBody @Valid ModositTanarAdataitCommand command) {
        try {
            tanarService.modositTanarAdatait(azonosito, command);
            return new Response();
        } catch (Exception ex) {
            return new Response("ERROR_AZONOSITO_NOT_FOUND");
        }
    }

    @GetMapping("/tanar")
    public Response<List<TanarDTO>> listTanarok() {
        List<TanarDTO> tanarDTOS = tanarRepository.findAll();
        return new Response(Response.RESPONSE_CODE_OK, tanarDTOS);
    }
}
