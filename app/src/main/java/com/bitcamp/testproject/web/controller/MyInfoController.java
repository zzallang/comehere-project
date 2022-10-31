package com.bitcamp.testproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.testproject.vo.Member;

@Controller
public class MyInfoController {

  @GetMapping("/my-Info")
  public String myPageMember(Member member) {
    System.out.println("??????왔니");
    return "myInfo";
  }

}
