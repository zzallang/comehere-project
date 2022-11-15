package com.bitcamp.testproject.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.testproject.service.PartyReportService;
import com.bitcamp.testproject.service.PartyService;

@Controller
@RequestMapping("/partreport/")
public class PartyReportController {

  @Autowired
  ServletContext sc;
  @Autowired
  PartyService partyService;
  @Autowired
  PartyReportService partyReportService;


  @GetMapping("insertReport")
  public void insertReport(      
      int id,
      int loginMemberNo,
      int partyNo) throws Exception {

    Map<String, Object> reportMap = new HashMap<>();

    reportMap.put("id",id);
    reportMap.put("loginMemberNo",loginMemberNo);
    reportMap.put("partyNo",partyNo);

    partyReportService.addReport(reportMap);
  }



}
