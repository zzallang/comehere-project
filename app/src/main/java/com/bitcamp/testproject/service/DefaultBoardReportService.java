package com.bitcamp.testproject.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.BoardReportDao;

@Service
public class DefaultBoardReportService implements BoardReportService {

  @Autowired 
  BoardReportDao boardReportDao;

  @Override
  public void addReport(Map<String, Object> reportMap) {


    if (boardReportDao.insertReport(reportMap) == 0) {
      System.out.println("d");
    };

  }

  //////////

}








