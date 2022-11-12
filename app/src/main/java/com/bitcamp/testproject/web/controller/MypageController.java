package com.bitcamp.testproject.web.controller;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.testproject.service.BoardService;
import com.bitcamp.testproject.service.MemberService;
import com.bitcamp.testproject.vo.Member;

@Controller
@RequestMapping("/mypage/")
public class MypageController {

  @Autowired
  ServletContext sc;
  @Autowired
  BoardService boardService;
  @Autowired
  MemberService memberService;


  @GetMapping("my-post")
  public String partyPost(Member member) {
    return "mypage/myPost";
  }

  @GetMapping("party-management")
  public String partyMgmt(Member member/* , Party party */) {
    return "mypage/partyMgmt";
  }

}






