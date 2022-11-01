package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.AttachedFile;
import com.bitcamp.testproject.vo.Board;

@Mapper
public interface BoardDao {

  //  제동 소스

  int insertBoard(Board board);

  int insertBoardFiles(Board board);

  Board findByBoardNo(int no);

  List<Board> findAllBoard(int no);

  int deleteBoardFiles(int boardNo);

  int deleteBoard(int no);

  int updateBoard(Board board);

  AttachedFile findBoardFileByNo(int no);

  int deleteBoardFile(int fileNo);

<<<<<<< Updated upstream
=======
  void deleteFilesByMemberBoards(int no);

>>>>>>> Stashed changes
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














