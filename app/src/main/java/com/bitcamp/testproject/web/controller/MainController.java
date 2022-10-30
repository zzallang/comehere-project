package com.bitcamp.testproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.testproject.vo.Member;

@Controller
public class MainController {

  @GetMapping("/main")
  public String myPageMember(Member member) {

    return "main";
  }

}
