package com.bitcamp.testproject.vo;

import java.util.Date;

public class BoardComment {

  private int no;
  private int boardNo;
  private Member writer;
  private String content;
  private boolean active;
  private Date createdDate;


  public BoardComment() {}

  public BoardComment(int boardNo) {
    this.boardNo = boardNo;
  }

  @Override
  public String toString() {
    return "BoardComment [no=" + no + ", boardNo=" + boardNo + ", writer=" + writer + ", content="
        + content + ", active=" + active + ", createdDate=" + createdDate + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

}
