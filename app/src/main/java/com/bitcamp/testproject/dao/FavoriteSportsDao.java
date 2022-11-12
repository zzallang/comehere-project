package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.FavoriteSports;
import com.bitcamp.testproject.vo.Member;

@Mapper
public interface FavoriteSportsDao {

  void insertSports(Member member);

  List<FavoriteSports> findAllSportsNosByMemberNo(int memberNo);

  public boolean updateSports(Member member);

  public boolean updateSports(int mno, int preSportsDomain, int sportsDomain);

  public boolean deletePreFavoriteSports(int memberNo);

}

