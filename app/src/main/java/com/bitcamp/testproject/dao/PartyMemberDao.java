package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Member;
import com.bitcamp.testproject.vo.PartyMember;

@Mapper
public interface PartyMemberDao {

  // 모임 전체 조회 
  // - 운동 종류, 지역 분류, 모임일자(기간), 모임시간(기간)
  // - 검색어 기준 
  // - 한 페이지 만 프론트, 페이지 이동 시 
  List<PartyMember> findAll();

  PartyMember findByNo(int no);

  // 모임 개설 시 주최자 입력
  int insertUser(PartyMember partyMember);

  // 모임 참가 시 멤버 신청상태 입력
  int insertMember(PartyMember partyMember);

  // 모임 승인 거절
  int update(PartyMember partyMember);

  int delete(int no);

  Member checkOwner(int partyNo);

}














