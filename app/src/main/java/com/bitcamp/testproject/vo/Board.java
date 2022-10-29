package com.bitcamp.testproject.vo;

import java.sql.Date;
import java.util.List;

public class Board {

  private int no;
  private int cateNo;
  private Member writer;
  private String title;
  private boolean active;
  private String content;
  private Date createdDate;
  private int viewCount;

  // 첨부파일 정보를 저장할 필드
  private List<BoardAttachedFile> boardAttachedFiles;

  // 댓글을 저장할 필드
  private List<BoardComment> boardComment;

public List<Board> getAttachedFiles() {
    // TODO Auto-generated method stub
    return null;
}

}







