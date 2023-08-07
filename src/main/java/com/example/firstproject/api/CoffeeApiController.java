package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeDTO;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import com.example.firstproject.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoffeeApiController {

    @Autowired
    private CoffeeService coffeeService;


    // get
    @GetMapping("/api/coffees")
    public List<Coffee> index() {
        return coffeeService.index();
    }
//
//    @GetMapping("/api/coffees/{id}")
//    public Coffee show(@PathVariable Long id) {
//        return coffeeRepository.findById(id).orElse(null);
//    }
//
//
//    // post
//    @PostMapping("/api/coffees")
//    public Coffee create(@RequestBody CoffeeDTO dto) {
//        Coffee coffee = dto.toEntity();
//        return coffeeRepository.save(coffee);
//    }
//
//    // patch
//    @PatchMapping("/api/coffees/{id}")
//    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDTO dto) {
//        Coffee coffee = dto.toEntity();
//
//        Coffee target = coffeeRepository.findById(id).orElse(null);
//
//        if (target == null || id != coffee.getId()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//
//        target.patch(coffee);
//        Coffee updated = coffeeRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
//
//
//
//    // delete
//    @DeleteMapping("/api/coffees/{id}")
//    public ResponseEntity<Coffee> delete(@PathVariable Long id){
//        Coffee target = coffeeRepository.findById(id).orElse(null);
//
//        if (target == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//
//        coffeeRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }


}
