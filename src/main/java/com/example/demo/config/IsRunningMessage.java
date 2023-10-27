package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!dev") // don't run when `spring.profiles.active` property is set to dev
// can also be used to populate database during initialization
@Component
public class IsRunningMessage implements CommandLineRunner {
  public void run(String ...args) throws Exception {
    System.out.println("application is running...");
  }
}
