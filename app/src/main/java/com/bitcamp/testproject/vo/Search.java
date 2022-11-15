package com.bitcamp.testproject.vo;

import java.util.Arrays;

public class Search {

  private String keyword;
  private String type = "T";
  private String[] typeArr = {"T"};

  @Override
  public String toString() {
    return "Search [keyword=" + keyword + ", type=" + type + ", typeArr=" + Arrays.toString(typeArr)
    + "]";
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
    this.typeArr = type.split("");
  }

  public String[] getTypeArr() {
    return typeArr;
  }

  public void setTypeArr(String[] typeArr) {
    this.typeArr = typeArr;
  }



}
