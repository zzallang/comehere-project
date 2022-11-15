package com.bitcamp.testproject.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.testproject.service.BoardService;
import com.bitcamp.testproject.service.MemberService;
import com.bitcamp.testproject.vo.Criteria;
import com.bitcamp.testproject.vo.Member;
import com.bitcamp.testproject.vo.PageMaker;

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
  public String myPost(HttpSession session, Model model, Criteria cri) throws Exception {

    Member loginMember = (Member) session.getAttribute("loginMember");

    // 페이징하기 위한 연산 
    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);
    pageMaker.setTotalCount(boardService.countMyPost(loginMember.getNo()));

    Map<String, Object> paramMap = new HashMap<String, Object>();
    paramMap.put("memberNo", loginMember.getNo());
    paramMap.put("pagesStart", cri.getPagesStart());
    paramMap.put("perPageNum", cri.getPerPageNum());

    model.addAttribute("myPostList", boardService.findByMyPost(paramMap));
    model.addAttribute("pageMaker", pageMaker);

    return "mypage/myPost";
  }



  @GetMapping("party-management")
  public String partyMgmt(Member member/* , Party party */) {
    return "mypage/partyMgmt";
  }

}






