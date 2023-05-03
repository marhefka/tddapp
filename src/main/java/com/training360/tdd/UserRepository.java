package com.training360.tdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.training360.tdd.UserDTO(g.name) FROM User g")
    List<UserDTO> fetchAll();
}
