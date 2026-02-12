package com.example.library.repository;

import com.example.library.model.Category;

import java.sql.SQLException;

public interface CategoryRepository {
  Category findById(int id) throws SQLException;
}
