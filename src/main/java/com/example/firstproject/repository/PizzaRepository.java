package com.example.firstproject.repository;

import com.example.firstproject.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    @Query(value = "SELECT * FROM pizza WHERE id = :id", nativeQuery = true)
    Optional<Pizza> findById(Long id);

    List<Pizza> findAll();

}
