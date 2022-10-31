package com.bitcamp.testproject.vo;

import java.sql.Date;

public class Comment {

  private int no;
  private Member writer;
  private int partyNo;
  private String content;
  private Date createdDate;

  @Override
  public String toString() {
    return "Comment [no=" + no + ", writer=" + writer + ", partyNo=" + partyNo + ", content="
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
  public int getPartyNo() {
    return partyNo;
  }
  public void setPartyNo(int partyNo) {
    this.partyNo = partyNo;
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
