package com.training360.tdd;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class TestHelper {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void truncateTables() {
        entityManager.createNativeQuery("TRUNCATE TABLE TANAR").executeUpdate();
    }
}
