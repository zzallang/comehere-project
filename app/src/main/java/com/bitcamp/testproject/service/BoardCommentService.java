package com.bitcamp.testproject.service;

import java.util.List;
import com.bitcamp.testproject.vo.Comment;

public interface BoardCommentService {

  List<Comment> list(int boardNo);

  int insert(Comment comment);

  List<Comment> getComments(int no);

  Comment getRecentComment(int boardNo);

  int delete(int boardNo);


}
