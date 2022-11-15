package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.PartyCommentDao;
import com.bitcamp.testproject.vo.Comment;

@Service
public class DefaultPartyCommentService implements PartyCommentService {

  @Autowired 
  PartyCommentDao partyCommentDao;

  @Override
  public List<Comment> list(int partyNo) {
    return partyCommentDao.findAll(partyNo);
  }

}








