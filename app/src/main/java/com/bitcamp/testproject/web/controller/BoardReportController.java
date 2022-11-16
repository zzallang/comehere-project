package com.bitcamp.testproject.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.testproject.service.BoardReportService;
import com.bitcamp.testproject.vo.Member;

@Controller
@RequestMapping("/boardReport/")
public class BoardReportController {

  @Autowired
  ServletContext sc;
  @Autowired
  BoardReportService boardReportService;


  @PostMapping("add")
  public String add(int boardNo,int objectNo, int value, String name, HttpSession session) throws Exception {
    Map<String, Object> reportMap = new HashMap<>();
    reportMap.put("trno", value);
    reportMap.put("mno", ((Member) session.getAttribute("loginMember")).getNo());
    reportMap.put("decbno",objectNo);

    if (name.equals("댓글")) {
      boardReportService.addCommentReport(reportMap);

    }
    if (name.equals("게시글")) {
      boardReportService.addBoardReport(reportMap);
    }
    return"redirect:../board/detail?no=" + boardNo;
  }

}
