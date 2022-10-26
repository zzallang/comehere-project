package com.bitcamp.testproject.vo;

public class PartyReviewAttachedFile {
  private int no;
  private String filepath;
  private int partyReviewNo;

  public PartyReviewAttachedFile() {}

  public PartyReviewAttachedFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public String toString() {
    return "PartyReviewAttachedFile [no=" + no + ", filepath=" + filepath + ", partyReviewNo="
        + partyReviewNo + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  public int getPartyReviewNo() {
    return partyReviewNo;
  }

  public void setPartyReviewNo(int partyReviewNo) {
    this.partyReviewNo = partyReviewNo;
  }


}
