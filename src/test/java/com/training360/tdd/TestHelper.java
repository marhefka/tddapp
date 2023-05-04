package com.training360.tdd;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestHelper {
    @PersistenceContext
    private EntityManager entityManager;

    public void truncateTables() {
        entityManager.createNativeQuery("TRUNCATE TABLE TANAR").executeUpdate();
    }
}
