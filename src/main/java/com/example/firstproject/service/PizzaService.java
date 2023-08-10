package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDTO;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    // 1. 조회

    // 단일 조회
    @Transactional
    public PizzaDTO get(Long id) {
        Pizza found = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("피자 조회 실패!" +
                        "해당 피자가 존재하지 않습니다!"));

        return PizzaDTO.createPizzaDto(found);

    }

    // 전체 조회
    @Transactional
    public List<PizzaDTO> getAll() {
        return pizzaRepository.findAll()
                .stream()
                .map(pizza -> PizzaDTO.createPizzaDto(pizza))
                .collect(Collectors.toList());
    }

    // 생성
    @Transactional
    public PizzaDTO create(PizzaDTO dto) {
        Pizza pizza = Pizza.createPizza(dto);
        Pizza created = pizzaRepository.save(pizza);
        return PizzaDTO.createPizzaDto(created);
    }

    @Transactional
    public PizzaDTO update(Long id, PizzaDTO dto) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("피자 수정 실패!" +
                        "대상 피자가 없습니다"));
        target.patch(dto);
        Pizza updated = pizzaRepository.save(target);
        return PizzaDTO.createPizzaDto(updated);

    }

    @Transactional
    public PizzaDTO delete(Long id) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("피자 삭제 실패!" +
                        "대상 피자가 없습니다"));

        pizzaRepository.delete(target);

        return PizzaDTO.createPizzaDto(target);
    }
}
