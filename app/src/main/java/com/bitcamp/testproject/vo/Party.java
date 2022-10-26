package com.bitcamp.testproject.vo;

import java.sql.Date;
import java.util.List;

public class Party {

  private int no;
  private int regionNo;
  private int sprotsNo;
  private String title;
  private boolean active;
  private String content;
  private Date createdDate;
  private int headCount;
  private Date partyTime;
  private Date partydate;

  private Member user;

  private Party party;

  // 모임 참여자 명단을 저장할 필드
  private List<PartyMember> partyMembers;

  // 댓글을 저장할 필드
  private List<PartyComment> partyComments;

  // 첨부파일 정보를 저장할 필드
  private List<PartyAttachedFile> partyAttachedFiles;

  // 첨부파일 정보를 저장할 필드
  private List<PartyReview> partyReviews;

  // 첨부파일 정보를 저장할 필드
  private List<PartyAttachedFile> partyReviewAttachedFiles;

  @Override
  public String toString() {
    return "Party [no=" + no + ", regionNo=" + regionNo + ", sprotsNo=" + sprotsNo + ", title="
        + title + ", active=" + active + ", content=" + content + ", createdDate=" + createdDate
        + ", headCount=" + headCount + ", partyTime=" + partyTime + ", partydate=" + partydate
        + ", user=" + user + ", party=" + party + ", partyMembers=" + partyMembers
        + ", partyComments=" + partyComments + ", partyAttachedFiles=" + partyAttachedFiles
        + ", partyReviews=" + partyReviews + ", partyReviewAttachedFiles="
        + partyReviewAttachedFiles + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getRegionNo() {
    return regionNo;
  }

  public void setRegionNo(int regionNo) {
    this.regionNo = regionNo;
  }

  public int getSprotsNo() {
    return sprotsNo;
  }

  public void setSprotsNo(int sprotsNo) {
    this.sprotsNo = sprotsNo;
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

  public int getHeadCount() {
    return headCount;
  }

  public void setHeadCount(int headCount) {
    this.headCount = headCount;
  }

  public Date getPartyTime() {
    return partyTime;
  }

  public void setPartyTime(Date partyTime) {
    this.partyTime = partyTime;
  }

  public Date getPartydate() {
    return partydate;
  }

  public void setPartydate(Date partydate) {
    this.partydate = partydate;
  }

  public Member getUser() {
    return user;
  }

  public void setUser(Member user) {
    this.user = user;
  }

  public Party getParty() {
    return party;
  }

  public void setParty(Party party) {
    this.party = party;
  }

  public List<PartyMember> getPartyMembers() {
    return partyMembers;
  }

  public void setPartyMembers(List<PartyMember> partyMembers) {
    this.partyMembers = partyMembers;
  }

  public List<PartyComment> getPartyComments() {
    return partyComments;
  }

  public void setPartyComments(List<PartyComment> partyComments) {
    this.partyComments = partyComments;
  }

  public List<PartyAttachedFile> getPartyAttachedFiles() {
    return partyAttachedFiles;
  }

  public void setPartyAttachedFiles(List<PartyAttachedFile> partyAttachedFiles) {
    this.partyAttachedFiles = partyAttachedFiles;
  }

  public List<PartyReview> getPartyReviews() {
    return partyReviews;
  }

  public void setPartyReviews(List<PartyReview> partyReviews) {
    this.partyReviews = partyReviews;
  }

  public List<PartyAttachedFile> getPartyReviewAttachedFiles() {
    return partyReviewAttachedFiles;
  }

  public void setPartyReviewAttachedFiles(List<PartyAttachedFile> partyReviewAttachedFiles) {
    this.partyReviewAttachedFiles = partyReviewAttachedFiles;
  }


}
