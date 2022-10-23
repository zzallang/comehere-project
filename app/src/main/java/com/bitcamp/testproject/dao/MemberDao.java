package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.bitcamp.testproject.vo.Member;

@Mapper
public interface MemberDao {

  int insert(Member member);

  Member findByNo(int no);

  int update(Member member);

  int delete(int no);

  List<Member> findAll();

  Member findByEmailPassword(
      @Param("email") String email, 
      @Param("password") String password);

}
