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
}
