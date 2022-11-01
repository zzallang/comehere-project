package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.AttachedFile;
import com.bitcamp.testproject.vo.Board;

@Mapper
public interface BoardDao {

  //  제동 소스

  int insert(Board board);

  int insertFiles(Board board);

  Board findByNo(int no);

  List<Board> findAll(int no);

  int deleteFiles(int boardNo);

  int delete(int no);

  int update(Board board);

  AttachedFile findFileByNo(int no);

  int deleteFile(int fileNo);

  //

  //  int insert(Board board);
  //
  //  Board findByNo(int no);
  //
  //  int update(Board board);
  //
  //  int delete(int no);
  //
  //  int deleteByMember(int memberNo);
  //
  //  List<Board> findAll();
  //
  //  int insertFiles(Board board);
  //
  //  BoardAttachedFile findFileByNo(int fileNo);
  //
  //  List<BoardAttachedFile> findFilesByBoard(int boardNo);
  //
  //  int deleteFile(int fileNo);
  //
  //  int deleteFiles(int boardNo);
  //
  //  int deleteFilesByMemberBoards(int memberNo);


}














