package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Board;
import com.bitcamp.testproject.vo.BoardAttachedFile;

@Mapper
public interface BoardDao {

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

