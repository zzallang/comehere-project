package com.bitcamp.testproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.bitcamp.testproject.dao.MailDao;
import com.bitcamp.testproject.service.EmailService;

@Controller
public class MainController {

  private final EmailService emailService;

  public MainController(EmailService emailService) {
    this.emailService = emailService;
  }

  //  @GetMapping("/mail/send")
  //  public String main() {
  //    return "SendMail.html";
  //  }

  @PostMapping("/mail/send")
  public String sendMail(MailDao mailDao) {
    emailService.sendSimpleMessage(mailDao);
    System.out.println("메일 전송 완료");
    return "AfterMail.html";
  }
}