package com.training360.tdd;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TanarRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Tanar tanar) {
        entityManager.persist(tanar);
    }

    public long count() {
        return ((Number) entityManager.createQuery("SELECT COUNT(*) FROM Tanar t").getSingleResult()).longValue();
    }

    public void truncate() {
        entityManager.createNativeQuery("TRUNCATE TABLE TANAR").executeUpdate();
    }
}
