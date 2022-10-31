package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.SportDao;
import com.bitcamp.testproject.vo.Sport;

@Service
public class DefaultSportService implements SportService {

  @Autowired 
  SportDao sportDao;

  @Override
  public List<Sport> list() {
    return sportDao.findAll();
  }


}








