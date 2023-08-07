package com.example.firstproject.repository;

import com.example.firstproject.entity.Bread;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BreadRepository extends CrudRepository<Bread, Long> {

    @Override
    ArrayList<Bread> findAll();
}
