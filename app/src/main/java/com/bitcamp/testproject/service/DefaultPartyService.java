package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bitcamp.testproject.dao.PartyDao;
import com.bitcamp.testproject.vo.Member;
import com.bitcamp.testproject.vo.Party;

@Service
public class DefaultPartyService implements PartyService {

  @Autowired 
  PartyDao partyDao;

  @Transactional
  @Override
  public void add(Party party) throws Exception {
    // 1) 게시글 등록
    if (partyDao.insert(party) == 0) {
      throw new Exception("게시글 등록 실패!");
    }

    // 2) 첨부파일 등록
  }

  @Transactional
  @Override
  public boolean update(Party party) throws Exception {
    // 1) 게시글 변경
    if (partyDao.update(party) == 0) {
      return false;
    }

    // 2) 첨부파일 추가

    return true;
  }

  @Transactional
  @Override
  public Party get(int no) throws Exception {
    Party party = partyDao.findByNo(no); // 첨부파일 데이터까지 조인하여 select를 한 번만 실행한다.
    party.setStar(partyDao.findStarByNo(no));
    return party;
  }

  @Transactional
  @Override
  public boolean delete(int no) throws Exception {
    // 1) 첨부파일 삭제

    // 2) 게시글 삭제
    return partyDao.delete(no) > 0;
  }

  @Override
  public List<Party> list() throws Exception {
    return partyDao.findAll();
  }

  @Override
  public Member checkOwner(int partyNo) {
    return partyDao.checkOwner(partyNo);
  }

}








