package com.bitcamp.testproject.service;

import java.util.List;
import com.bitcamp.testproject.vo.Member;

// 비즈니스 로직을 수행하는 객체의 사용규칙(호출규칙)
//
public interface MemberService {

  void add(Member member) throws Exception;

  boolean update(Member member) throws Exception;

  Member get(int no) throws Exception;

  Member get(String id, String password) throws Exception;

  boolean delete(int no) throws Exception;

  List<Member> list() throws Exception;

  //  String checkId(Member member) throws Exception;
}








