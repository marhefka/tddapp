package com.training360.tdd;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class TeacherRestController {
    @Autowired
    private TanarService tanarService;

    @Autowired
    private UserRepository tanarRepository;

    @PostMapping("/letrehozTanart1111")
    public void letrehozTanart1111(@RequestBody @Valid LetrehozTanartCommand command) {
        tanarService.letrehozTanart(command);
    }

}
