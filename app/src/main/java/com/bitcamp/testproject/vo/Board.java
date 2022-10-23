package com.bitcamp.testproject.vo;

import java.util.Date;
import java.util.List;

public class Board {

  private int no;
  private int categoryNo;
  private Member writer;
  private String title;
  private boolean active;
  private String content;
  private Date createdDate;
  private int viewCount;

  private List<BoardAttachedFile> boardAttachedFiles;

  @Override
  public String toString() {
    return "Board [no=" + no + ", categoryNo=" + categoryNo + ", writer=" + writer + ", title="
        + title + ", active=" + active + ", content=" + content + ", createdDate=" + createdDate
        + ", viewCount=" + viewCount + ", boardAttacehdfiles=" + boardAttachedFiles + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getCategoryNo() {
    return categoryNo;
  }

  public void setCategoryNo(int categoryNo) {
    this.categoryNo = categoryNo;
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

  public List<BoardAttachedFile> getBoardAttachedFiles() {
    return boardAttachedFiles;
  }

  public void setBoardAttachedFiles(List<BoardAttachedFile> boardAttachedFiles) {
    this.boardAttachedFiles = boardAttachedFiles;
  }




}
