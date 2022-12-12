package com.bitcamp.testproject.service;

import com.bitcamp.testproject.dao.HealthDao;
import com.bitcamp.testproject.vo.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {

        @Autowired
        HealthDao healthDao;

        public void insert(Health health) throws Exception{
                System.out.println("service:" +health);
                healthDao.insert(health);
        }
        public List<Health> findAll() throws Exception{
                System.out.println("findall 실행");
                return healthDao.findAll();
        }
        public Health findDetail(int no) throws Exception{ // 왜 리턴타입은 Health 이죠?
//                System.out.println("findDetail 실행");
                return healthDao.findDetail(no);
        }

        public int update(Health health) throws Exception{
//                System.out.println("서비스 update 실행" + health);
                return healthDao.update(health);
        }
        public  int delete(int no) throws Exception{
                System.out.println("서비스 delete 실행" + no);
                return healthDao.delete(no);
        }

}
