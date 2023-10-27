package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

// @Table(value = "tbl_content") // custom table name
public record Content(
  @Id
  Integer id,

  @NotEmpty
  @NotBlank
  String title,

  // @Column('content_title') // custom column name
  String desc,
  Status status,
  Type contentType,
  LocalDateTime dateCreated,
  LocalDateTime dateUpdated,
  String url
) {

};
