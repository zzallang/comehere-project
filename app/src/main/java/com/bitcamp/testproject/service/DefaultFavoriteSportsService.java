package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.FavoriteSportsDao;
import com.bitcamp.testproject.vo.FavoriteSports;
import com.bitcamp.testproject.vo.Member;

@Service
public class DefaultFavoriteSportsService implements FavoriteSportsService {

  @Autowired 
  FavoriteSportsDao favoritesportsDao;

  @Override
  public List<FavoriteSports> getSportsNos(int memberNo) {
    return favoritesportsDao.findAllSportsNosByMemberNo(memberNo);
  }

  @Override
  public boolean updateSportsDomain(Member member) {
    return favoritesportsDao.updateSports(member);
  }

  @Override
  public boolean updateSportsDomain(int mno, int preSportsDomain, int sportsDomain) {
    return favoritesportsDao.updateSports(mno, preSportsDomain, sportsDomain);
  }

  @Override
  public boolean deletePreFavoriteSports(int memberNo) {
    return favoritesportsDao.deletePreFavoriteSports(memberNo);
  }

  @Override
  public void addFavoriteSports(Member member) {
    //    3) 관심운동 등록
    favoritesportsDao.insertSports(member);
  }
}








