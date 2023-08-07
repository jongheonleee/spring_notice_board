package com.example.firstproject.api;

import com.example.firstproject.dto.BreadDTO;
import com.example.firstproject.entity.Bread;
import com.example.firstproject.repository.BreadRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BreadController {

    @Autowired
    private BreadRepository breadRepository;

    // get
    @GetMapping("/api/breads")
    public List<Bread> index() {
        return breadRepository.findAll();
    }

    @GetMapping("/api/breads/{id}")
    public Bread show(@PathVariable Long id) {
        return breadRepository.findById(id).orElse(null);
    }

    // post
    @PostMapping("/api/breads")
    public Bread create(@RequestBody BreadDTO dto) {
        Bread bread = dto.toEntity();
        return breadRepository.save(bread);
    }


    // patch
    @PatchMapping("/api/breads/{id}")
    public ResponseEntity<Bread> update(@PathVariable Long id, @RequestBody BreadDTO dto) {
        Bread bread = dto.toEntity();

        Bread target = breadRepository.findById(id).orElse(null);
        if (target == null || bread.getId() != id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        target.patch(bread);
        Bread updated = breadRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }


    // delete
    @DeleteMapping("/api/breads/{id}")
    public ResponseEntity<Bread> delete(@PathVariable Long id) {
        Bread target = breadRepository.findById(id).orElse(null);

        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        breadRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
