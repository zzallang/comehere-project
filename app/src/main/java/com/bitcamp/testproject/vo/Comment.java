package com.bitcamp.testproject.vo;

import java.sql.Date;

public class Comment {

  private int no;
  private Member writer;
  private int objectNo;
  private String content;
  private Date createdDate;

  public Comment() {}

  public Comment(String content, int objectNo, int memberNo) {
    this.content = content;
    this.objectNo = objectNo;
    this.writer = new Member(memberNo);
  }


  @Override
  public String toString() {
    return "Comment [no=" + no + ", writer=" + writer + ", objectNo=" + objectNo + ", content="
        + content + ", createdDate=" + createdDate + "]";
  }


  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public int getObjectNo() {
    return objectNo;
  }
  public void setObjectNo(int objectNo) {
    this.objectNo = objectNo;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }




}
