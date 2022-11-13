package com.bitcamp.testproject.dao;

import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Scrap;

@Mapper
public interface ScrapDao {

  int insert(Scrap scrap);

  int delete(Scrap scrap);

  int deleteAll(int no);

}
