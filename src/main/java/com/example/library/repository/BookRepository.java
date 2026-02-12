package com.example.library.repository;

import com.example.library.dto.BookRowResponse;
import com.example.library.model.BookBase;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
  void create(BookBase book, double price) throws SQLException;
  void update(int id, String title, double price) throws SQLException;
  void delete(int id) throws SQLException;
  List<BookRowResponse> getAll() throws SQLException;
}
