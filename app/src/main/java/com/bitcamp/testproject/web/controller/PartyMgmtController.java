package com.bitcamp.testproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.testproject.vo.Member;

@Controller
public class PartyMgmtController {

  @GetMapping("/party-management")
  public String partyMgmt(Member member/* , Party party */) {
    return "partyMgmt";
  }

}
