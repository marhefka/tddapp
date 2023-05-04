package com.training360.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestHelper {
    @Autowired
    private TanarRepository tanarRepository;

    public void truncateTables() {
        tanarRepository.truncate();
    }
}
