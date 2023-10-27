package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// after project is built, properties will be store at `/target/classes/META-INF/spring-configuration-metadata.json`

@ConfigurationProperties(value = "cc")
public record ContentCalendarProperties (
  String welcomeMessage,
  String about
) {}
