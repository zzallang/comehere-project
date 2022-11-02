package com.bitcamp.testproject.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bitcamp.testproject.service.MemberService;
import com.bitcamp.testproject.vo.Member;

@Controller 
@RequestMapping("/auth/")
public class AuthController {

  MemberService memberService;

  public AuthController(MemberService memberService) {
    System.out.println("AuthController() 호출됨!");
    this.memberService = memberService;
  }

  @GetMapping("form") 
  public String form(@CookieValue(name="id",defaultValue="") String id, Model model) throws Exception {
    model.addAttribute("id", id);
    return "auth/form";
  }

  @PostMapping("login") 
  public ModelAndView login(
      String id,
      String password, 
      HttpServletResponse response,
      HttpSession session) throws Exception {

    Member member = memberService.get(id, password);

    if (member != null) {
      session.setAttribute("loginMember", member); 
    }

    Cookie cookie = new Cookie("id", id); 
    if (id == null) {
      cookie.setMaxAge(0); 
    } else {
      cookie.setMaxAge(60 * 60 * 24 * 7); // 7일
    }
    response.addCookie(cookie); 
    ModelAndView mv = new ModelAndView("auth/loginResult");
    mv.addObject("member", member);
    return mv;
  }


  @GetMapping("findId")
  public String findId() {
    return "auth/findId";
  }

  @GetMapping("findById")
  public ModelAndView findById(     
      String name,
      String email, 
      HttpServletResponse response,
      HttpSession session) throws Exception {

    Member member = memberService.getId(name, email);

    if (name != null) {
      session.setAttribute("findId", name); 
    }

    ModelAndView mv = new ModelAndView("auth/findIdResult");
    mv.addObject("member", member);
    return mv;
  }

  @GetMapping("findPassword")
  public String findIdPassword() {
    return "auth/findPassword";
  }

  @GetMapping("findByPassword")
  public ModelAndView findByPassword(     
      String id,
      String email,
      String SecCode, 
      HttpServletResponse response,
      HttpSession session) throws Exception {

    Member member = memberService.get(id, email);

    if (id != null) {
      session.setAttribute("findPassword", id); 
    }

    ModelAndView mv = new ModelAndView("auth/newPassword");
    mv.addObject("member", member);
    return mv;
  }


  @GetMapping("logout") 
  public String logout(HttpSession session) throws Exception {
    session.invalidate(); 
    return "redirect:../"; 
  }


  // 은지
  @GetMapping("join")
  public String form(Model model) throws Exception {
    model.addAttribute("data", "join page");

    return "auth/join";
  }
  @PostMapping("add")
  public String add(Member member) throws Exception {
    memberService.add(member);
    return "redirect:join";
  }

  @GetMapping("mypage-member")
  public String myPageMember(Member member) {

    return "myPageMember";
  }


}






