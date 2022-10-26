package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Party;
import com.bitcamp.testproject.vo.PartyAttachedFile;

@Mapper
public interface PartyDao {

  // 모임 전체 조회 
  // - 운동 종류, 지역 분류, 모임일자(기간), 모임시간(기간)
  // - 검색어 기준 
  // - 한 페이지 만 프론트, 페이지 이동 시 
  List<Party> findAll();






  int insert(Party party);

  Party findByNo(int no);

  int update(Party party);

  int delete(int no);

  int deleteByParty(int partyNo);

  int insertFiles(Party party);

  PartyAttachedFile findFileByNo(int fileNo);

  List<PartyAttachedFile> findFilesByBoard(int boardNo);

  int deleteFile(int fileNo);

  int deleteFiles(int boardNo);

  int deleteFilesByMemberBoards(int memberNo);
}














