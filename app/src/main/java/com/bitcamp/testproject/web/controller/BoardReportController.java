package com.bitcamp.testproject.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.testproject.service.BoardReportService;
import com.bitcamp.testproject.service.BoardService;

@Controller
@RequestMapping("/report/")
public class BoardReportController {

  @Autowired
  ServletContext sc;
  @Autowired
  BoardService boardService;
  @Autowired
  BoardReportService boardReportService;


  @GetMapping("insertReport")
  public void insertReport(      
      int id,
      int loginMemberNo,
      int boardNo) throws Exception {

    Map<String, Object> reportMap = new HashMap<>();

    reportMap.put("id",id);
    reportMap.put("loginMemberNo",loginMemberNo);
    reportMap.put("boardNo",boardNo);

    boardReportService.addReport(reportMap);
  }



}
