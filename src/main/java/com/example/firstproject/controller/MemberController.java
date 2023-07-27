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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Optional;

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

        return "redirect:/members/" + saved.getId();
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
        // 1. 데이터 가져옴
        ArrayList<Member> memberEntityList = memberRepository.findAll();
        // 2. 모델에 데이터 보관
        model.addAttribute("memberList", memberEntityList);
        // 3. 뷰에서 데이터 렌더링하기
        return "members/index";
    }


    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 1. 데이터 가져옴
        Member memberEntity = memberRepository.findById(id).orElse(null);
        // 2. 데이터 보관
        model.addAttribute("member", memberEntity);
        // 3. 수정페이지 렌더링
        return "/members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form) {
        log.info(form.toString());
        // 1. DTO -> Entity
        Member memberEntity = form.toEntity();
        log.info(memberEntity.toString());

        // 2. Entity DB에 저장
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);

        if (target != null) {
            memberRepository.save(memberEntity);
        }

        // 3. 수정 결과 페이지로 리다이렉트
        return "redirect:/members/" + memberEntity.getId();

    }

    @GetMapping("members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {

        // 1. 삭제 대상 가져옴
        Member target = memberRepository.findById(id).orElse(null);

        // 2. 대상 엔티티 삭제
        if (target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제되었습니다!");
        }

        // 3. 결과 페이지로 리다이렉트
        return "redirect:/members";
    }

}
