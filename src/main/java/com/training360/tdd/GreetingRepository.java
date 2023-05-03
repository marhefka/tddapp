package com.training360.tdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    @Query("SELECT new com.training360.tdd.GreetingDTO(g.name) FROM Greeting g")
    List<GreetingDTO> fetchAll();
}
