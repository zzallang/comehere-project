package com.bitcamp.testproject.vo;

public class PartyAttachedFile {
  private int no;
  private String filepath;
  private int partyNo;

  public PartyAttachedFile() {}

  public PartyAttachedFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public String toString() {
    return "PartyAttachedFile [no=" + no + ", filepath=" + filepath + ", partyNo=" + partyNo + "]";
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

  public int getPartyNo() {
    return partyNo;
  }

  public void setPartyNo(int partyNo) {
    this.partyNo = partyNo;
  }



}
