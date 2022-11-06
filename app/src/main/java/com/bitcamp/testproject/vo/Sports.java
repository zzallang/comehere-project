package com.bitcamp.testproject.vo;

import java.util.List;

public class Sports {

  private int no;
  private String name;
  private List<FavoriteSports> favoriteSports;

  @Override
  public String toString() {
    return "Sports [no=" + no + ", name=" + name + ", favoriteSports=" + favoriteSports + "]";
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




  public List<FavoriteSports> getFavoriteSports() {
    return favoriteSports;
  }


  public void setFavoriteSports(List<FavoriteSports> favoriteSports) {
    this.favoriteSports = favoriteSports;
  }



}

