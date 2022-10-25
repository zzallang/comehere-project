package com.bitcamp.testproject.vo;

import java.sql.Date;

public class Qna {

  private int no;
  private Member writer;
  private String title;
  private boolean active;
  private String content;
  private Date createdDate;
  private String answerContent;
  private Date answerCreatedDate;

  @Override
  public String toString() {
    return "Qna [no=" + no + ", writer=" + writer + ", title=" + title + ", active=" + active
        + ", content=" + content + ", createdDate=" + createdDate + ", answerContent="
        + answerContent + ", answerCreatedDate=" + answerCreatedDate + "]";
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
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

  public String getAnswerContent() {
    return answerContent;
  }

  public void setAnswerContent(String answerContent) {
    this.answerContent = answerContent;
  }

  public Date getAnswerCreatedDate() {
    return answerCreatedDate;
  }

  public void setAnswerCreatedDate(Date answerCreatedDate) {
    this.answerCreatedDate = answerCreatedDate;
  }


}







