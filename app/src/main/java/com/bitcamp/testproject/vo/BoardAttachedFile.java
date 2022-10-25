package com.bitcamp.testproject.vo;

public class BoardAttachedFile {
  private int no;
  private String filepath;
  private int boardNo;

  public BoardAttachedFile() {}

  public BoardAttachedFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public String toString() {
    return "BoardAttachedFile [no=" + no + ", filepath=" + filepath + ", boardNo=" + boardNo + "]";
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

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }



}
