package com.bitcamp.testproject.service;

import java.util.List;
import com.bitcamp.testproject.vo.Comment;

public interface BoardCommentService {

  List<Comment> list(int boardNo);

  int insert(Comment comment);

  List<Comment> getComments(int no);

  Comment getComment(int commentNo);

  int delete(int boardNo);

  int update(Comment comment);


}
