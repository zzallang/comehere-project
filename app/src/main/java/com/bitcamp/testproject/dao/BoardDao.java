package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.AttachedFile;
import com.bitcamp.testproject.vo.Board;

@Mapper
public interface BoardDao {

  int insert(Board board);

  Board findByNo(int no);

  int update(Board board);

  int delete(int no);

  int deleteByMember(int memberNo);

  List<Board> findAll();

  int insertFiles(Board board);

  AttachedFile findFileByNo(int fileNo);

  List<AttachedFile> findFilesByBoard(int boardNo);

  int deleteFile(int fileNo);

  int deleteFiles(int boardNo);

  int deleteFilesByMemberBoards(int memberNo);
}














