package com.example.firstproject.dto;

import com.example.firstproject.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PizzaDTO {

    private Long id;
    private String name;
    private Integer price;

    public static PizzaDTO createPizzaDto(Pizza pizza) {
        return new PizzaDTO(
                pizza.getId(),
                pizza.getName(),
                pizza.getPrice()
        );
    }
}
