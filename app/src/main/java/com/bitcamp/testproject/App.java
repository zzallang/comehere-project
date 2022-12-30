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
    SpringApplication.run(App.class, args);
  }

  @GetMapping("/")
  public String welcome() {

    return "index";
  }

  @GetMapping("/admin")
  public String admin() {
    return "admin/form";
  }
}
