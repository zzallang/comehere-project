package com.bitcamp.testproject.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.testproject.vo.Member;

@Controller
public class PWCheckController {

  @GetMapping("/viewer")
  public String passwordCheckViewer() {

    return "pwCheckViewer";
  }

  @PostMapping("/confirmation")
  public String confirmation(HttpSession httpSession, Member member) {
    System.out.println(member.getPassword() + " <-----");
    return "redirect:/viewer";
  }

}
