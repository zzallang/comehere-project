package com.bitcamp.testproject.vo;

import java.sql.Date;
import java.util.List;

public class PartyReview {

  private int no;
  private Member writer;
  private Party party;
  private boolean active;
  private String title;
  private String content;
  private double star;
  private Date createdDate;

  // 첨부파일 정보를 저장할 필드
  private List<PartyReviewAttachedFile> partyReviewAttachedFiles;

  @Override
  public String toString() {
    return "PartyReview [no=" + no + ", writer=" + writer + ", party=" + party + ", active="
        + active + ", title=" + title + ", content=" + content + ", star=" + star + ", createdDate="
        + createdDate + ", partyReviewAttachedFiles=" + partyReviewAttachedFiles + "]";
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

  public Party getParty() {
    return party;
  }

  public void setParty(Party party) {
    this.party = party;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
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

  public double getStar() {
    return star;
  }

  public void setStar(double star) {
    this.star = star;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public List<PartyReviewAttachedFile> getPartyReviewAttachedFiles() {
    return partyReviewAttachedFiles;
  }

  public void setPartyReviewAttachedFiles(List<PartyReviewAttachedFile> partyReviewAttachedFiles) {
    this.partyReviewAttachedFiles = partyReviewAttachedFiles;
  }


}







