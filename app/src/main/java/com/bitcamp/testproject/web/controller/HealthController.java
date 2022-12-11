package com.bitcamp.testproject.web.controller;


import com.bitcamp.testproject.service.HealthService;
import com.bitcamp.testproject.vo.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("insert")
    public String insert(Health health) throws  Exception{
        System.out.println("cont:" + health);
        healthService.insert(health);
        return "redirect:hlist";
    }
    @GetMapping("hlist")
    public String list(Model model) throws Exception{
        System.out.println("healthList 실행");
        healthService.findAll();
        System.out.println("list" + healthService.findAll());
        model.addAttribute("health", healthService.findAll());
        return "health/list";
    }

    @GetMapping("hdetail")
    public String detail(Model model) throws Exception{
        System.out.println("healthdetail 실행");
//        healthService.finddetail();
//        System.out.println("detail" + healthService.finddetail());
//        model.addAttribute("health", healthService.finddetail());
        return "health/detail";
    }
}
