package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Member;
import com.bitcamp.testproject.vo.Party;

@Mapper
public interface PartyDao {

  // 모임 전체 조회 
  // - 운동 종류, 지역 분류, 모임일자(기간), 모임시간(기간)
  // - 검색어 기준 
  // - 한 페이지 만 프론트, 페이지 이동 시 
  List<Party> findAll();

  Party findByNo(int no);

  int insert(Party party);

  int update(Party party);

  int delete(int no);

  Member checkOwner(int partyNo);

  Double findStarByNo(int no);

  String findSpartNoByPartyNo(int partyNo);


}














