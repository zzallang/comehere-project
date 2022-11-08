package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.BoardCommentDao;
import com.bitcamp.testproject.vo.Comment;

@Service
public class DefaultBoardCommentService implements BoardCommentService {

  @Autowired 
  BoardCommentDao boardCommentDao;

  @Override
  public List<Comment> list(int boardNo) {
    return boardCommentDao.findByBoardNo(boardNo);
  }

  @Override
  public int insert(Comment comment) {
    return boardCommentDao.insertComment(comment);
  }

  @Override
  public List<Comment> getComments(int boardNo) {
    return boardCommentDao.findByBoardNo(boardNo);
  }

  @Override
  public Comment getRecentComment(int boardNo) {
    return boardCommentDao.findRecentComment(boardNo);
  }
}








