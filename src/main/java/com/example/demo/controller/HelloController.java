package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaozeyu
 */
@RestController
public class HelloController {
  @RequestMapping("/index")
  public String hello(){
    return "hello";
  }
}
