package com.bitcamp.testproject.vo;

import java.sql.Date;

public class BoardJd {

  private int no;
  private int cateno;
  private int mno;
  private String title;
  private String content;
  private int viewCount;
  private Date createdDate;

  @Override
  public String toString() {
    return "BoardJd [no=" + no + ", cateno=" + cateno + ", mno=" + mno + ", title=" + title
        + ", content=" + content + ", viewCount=" + viewCount + ", createdDate=" + createdDate
        + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getCateno() {
    return cateno;
  }

  public void setCateno(int cateno) {
    this.cateno = cateno;
  }

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }



}







