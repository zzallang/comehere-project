package com.bitcamp.testproject.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.testproject.service.JoinService;
import com.bitcamp.testproject.vo.Member;

@Controller
public class JoinController {

  @Autowired
  private JoinService joinService;


  @GetMapping("/join")
  public String join(Model model) {

    model.addAttribute("data", "join page");

    return "join";
  }

  @PostMapping("/sign-up")
  public String signUp(Member member) {
    System.out.println("member : " + member.getName()); 

    joinService.signUpProcess(member);

    return "redirect:join";
  }

  @GetMapping("/mypage-member")
  public String myPageMember(Member member) {

    return "myPageMember";
  }

}
