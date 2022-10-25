package com.bitcamp.testproject.vo;

public class LocationReviewAttachedFile {
  private int no;
  private String filepath;
  private int locationReviewNo;

  public LocationReviewAttachedFile() {}

  public LocationReviewAttachedFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public String toString() {
    return "LocationReviewAttachedFile [no=" + no + ", filepath=" + filepath + ", locationReviewNo="
        + locationReviewNo + "]";
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

  public int getLocationReviewNo() {
    return locationReviewNo;
  }

  public void setLocationReviewNo(int locationReviewNo) {
    this.locationReviewNo = locationReviewNo;
  }

}
