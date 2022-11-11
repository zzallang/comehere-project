package com.bitcamp.testproject.vo;

import java.sql.Date;

public class Board {

  private int no;
  private int cateno;
  private Member writer;
  private String title;
  private boolean active;
  private String content;
  private Date createdDate;
  private int viewCount;
  private String path;
  @Override
  public String toString() {
    return "Board [no=" + no + ", cateno=" + cateno + ", writer=" + writer + ", title=" + title
        + ", active=" + active + ", content=" + content + ", createdDate=" + createdDate
        + ", viewCount=" + viewCount + ", path=" + path + "]";
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
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }



}







