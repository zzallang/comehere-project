package com.bitcamp.testproject.web.controller;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.testproject.service.ReviewService;

@Controller
@RequestMapping("/review/")
public class ReviewController {

  @Autowired
  ServletContext sc;

  @Autowired
  ReviewService reviewService;


}






