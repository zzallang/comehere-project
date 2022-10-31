package com.bitcamp.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.testproject.dao.MemberDao;
import com.bitcamp.testproject.vo.Member;

@Service
public class JoinService {

  @Autowired
  private MemberDao memberMapper;

  public void signUpProcess(Member member) {
    memberMapper.insert(member);
  }

}
