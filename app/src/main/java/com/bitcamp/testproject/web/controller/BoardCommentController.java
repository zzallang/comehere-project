package com.bitcamp.testproject.web.controller;

import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public int insertAndReplay(String content, int boardNo, int memberNo) {

    // ajax가 보낸 데이터 댓글 vo에 넣기
    Comment comment = new Comment(content, boardNo, memberNo);

    return boardCommentService.insert(comment);
  }

  @GetMapping("list")
  @ResponseBody
  public Object list(int boardNo) {
    List<Comment> list = boardCommentService.list(boardNo);
    System.out.println(list);
    return list;
  }

  @PostMapping("delete/{no}")
  @ResponseBody
  public int delete(@PathVariable int no) {
    return boardCommentService.delete(no);
  }


  @PostMapping("update")
  @ResponseBody
  public int update(Comment comment) {

    int result = boardCommentService.update(comment);

    return result;
  }

}






