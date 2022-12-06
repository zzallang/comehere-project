package com.bitcamp.testproject.dao;

import com.bitcamp.testproject.vo.Health;
import com.bitcamp.testproject.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthDao {

  Health add(Health health);
}
