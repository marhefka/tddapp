package com.training360.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;

    public void greet(String who) {
        greetingRepository.save(new Greeting(who));
    }
}
