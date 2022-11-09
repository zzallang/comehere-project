package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.bitcamp.testproject.vo.AttachedFile;
import com.bitcamp.testproject.vo.Criteria;
import com.bitcamp.testproject.vo.Party;

@Mapper
public interface PartyDao {

  // 모임 전체 조회 
  // - 운동 종류, 지역 분류, 모임일자(기간), 모임시간(기간)
  // - 검색어 기준 
  // - 한 페이지 만 프론트, 페이지 이동 시 
  List<Party> findAll(Criteria cri);

  int findAllCount();

  List<Party> findAll2(
      @Param("gu") String gu, 
      @Param("sports") String sports,
      @Param("partyTime") String partyTime,
      @Param("partyDate") String partyDate,
      @Param("searchText") String searchText,
      @Param("listStar")String listStar,
      @Param("listCreate")String listCreate,
      @Param("listPartyDate")String listPartyDate
      );

  Party findByNo(int no);

  int insert(Party party);

  // 리스트 대표 사진 업로드 
  int insertFiles(Party party);

  int update(Party party);

  int delete(int no);

  // 리스트 대표사진 삭제
  int deleteFiles(int partyNo);

  int deleteFile(int fileNo);

  AttachedFile findFileByNo(int fileNo);

  int checkOwner(int partyNo);

  Double findStarByNo(int no);

}














