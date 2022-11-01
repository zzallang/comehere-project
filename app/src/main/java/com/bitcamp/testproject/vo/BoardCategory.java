package com.bitcamp.testproject.vo;

public class BoardCategory {

  private int cateno;
  private String category;

  @Override
  public String toString() {
    return "BoardCategory [cateno=" + cateno + ", category=" + category + "]";
  }

  public int getCateno() {
    return cateno;
  }

  public void setCateno(int cateno) {
    this.cateno = cateno;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


}

