package com.bitcamp.testproject.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.PartyReportDao;

@Service
public class DefaultPartyReportService implements PartyReportService {

  @Autowired 
  PartyReportDao partyReportDao;

  @Override
  public void addReport(Map<String, Object> reportMap) {


    if (partyReportDao.insertReport(reportMap) == 0) {
      System.out.println("d");
    };

  }

  //////////

}








