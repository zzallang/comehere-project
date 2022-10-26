package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Board;
import com.bitcamp.testproject.vo.BoardAttachedFile;
import com.bitcamp.testproject.vo.BoardCategory;
import com.bitcamp.testproject.vo.BoardJd;

@Mapper
public interface BoardDao {

  //  제동 소스

  int insertPost(BoardJd boardJd);

  BoardCategory findCateNo(String category);

  BoardJd postFindByNo(int no);

  //

  int insert(Board board);

  Board findByNo(int no);

  int update(Board board);

  int delete(int no);

  int deleteByMember(int memberNo);

  List<Board> findAll();

  int insertFiles(Board board);

  BoardAttachedFile findFileByNo(int fileNo);

  List<BoardAttachedFile> findFilesByBoard(int boardNo);

  int deleteFile(int fileNo);

  int deleteFiles(int boardNo);

  int deleteFilesByMemberBoards(int memberNo);


}














