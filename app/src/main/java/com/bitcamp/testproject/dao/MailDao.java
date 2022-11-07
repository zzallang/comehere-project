package com.bitcamp.testproject.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailDao {
  private String address;
  private String title;
  private String content;

  public MailDao() {
  }
  // test

  @Override
  public String toString() {
    return "MailDao [address=" + address + ", title=" + title + ", content=" + content
        + ", getAddress()=" + getAddress() + ", getTitle()=" + getTitle() + ", getContent()="
        + getContent() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
        + ", toString()=" + super.toString() + "]";
  }


  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }




}