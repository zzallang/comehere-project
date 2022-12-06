package com.bitcamp.testproject.web.controller;


import com.bitcamp.testproject.service.HealthService;
import com.bitcamp.testproject.vo.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/health/")

public class HealthController {

    @Autowired
    HealthService healthService;

    @GetMapping("main")
    public String main() throws Exception{
     return "health/main";
    }

    @GetMapping("add2")
    public String add(Health health) throws  Exception{
        healthService.insert(health);
        return "health/main";
    }
}
