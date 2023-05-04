package com.training360.tdd;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

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

    public List<TanarDTO> findAll() {
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT t.AZONOSITO, t.TELJES_NEV, t.SZULETESI_DATUM FROM TANAR t ORDER BY t.azonosito").getResultList();
        return resultList.stream().map(new ObjectArrayTanarDTOFunction()).toList();
    }

    private static class ObjectArrayTanarDTOFunction implements Function<Object[], TanarDTO> {
        @Override
        public TanarDTO apply(Object[] objects) {
            TanarDTO dto = new TanarDTO();
            dto.azonosito = (String) objects[0];
            dto.teljesNev = (String) objects[1];
            dto.szuletesiDatum = new SimpleDateFormat("yyyy.MM.dd").format((Date) objects[2]);
            return dto;
        }
    }
}
