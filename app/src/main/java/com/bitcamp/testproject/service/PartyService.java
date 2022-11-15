package com.bitcamp.testproject.service;

import java.util.List;
import com.bitcamp.testproject.vo.AttachedFile;
import com.bitcamp.testproject.vo.Party;
import com.bitcamp.testproject.vo.PartyMember;

// 비즈니스 로직을 수행하는 객체의 사용규칙(호출규칙)
//
public interface PartyService {

  void add(Party party, PartyMember partyMember) throws Exception;

  void attend(Party party, PartyMember partyMember) throws Exception;

  boolean update(Party party) throws Exception;

  Party get(int no) throws Exception;

  boolean delete(int no) throws Exception;

  List<Party> list() throws Exception;

  int checkOwner(int partyNo) throws Exception;

  AttachedFile getAttachedFile(int fileNo) throws Exception;

  boolean deleteAttachedFile(int fileNo) throws Exception;

}








