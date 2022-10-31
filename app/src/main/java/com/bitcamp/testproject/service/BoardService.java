package com.bitcamp.testproject.service;

import java.util.List;
import com.bitcamp.testproject.vo.Board;
import com.bitcamp.testproject.vo.BoardAttachedFile;

// 비즈니스 로직을 수행하는 객체의 사용규칙(호출규칙)
//
public interface BoardService {

  //  void add(Board board) throws Exception;
  //
  //  boolean update(Board board) throws Exception;
  //
  //  Board get(int no) throws Exception;
  //
  //  boolean delete(int no) throws Exception;
  //
  //  List<Board> list() throws Exception;
  //
  //  BoardAttachedFile getAttachedFile(int fileNo) throws Exception;
  //
  //  boolean deleteAttachedFile(int fileNo) throws Exception;

  //  제동 소스 

  void addBoard(Board board) throws Exception;

  Board getBoard(int no) throws Exception;

  List<Board> listBoard(int no) throws Exception;

  boolean deleteBoard(int no) throws Exception;

  boolean updateBoard(Board board) throws Exception;

  BoardAttachedFile getBoardAttachedFile(int no) throws Exception;

  boolean deleteBoardAttachedFile(int fileNo) throws Exception;

  ////////////
}








