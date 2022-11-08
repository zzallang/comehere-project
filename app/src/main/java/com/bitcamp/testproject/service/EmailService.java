package com.bitcamp.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.bitcamp.testproject.dao.MailDao;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmailService {
  @Autowired
  JavaMailSender emailSender;

  public void sendSimpleMessage(String email, int SecCode) {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom("hunsik0302@gmail.com");
    message.setTo(email);
    message.setSubject("인증번호 입니다.");
    message.setText(Integer.toString(SecCode));
    emailSender.send(message);
  }
  // test
  public void sendSimpleMessage(MailDao mailDao) {
    // TODO Auto-generated method stub

  }




}