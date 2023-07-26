package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController  {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String newMemberForm() {
        return "members/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm form) {
        log.info(form.toString());
        // 1. dto -> entity
        Member member = form.toEntity();
        log.info(member.toString());
        // 2. save it on db
        Member saved = memberRepository.save(member);
        log.info(saved.toString());

        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        // 1. 데이터 가져오기
        Member member = memberRepository.findById(id).orElse(null);
        log.info("member = " + member.toString());
        // 2. 모델에 데이터 보관하기
        model.addAttribute("member", member);
        // 3. 뷰에서 데이터 렌더링하기
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        // 1. 데이터 가져오기
        ArrayList<Member> memberEntityList = memberRepository.findAll();
        // 2. 모델에 데이터 보관하기
        model.addAttribute("memberList", memberEntityList);
        // 3. 뷰에서 데이터 렌더링하기
        return "members/index";
    }



}
