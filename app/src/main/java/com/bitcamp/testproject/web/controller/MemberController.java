package com.bitcamp.testproject.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bitcamp.testproject.service.MemberService;
import com.bitcamp.testproject.service.RegionService;
import com.bitcamp.testproject.service.SportsService;
import com.bitcamp.testproject.vo.FavoriteRegion;
import com.bitcamp.testproject.vo.FavoriteSports;
import com.bitcamp.testproject.vo.Member;

@Controller
@RequestMapping("/member/")
public class MemberController {

  @Autowired
  ServletContext sc;
  @Autowired
  MemberService memberService;
  @Autowired
  RegionService regionService;
  @Autowired
  SportsService sportsService;

  // 은지
  @GetMapping("join")
  public String form(Model model) throws Exception {
    model.addAttribute("data", "join page");

    return "auth/join";
  }

  @PostMapping("addjoin")
  public ModelAndView add(Member member, int[] region_domain, int[] sports_domain) throws Exception {
    member.setFavoriteRegion(saveRegion(region_domain));
    member.setFavoriteSports(saveSports(sports_domain));

    memberService.add(member);
    ModelAndView mv = new ModelAndView("redirect:form");
    return mv;
  }

  @GetMapping("viewer")
  public String passwordCheckViewer() {
    return "/member/pwCheckViewer";
  }

  @PostMapping("myInfo")
  public String confirmation(HttpSession session, String password) {
    //    System.out.println(member.getPassword() + " <-----");
    Member loginMember = (Member) session.getAttribute("loginMember");
    System.out.println(loginMember);
    return "/member/myInfo";
  }


  @PostMapping("memberUpdate")
  public String myPageMember(Member member, int[] region_domain, int[] sports_domain) throws Exception {
    System.out.println("??????왔니");
    memberService.update(member);
    member.setFavoriteRegion(saveRegion(region_domain));
    member.setFavoriteSports(saveSports(sports_domain));

    return "/member/myInfo";
  }


  public List<FavoriteRegion> saveRegion(int[] region_domain) {
    List<FavoriteRegion> favoriteRegion = new ArrayList<>();
    for (int no : region_domain) {
      favoriteRegion.add(new FavoriteRegion(no));
    }

    return favoriteRegion;
  }

  public List<FavoriteSports> saveSports(int[] region_domain) {
    List<FavoriteSports> favoriteSports = new ArrayList<>();
    for (int no : region_domain) {
      favoriteSports.add(new FavoriteSports(no));
    }

    return favoriteSports;
  }
}






