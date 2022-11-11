package com.bitcamp.testproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.testproject.vo.FavoriteRegion;
import com.bitcamp.testproject.vo.Member;

@Mapper
public interface FavoriteRegionDao {

  void insertRegion(Member member);

  void insertSports(Member member);

  List<FavoriteRegion> findAllRegionNosByMemberNo(int memberNo);

  public boolean updateRegion(Member member);

  public boolean updateRegion(int mno, int preRegionDomain, int regionDomain);


  public boolean deletePreFavoriteRegion(int memberNo);

}

