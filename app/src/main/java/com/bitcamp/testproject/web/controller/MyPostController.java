package com.bitcamp.testproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.testproject.vo.Member;

@Controller
public class MyPostController {

  @GetMapping("/my-post")
  public String partyMgmt(Member member) {
    return "myPost";
  }

}
