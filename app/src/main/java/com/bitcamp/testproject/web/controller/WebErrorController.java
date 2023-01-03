package com.bitcamp.testproject.web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebErrorController implements ErrorController {

  private String VIEW_PATH = "/errors/";

  @RequestMapping(value = "/error")
  public String handleError(HttpServletRequest request) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if(status != null){
      int statusCode = Integer.valueOf(status.toString());

      if(statusCode == HttpStatus.NOT_FOUND.value()){
        return VIEW_PATH + "404";
      }
      if(statusCode == HttpStatus.FORBIDDEN.value()){
        return VIEW_PATH + "500";
      }
    }
    return "error";
  }

}