package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

// @Table(value = "tbl_content") // custom table name
public record Content(
  @Id
  Integer id,

  @NotEmpty
  @NotBlank
  String title,

  @Column(value = "description") // custom column name
  String desc,
  Status status,
  Type contentType,
  LocalDateTime dateCreated,
  LocalDateTime dateUpdated,
  String url
) {

};
