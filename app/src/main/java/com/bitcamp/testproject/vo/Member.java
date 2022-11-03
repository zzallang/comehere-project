package com.bitcamp.testproject.vo;

import java.sql.Date;

public class Member {

  private int no;
  private String name;
  private String id;
  private String email;
  private String password;
  private String nickname;
  private String tel;
  private Date birthday;
  private boolean sex;
  private String filepath;
  private Date createdDate;
  private boolean active;
  private boolean black;

  // 모임참여 명단에서 주최자 여부
  private boolean auth;

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", id=" + id + ", email=" + email + ", password="
        + password + ", nickname=" + nickname + ", tel=" + tel + ", birthday=" + birthday + ", sex="
        + sex + ", filepath=" + filepath + ", createdDate=" + createdDate + ", active=" + active
        + ", black=" + black + ", auth=" + auth + "]";
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public boolean isSex() {
    return sex;
  }

  public void setSex(boolean sex) {
    this.sex = sex;
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public boolean isBlack() {
    return black;
  }

  public void setBlack(boolean black) {
    this.black = black;
  }

  public boolean isAuth() {
    return auth;
  }

  public void setAuth(boolean auth) {
    this.auth = auth;
  }


}
