package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.ReviewDao;
import com.bitcamp.testproject.vo.Review;

@Service
public class DefaultReviewService implements ReviewService {

  @Autowired 
  ReviewDao reviewDao;

  @Override
  public List<Review> list(int partySportNo) {
    System.out.println(reviewDao.findAll(partySportNo));
    return reviewDao.findAll(partySportNo);
  }

}








