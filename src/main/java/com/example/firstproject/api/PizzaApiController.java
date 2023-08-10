package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDTO;
import com.example.firstproject.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaApiController {
    @Autowired
    private PizzaService pizzaService;

    // 1. 피자 단일 조회
    @GetMapping("/api/pizzas/{id}")
    public ResponseEntity<PizzaDTO> get(@PathVariable Long id) {
        PizzaDTO dto = pizzaService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    // 2. 피자 모두 조회
    @GetMapping("/api/pizzas")
    public ResponseEntity<List<PizzaDTO>> getAll() {
        List<PizzaDTO> dtos = pizzaService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 3. 피자 생성
    @PostMapping("/api/pizzas")
    public ResponseEntity<PizzaDTO> create(@RequestBody PizzaDTO dto) {
        PizzaDTO createdDto = pizzaService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 4. 피자 수정
    @PatchMapping("/api/pizzas/{id}")
    public ResponseEntity<PizzaDTO> update(@PathVariable Long id,
                                           @RequestBody PizzaDTO dto) {
        PizzaDTO updatedDTO = pizzaService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDTO);
    }

    // 5. 피자 삭제
    @DeleteMapping("/api/pizzas/{id}")
    public ResponseEntity<PizzaDTO> delete(@PathVariable Long id) {
        PizzaDTO deletedDto = pizzaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }


}
