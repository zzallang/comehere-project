package com.bitcamp.testproject.vo;

public class FavoriteSports {

  private int sno;
  private int mno;


  public FavoriteSports(int sno) {
    this.sno = sno;
  }


  @Override
  public String toString() {
    return "FavoriteSports [sno=" + sno + ", mno=" + mno + "]";
  }


  public int getSno() {
    return sno;
  }


  public void setSno(int sno) {
    this.sno = sno;
  }


  public int getMno() {
    return mno;
  }


  public void setMno(int mno) {
    this.mno = mno;
  }


}
