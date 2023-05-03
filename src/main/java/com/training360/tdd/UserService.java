package com.training360.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void greet(String who) {
        userRepository.save(new User(who));
    }
}
