package com.bitcamp.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableTransactionManagement
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        System.out.println("Comehere 프로젝트");
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/")
    public String welcome() {

        return "index";
    }
}