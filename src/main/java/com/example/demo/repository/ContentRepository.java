package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Content;
import com.example.demo.model.Status;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {
  // query derivation = allows us to just name the method in a certain way and
  // Spring Data does the job to generate the proper query for it
  List<Content> findAllByTitleContains(String keyword);

  // using @Query instead of query derivation for more control
  @Query("""
    SELECT * FROM Content WHERE status = :status
  """)
  List<Content> listByStatus(@Param("status") Status status);
}
