package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.PartyDao;
import com.bitcamp.testproject.dao.ReviewDao;
import com.bitcamp.testproject.vo.Review;

@Service
public class DefaultReviewService implements ReviewService {

  @Autowired 
  ReviewDao reviewDao;
  @Autowired 
  PartyDao partyDao;

  @Override
  public List<Review> list(int userNo, int sportNo) {
    System.out.println(reviewDao.findAll(userNo, sportNo));
    return reviewDao.findAll(userNo, sportNo);
  }

  @Override
  public Review get(int reviewNo) {
    return reviewDao.findByNo(reviewNo);
  }

}








