package com.bitcamp.testproject.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.bitcamp.testproject.service.FavoriteRegionService;
import com.bitcamp.testproject.service.FavoriteSportsService;
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
  @Autowired
  FavoriteRegionService favoriteRegionService;
  @Autowired
  FavoriteSportsService favoriteSportsService;

  // 은지
  @GetMapping("join")
  public String form(Model model) throws Exception {
    model.addAttribute("regionList", regionService.list());
    model.addAttribute("sportsList", sportsService.list());
    return "auth/join";
  }

  @PostMapping("addjoin")
  public ModelAndView add(Member member) throws Exception {
    System.out.println(member);
    member.setFavoriteRegion(saveRegion(member));
    member.setFavoriteSports(saveSports(member));
    memberService.add(member);
    ModelAndView mv = new ModelAndView("redirect:../auth/form");
    return mv;
  }

  @GetMapping("viewer")
  public String passwordCheckViewer() {
    return "member/pwCheckViewer";
  }

  @GetMapping("myInfo")
  public String confirmation(HttpSession session, Model model) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    Member member = memberService.get(loginMember.getNo());
    member.setNo(loginMember.getNo());
    model.addAttribute("member", member);
    model.addAttribute("regionList", regionService.list());
    model.addAttribute("sportsList", sportsService.list());
    System.out.println("loginMember :" + loginMember);
    System.out.println("member :" + member.toString());
    return "member/myInfo";
  }

  @Transactional
  @PostMapping("memberUpdate")
  public ModelAndView myPageMember(HttpSession session, Member member) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    favoriteRegionService.deleteFavoriteRegion(loginMember.getNo());
    favoriteSportsService.deleteFavoriteSports(loginMember.getNo());
    member.setNo(loginMember.getNo());
    System.out.println(member.getRegionDomain());
    System.out.println(member.getSportsDomain());
    member.setFavoriteRegion(saveRegion(member));
    member.setFavoriteSports(saveSports(member));
    favoriteRegionService.addFavoriteRegion(member);
    favoriteSportsService.addFavoriteSports(member);
    //member update logic
    //...
    memberService.update(member);
    ModelAndView mv = new ModelAndView("redirect:myInfo");
    return mv;
  }


  @PostMapping("duplicationIdCheck")
  @ResponseBody
  public int idCheck(String id) throws Exception{
    int result = memberService.idCheck(id); 
    return result;
  }

  @PostMapping("duplicationEmailCheck")
  @ResponseBody
  public int emailCheck(String email) throws Exception{
    int result = memberService.emailCheck(email); 
    return result;
  }

  @PostMapping("verificationPWCheck")
  @ResponseBody
  public int pWCheck(HttpSession session, String password) throws Exception{
    Member loginMember = (Member) session.getAttribute("loginMember");
    System.out.println(password);
    System.out.println(loginMember);
    int result = memberService.verificationPw(password, loginMember.getNo());
    return result;
  }

  @PostMapping("duplicationNickCheck")
  @ResponseBody
  public int nickCheck(String nickname) throws Exception{
    int result = memberService.nickCheck(nickname);
    return result;
  }

  public List<FavoriteRegion> saveRegion(Member member) {
    List<FavoriteRegion> favoriteRegion = new ArrayList<>();
    for (int no : member.getRegionDomain()) {
      favoriteRegion.add(new FavoriteRegion(no));
    }

    return favoriteRegion;
  }

  public List<FavoriteSports> saveSports(Member member) {
    List<FavoriteSports> favoriteSports = new ArrayList<>();
    for (int no : member.getSportsDomain()) {
      favoriteSports.add(new FavoriteSports(no));
    }

    return favoriteSports;
  }
}





