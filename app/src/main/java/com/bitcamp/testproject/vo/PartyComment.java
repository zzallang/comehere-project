package com.bitcamp.testproject.vo;

import java.util.Date;

public class PartyComment {

  private int no;
  private Member writer;
  private int partyNo;
  private String content;
  private boolean active;
  private Date createdDate;


  public PartyComment() {}

  public PartyComment(int partyNo) {
    this.partyNo = partyNo;
  }

  @Override
  public String toString() {
    return "PartyComment [no=" + no + ", writer=" + writer + ", partyNo=" + partyNo + ", content="
        + content + ", active=" + active + ", createdDate=" + createdDate + "]";
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
