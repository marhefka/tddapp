package com.training360.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TddController {
    @Autowired
    private GreetingService greetingService;

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/greeting")
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
        greetingService.greet(name);
        return "Hello, " + name + "!";
    }


    @GetMapping("/fetchGreetings")
    public List<GreetingDTO> fetchGreetings() {
        return greetingRepository.fetchAll();
    }
}
