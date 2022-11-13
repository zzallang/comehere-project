package com.bitcamp.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.ScrapDao;
import com.bitcamp.testproject.vo.Scrap;

@Service
public class DefaultScrapService implements ScrapService {

  @Autowired 
  ScrapDao scrapDao;

  @Override
  public int insert(Scrap scrap) {
    return scrapDao.insert(scrap);
  }

  @Override
  public int delete(Scrap scrap) {
    return scrapDao.delete(scrap);
  }
}








