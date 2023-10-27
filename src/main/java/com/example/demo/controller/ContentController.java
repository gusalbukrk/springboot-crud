package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Content;
import com.example.demo.repository.ContentJdbcTemplateRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
  private final ContentJdbcTemplateRepository repository;

  public ContentController(ContentJdbcTemplateRepository repository) {
    this.repository = repository;
  }

  @GetMapping("")
  public List<Content> findAll() {
    return repository.getAllContent();
  }

  @GetMapping("/{id}")
  public Content findById(@PathVariable Integer id) {
    return repository.getContent(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@RequestBody Content content) {
    repository.createContent(content);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  public void update(@Valid @RequestBody Content content, @PathVariable Integer id) {
    repository.updateContent(content);
  }
  
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    repository.deleteContent(id);
  }
}
