package com.bitcamp.testproject.dao;

import com.bitcamp.testproject.vo.Health;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HealthDao {

  int insert(Health health);
  List<Health> findAll();

  Health findDetail(int no);

  int update(Health health);

  int delete(int no);

}
