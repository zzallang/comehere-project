package com.bitcamp.testproject.vo;

import java.sql.Date;

public class Plan {

  private int no;
  private Member user;
  private String title;
  private boolean active;
  private Date DDay;
  private double chl;
  @Override
  public String toString() {
    return "Plan [no=" + no + ", user=" + user + ", title=" + title + ", active=" + active
        + ", DDay=" + DDay + ", chl=" + chl + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public Member getUser() {
    return user;
  }
  public void setUser(Member user) {
    this.user = user;
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
  public Date getDDay() {
    return DDay;
  }
  public void setDDay(Date dDay) {
    DDay = dDay;
  }
  public double getChl() {
    return chl;
  }
  public void setChl(double chl) {
    this.chl = chl;
  }

}
