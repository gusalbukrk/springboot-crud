package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Content;
import com.example.demo.model.Status;
import com.example.demo.model.Type;

@Repository
public class ContentJdbcTemplateRepository {
  private final JdbcTemplate jdbcTemplate;

  public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Content(
      rs.getInt("id"),
      rs.getString("title"),
      rs.getString("desc"),
      Status.valueOf(rs.getString("status")),
      Type.valueOf(rs.getString("content_type")),
      rs.getObject("date_created", LocalDateTime.class),
      rs.getObject("date_updated", LocalDateTime.class),
      rs.getString("url")
    );
  }

    public List<Content> getAllContent() {
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
        return contents;
    }

    public Content getContent(int id) {
      try {
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, ContentJdbcTemplateRepository::mapRow, new Object[]{id});
        return content;
      } catch (EmptyResultDataAccessException e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found...");
      }
    }

    public void createContent(Content content) {
        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, content.title(), content.desc(), content.status().toString(), content.contentType().toString(), content.url());
    }

    public void updateContent(Content content) {
        String sql = "UPDATE Content SET title=?, desc=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
        jdbcTemplate.update(sql, content.title(), content.desc(), content.status().toString(), content.contentType().toString(), content.url(), content.id());
    }

    public void deleteContent(int id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
