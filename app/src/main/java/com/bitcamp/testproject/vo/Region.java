package com.bitcamp.testproject.vo;

public class Region {

  private int no;
  public String sido;
  private String sigu;
  @Override
  public String toString() {
    return "Region [no=" + no + ", sido=" + sido + ", sigu=" + sigu + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getSido() {
    return sido;
  }
  public void setSido(String sido) {
    this.sido = sido;
  }
  public String getSigu() {
    return sigu;
  }
  public void setSigu(String sigu) {
    this.sigu = sigu;
  }



}
