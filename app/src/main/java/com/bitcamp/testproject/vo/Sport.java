package com.bitcamp.testproject.vo;

public class Sport {

  private int no;
  private String name;
  @Override
  public String toString() {
    return "Sport [no=" + no + ", name=" + name + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }




}
