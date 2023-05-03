package com.training360.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
        userService.greet(name);
        return "Hello, " + name + "!";
    }

    @GetMapping("/fetchGreetings")
    public List<UserDTO> fetchGreetings() {
        return userRepository.fetchAll();
    }
}
