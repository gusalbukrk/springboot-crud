package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record Content(
  Integer id,
  @NotEmpty
  @NotBlank
  String title,
  String desc,
  Status status,
  Type contentType,
  LocalDateTime dateCreated,
  LocalDateTime dateUpdated,
  String url
) {

};
