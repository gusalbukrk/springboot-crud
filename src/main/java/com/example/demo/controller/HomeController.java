package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  // get value from config
  @Value("${cc.welcomeMessage: Default welcome message}")
  private String welcomeMessage;

  @Value("${cc.about}")
  private String about;

  @GetMapping("/")
  //
  // public String home() {
  //   return welcomeMessage;
  // }
  //
  // return JSON instead of string
  public Map<String,String> home() {
    return Map.of("msg", welcomeMessage, "about", about);
  }
}
