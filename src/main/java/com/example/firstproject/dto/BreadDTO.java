package com.example.firstproject.dto;

import com.example.firstproject.entity.Bread;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class BreadDTO {

    private Long id;

    private String name;

    private String price;

    public Bread toEntity() {
        return new Bread(id, name, price);
    }
}
