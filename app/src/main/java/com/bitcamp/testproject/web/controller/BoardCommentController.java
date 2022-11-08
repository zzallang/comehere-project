package com.bitcamp.testproject.web.controller;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bitcamp.testproject.service.BoardCommentService;
import com.bitcamp.testproject.service.BoardService;
import com.bitcamp.testproject.vo.Comment;

@Controller
@RequestMapping("/boardComment/")
public class BoardCommentController {

  @Autowired
  ServletContext sc;

  @Autowired
  BoardService boardService;
  @Autowired
  BoardCommentService boardCommentService;


  @PostMapping("insertAndReplay")
  @ResponseBody
  public Object insertAndReplay(String content, int boardNo, int memberNo) {

    // ajax가 보낸 데이터 댓글 vo에 넣기
    Comment comment = new Comment(content, boardNo, memberNo);

    // 댓글 추가
    boardCommentService.insert(comment);

    // 업데이트된 댓글 가져오기
    //    List<Comment> list = boardCommentService.list(boardNo);
    comment = boardCommentService.getRecentComment(boardNo);



    return comment;
  }


}






