package com.example.firstproject.entity;


import com.example.firstproject.dto.PizzaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    public static Pizza createPizza(PizzaDTO dto) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("피자 생성 실패! 피자의 id가 없어야함");
        }

        return new Pizza(
                dto.getId(),
                dto.getName(),
                dto.getPrice()
        );
    }


    public void patch(PizzaDTO dto) {
        if (this.id != dto.getId()) {
            throw new IllegalArgumentException("피자 수정 실패! 잘못된 id가 입력되었습니다!");
        }

        if (dto.getName() != null) {
            this.name = dto.getName();
        }

        if (dto.getPrice() != null) {
            this.price = dto.getPrice();
        }
    }
}
