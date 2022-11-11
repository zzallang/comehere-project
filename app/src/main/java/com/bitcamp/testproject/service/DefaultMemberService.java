package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bitcamp.testproject.dao.BoardDao;
import com.bitcamp.testproject.dao.FavoriteRegionDao;
import com.bitcamp.testproject.dao.MemberDao;
import com.bitcamp.testproject.vo.Member;

@Service 
public class DefaultMemberService implements MemberService {

  @Autowired
  MemberDao memberDao;

  @Autowired
  BoardDao boardDao;

  @Autowired
  FavoriteRegionDao favoriteRegionDao;

  @Transactional
  @Override
  public void add(Member member) throws Exception {
    // 1) 회원등록
    memberDao.insert(member);
    //
    //    // 2) 관심지역 등록
    //    favoriteRegionDao.insertRegion(member);
    //
    //    // 3) 관심운동 등록
    //    favoriteRegionDao.insertSports(member);
  }

  @Override
  public boolean update(Member member) throws Exception {
    return memberDao.update(member) > 0;
  }

  @Override
  public boolean updatePassWord(Member member) throws Exception {
    return memberDao.update(member) > 0;
  }

  @Override
  public Member get(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  @Override
  public Member get(String id, String password) throws Exception {
    return memberDao.findByIdPassword(id, password);
  }


  @Override
  public Member getByPassword(String id, String email, String SecCode) throws Exception {
    return memberDao.findByPassword(id, email, SecCode);
  }

  @Override
  public Member getId(String name, String email) throws Exception {
    return memberDao.findById(name, email);
  }


  @Transactional
  @Override
  public boolean delete(int no) throws Exception {
    //    boardDao.deleteFilesByMemberBoards(no); // 회원이 작성한 게시글의 모든 첨부파일 삭제
    //    boardDao.deleteByMember(no); // 회원이 작성한 게시글 삭제
    return memberDao.delete(no) > 0; // 회원 삭제
  }

  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }

  //  @Override
  //  public String checkId(Member member) throws Exception {
  //    List<Member> memberList = memberDao.findAll();
  //    for(Member eachMember : memberList) {
  //      if(eachMember.getId().equals(member.getId())) return "fail";
  //    }
  //    return "succ";
  //  }


}








