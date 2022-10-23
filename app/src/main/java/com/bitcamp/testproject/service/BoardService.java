package com.bitcamp.testproject.service;

import java.util.List;
import com.bitcamp.testproject.vo.Board;
import com.bitcamp.testproject.vo.BoardAttachedFile;

// 비즈니스 로직을 수행하는 객체의 사용규칙(호출규칙)
//
public interface BoardService {

  void add(Board board) throws Exception;

  boolean update(Board board) throws Exception;

  Board get(int no) throws Exception;

  boolean delete(int no) throws Exception;

  List<Board> list() throws Exception;

  BoardAttachedFile getBoardAttachedFile(int fileNo) throws Exception;

  boolean deleteBoardAttachedFile(int fileNo) throws Exception;

}








