package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.Comment;

@Mapper
public interface PartyCommentDao {

  List<Comment> findAll(int partyNo);

}














