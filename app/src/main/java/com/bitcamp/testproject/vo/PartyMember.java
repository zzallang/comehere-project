package com.bitcamp.testproject.vo;

import java.util.List;

public class PartyMember {

  private Member user;
  private Party party;
  private int partyStatusNo;
  private boolean auth;

  // 후기 정보를 저장할 필드
  private List<PartyReview> partyReviews;

  // 후기 파일 정보를 저장할 필드
  private List<PartyReviewAttachedFile> partyReviewAttachedFiles;

  @Override
  public String toString() {
    return "PartyMember [user=" + user + ", party=" + party + ", partyStatusNo=" + partyStatusNo
        + ", auth=" + auth + ", partyReviews=" + partyReviews + ", partyReviewAttachedFiles="
        + partyReviewAttachedFiles + "]";
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

  public int getPartyStatusNo() {
    return partyStatusNo;
  }

  public void setPartyStatusNo(int partyStatusNo) {
    this.partyStatusNo = partyStatusNo;
  }

  public boolean isAuth() {
    return auth;
  }

  public void setAuth(boolean auth) {
    this.auth = auth;
  }

  public List<PartyReview> getPartyReviews() {
    return partyReviews;
  }

  public void setPartyReviews(List<PartyReview> partyReviews) {
    this.partyReviews = partyReviews;
  }

  public List<PartyReviewAttachedFile> getPartyReviewAttachedFiles() {
    return partyReviewAttachedFiles;
  }

  public void setPartyReviewAttachedFiles(List<PartyReviewAttachedFile> partyReviewAttachedFiles) {
    this.partyReviewAttachedFiles = partyReviewAttachedFiles;
  }

  // 생성자 어떻게?




}
