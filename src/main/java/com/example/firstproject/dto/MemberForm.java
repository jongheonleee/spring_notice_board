package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {

    private String email;
    private String password;
    private String name;
    private Integer age;

    public Member toEntity() {
        return new Member(null, email, password, name, age);
    }
}
