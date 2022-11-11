package com.bitcamp.testproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.FavoriteRegionDao;
import com.bitcamp.testproject.vo.FavoriteRegion;
import com.bitcamp.testproject.vo.Member;

@Service
public class DefaultFavoriteRegionService implements FavoriteRegionService {

  @Autowired 
  FavoriteRegionDao favoriteregionDao;

  @Override
  public List<FavoriteRegion> getRegionNos(int memberNo) {
    return favoriteregionDao.findAllRegionNosByMemberNo(memberNo);
  }

  @Override
  public boolean updateRegionDomain(Member member) {
    return favoriteregionDao.updateRegion(member);
  }

  @Override
  public boolean updateRegionDomain(int mno, int preRegionDomain, int regionDomain) {
    return favoriteregionDao.updateRegion(mno, preRegionDomain, regionDomain);
  }

  @Override
  public boolean deletePreFavoriteRegion(int memberNo) {
    return favoriteregionDao.deletePreFavoriteRegion(memberNo);
  }

  @Override
  public void addFavoriteRegion(Member member) {
    // 2) 관심지역 등록
    favoriteregionDao.insertRegion(member);

    // 3) 관심운동 등록
    //    favoriteregionDao.insertSports(member);
  }
}








