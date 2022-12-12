package com.bitcamp.testproject.web.controller;


import com.bitcamp.testproject.service.HealthService;
import com.bitcamp.testproject.vo.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/health/")

public class HealthController {

    @Autowired
    HealthService healthService;

    @GetMapping("main")
    public String main() throws Exception{
     return "redirect:hlist";
    }

    @GetMapping("form")
    public String form() throws Exception{
        return "health/main";
    }


    @GetMapping("insert")
    public String insert(Health health) throws  Exception{
//        System.out.println("cont:" + health);
        healthService.insert(health);
        return "redirect:hlist";
    }
    @GetMapping("hlist")
    public String list(Model model) throws Exception{
//        System.out.println("healthList 실행");
        healthService.findAll();
//        System.out.println("list" + healthService.findAll());
        model.addAttribute("health", healthService.findAll());
        return "health/list";
    }

    @GetMapping("detail")
    public ModelAndView detail(int no) throws Exception{
        System.out.println("healthdetail 실행");


//        healthService.findDetail(); 필요가 없다. 왜? 밑에서 모델 엔뷰에서 mv 객체에 정보를 담아야 되는 과정에

        ModelAndView mv = new ModelAndView("health/detail");
        System.out.println(mv);

        mv.addObject("health", healthService.findDetail(no));
        // mv.addObject 이게 실행되면서 그안에 키와 벨류값에 데이터 실행순서??? 궁금하다.

       System.out.println("detail" + healthService.findDetail(no));
//        model.addAttribute("health", healthService.finddetail());
        return mv;
    }

    @PostMapping("updateh")
    public String update(Health health) throws Exception{
//        System.out.println("update 실행"+health);
        healthService.update(health);
       return "redirect:hlist";
    }

    @GetMapping("deleteh")
    public String delete(int no) throws Exception{
        System.out.println("delete 실행");
        healthService.delete(no);
        return "redirect:hlist";
    }

}
