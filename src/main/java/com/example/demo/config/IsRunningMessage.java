package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// can also be used to populate database during initialization
@Component
public class IsRunningMessage implements CommandLineRunner {
  public void run(String ...args) throws Exception {
    System.out.println("application is running...");
  }
}
