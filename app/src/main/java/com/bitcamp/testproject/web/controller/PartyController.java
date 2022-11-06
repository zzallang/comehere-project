package com.bitcamp.testproject.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.bitcamp.testproject.service.PartyCommentService;
import com.bitcamp.testproject.service.PartyService;
import com.bitcamp.testproject.service.RegionService;
import com.bitcamp.testproject.service.ReviewService;
import com.bitcamp.testproject.service.SportsService;
import com.bitcamp.testproject.vo.Member;
import com.bitcamp.testproject.vo.Party;

@Controller
@RequestMapping("/party/")
public class PartyController {

  ServletContext sc;
  PartyService partyService;
  RegionService regionService;
  SportsService sportsService;
  PartyCommentService partyCommentService;
  ReviewService reviewService;

  public PartyController(
      PartyService partyService, 
      RegionService regionService, 
      SportsService sportService, 
      PartyCommentService partyCommentService,
      ReviewService reviewService,
      ServletContext sc) {
    System.out.println("PartyController() 호출됨!");
    this.partyService = partyService;
    this.regionService = regionService;
    this.sportsService = sportService;
    this.partyCommentService = partyCommentService;
    this.reviewService = reviewService;
    this.sc = sc;
  }

  // InternalResourceViewResolver 사용 전:
  //
  //  @GetMapping("form")
  //  public String form() throws Exception {
  //    return "board/form";
  //  }

  // InternalResourceViewResolver 사용 후:
  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add") 
  public String add(
      Party party,
      MultipartFile[] files,
      HttpSession session) throws Exception {

    //party.setPartyAttachedFiles(saveAttachedFiles(files));
    party.setUser((Member) session.getAttribute("loginMember"));

    partyService.add(party);
    return "redirect:list";
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("partys", partyService.list());
    model.addAttribute("sidos", regionService.sidoList());
    model.addAttribute("regions", regionService.list());
    model.addAttribute("sports", sportsService.list());
  }

  @GetMapping("detail")
  public Map detail(int no, Model model) throws Exception {
    Party party = partyService.get(no);
    if (party == null) {
      throw new Exception("해당 번호의 모임이 없습니다!");
    }

    Map map = new HashMap();
    map.put("party", party);
    model.addAttribute("comments", partyCommentService.list(no));
    model.addAttribute("reviews", reviewService.list(no));
    return map;
  }

  @PostMapping("update")
  public String update(
      Party party,
      Part[] files,
      HttpSession session) 
          throws Exception {

    //party.setPartyAttachedFiles(savePartyAttachedFiles(files));

    checkOwner(party.getNo(), session);

    if (!partyService.update(party)) {
      throw new Exception("모임을 변경할 수 없습니다!");
    }

    return "redirect:list";
  }

  private void checkOwner(int partyNo, HttpSession session) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    if (partyService.checkOwner(partyNo).getNo() != loginMember.getNo()) {
      throw new Exception("모임 주최자가 아닙니다.");
    }
  }

  @GetMapping("delete")
  public String delete(
      int no, 
      HttpSession session) 
          throws Exception {

    checkOwner(no, session);
    if (!partyService.delete(no)) {
      throw new Exception("모임을 삭제할 수 없습니다.");
    }

    return "redirect:list";
  }
  /*
  @GetMapping("fileDelete")
  public String fileDelete(
      int no,
      HttpSession session) 
          throws Exception {

    PartyAttachedFile attachedFile = partyService.getPartyAttachedFile(no); 

    Member loginMember = (Member) session.getAttribute("loginMember");
    Party party = partyService.get(attachedFile.getPartyNo()); 

    if (party.getUser().getNo() != loginMember.getNo()) {
      throw new Exception("모임 주최자가 아닙니다.");
    }

    if (!partyService.deletePartyAttachedFile(no)) {
      throw new Exception("모임 첨부파일을 삭제할 수 없습니다.");
    }

    return "redirect:detail?no=" + party.getNo();
  }
   */
}






