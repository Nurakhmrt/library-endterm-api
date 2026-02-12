package com.example.library.repository.jdbc;

import com.example.library.model.Category;
import com.example.library.repository.CategoryRepository;
import com.example.library.utils.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class JdbcCategoryRepository implements CategoryRepository {

  @Override
  public Category findById(int id) throws SQLException {
    String sql = "SELECT id, name FROM categories WHERE id = ?";
    try (Connection conn = DatabaseConnection.getConnectionStatic();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) return null;
        return new Category(rs.getInt("id"), rs.getString("name"));
      }
    }
  }
}
