package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Review;

@Mapper
public interface ReviewDao {

  List<Review> findAll(int partySportNo);

}














