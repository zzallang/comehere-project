package com.bitcamp.testproject.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.testproject.service.PartyCommentService;
import com.bitcamp.testproject.service.PartyService;
import com.bitcamp.testproject.service.RegionService;
import com.bitcamp.testproject.service.ReviewService;
import com.bitcamp.testproject.service.SportsService;
import com.bitcamp.testproject.vo.AttachedFile;
import com.bitcamp.testproject.vo.Member;
import com.bitcamp.testproject.vo.Party;
import com.bitcamp.testproject.vo.PartyMember;

@Controller
@RequestMapping("/party/")
public class PartyController {

  // 파티 지울때 멤버도 지워야?

  // 파티 파일, 댓글, 후기파일, 후기, 명단 

  ServletContext sc;
  PartyService partyService;
  RegionService regionService;
  SportsService sportsService;
  PartyCommentService partyCommentService;
  ReviewService reviewService;

  public PartyController(
      PartyService partyService, 
      RegionService regionService, 
      SportsService sportsService, 
      PartyCommentService partyCommentService,
      ReviewService reviewService,
      ServletContext sc) {
    System.out.println("PartyController() 호출됨!");
    this.partyService = partyService;
    this.regionService = regionService;
    this.sportsService = sportsService;
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
  public void form(Model model) throws Exception {
    model.addAttribute("regions", regionService.list());
    model.addAttribute("sports", sportsService.list());

  }

  @GetMapping("attendForm") 
  public Map attendForm(int no) throws Exception {
    Party party = partyService.get(no);
    if (party == null) {
      throw new Exception("해당 번호의 모임이 없습니다!");
    }
    Map map = new HashMap();
    map.put("party", party);
    return map;
  }

  @PostMapping("add") 
  public String add(
      Party party,
      PartyMember partyMember,
      Part[] files,
      HttpSession session) throws Exception {
    if (files != null) {
      party.setAttachedFiles(savePartyAttachedFiles(files));
    }
    party.setUser((Member) session.getAttribute("loginMember"));

    partyService.add(party, partyMember);
    return "redirect:list";
  }

  @PostMapping("attendAdd")
  public String attendAdd(
      Party party,
      PartyMember partyMember,
      HttpSession session) throws Exception {
    party.setUser((Member) session.getAttribute("loginMember"));
    partyService.attend(party, partyMember);
    return "redirect:list";
  }

  private List<AttachedFile> savePartyAttachedFiles(Part[] files)
      throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/party/files");

    for (Part part : files) {
      if (part.getSize() == 0) {
        continue;
      }

      String filename = UUID.randomUUID().toString();
      part.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename));
    }
    return attachedFiles;
  }



  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("partys", partyService.list());
    model.addAttribute("regions", regionService.list());
    model.addAttribute("sports", sportsService.list());
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
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

  @GetMapping("updateForm")
  public Model updateForm(int no, Model model) throws Exception {
    Party party = partyService.get(no);
    if (party == null) {
      throw new Exception("해당 번호의 모임이 없습니다!");
    }

    model.addAttribute("regions", regionService.list());
    model.addAttribute("sports", sportsService.list());

    return model.addAttribute("party", party);
  }

  @PostMapping("update")
  public String update(
      Party party,
      Part[] files,
      HttpSession session) 
          throws Exception {
    if (files != null) {
      party.setAttachedFiles(savePartyAttachedFiles(files));
    }
    checkOwner(party.getNo(), session);
    if (!partyService.update(party)) {
      throw new Exception("모임을 변경할 수 없습니다!");
    }
    return "redirect:list";
  }

  private void checkOwner(int partyNo, HttpSession session) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    if (partyService.checkOwner(partyNo) != loginMember.getNo()) {
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

  @GetMapping("fileDelete")
  public String fileDelete(
      int no,
      HttpSession session) 
          throws Exception {

    AttachedFile attachedFile = partyService.getAttachedFile(no); 

    Member loginMember = (Member) session.getAttribute("loginMember");
    Party party = partyService.get(attachedFile.getObjectNo()); 

    if (party.getUser().getNo() != loginMember.getNo()) {
      throw new Exception("모임 주최자가 아닙니다.");
    }

    if (!partyService.deleteAttachedFile(no)) {
      throw new Exception("모임 첨부파일을 삭제할 수 없습니다.");
    }

    return "redirect:detail?no=" + party.getNo();
  }

}






