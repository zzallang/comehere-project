package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Sport;

@Mapper
public interface SportDao {

  List<Sport> findAll();


}














