package com.example.library.repository.jdbc;

import com.example.library.dto.BookRowResponse;
import com.example.library.model.BookBase;
import com.example.library.repository.BookRepository;
import com.example.library.utils.DatabaseConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcBookRepository implements BookRepository {

  public JdbcBookRepository(@Value("${spring.datasource.url}") String url,
                            @Value("${spring.datasource.username}") String user,
                            @Value("${spring.datasource.password}") String pass) {
    DatabaseConnection.getInstance().configure(url, user, pass);
  }

  @Override
  public void create(BookBase book, double price) throws SQLException {
    String sql = "INSERT INTO books (title, price, category_id, book_type) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnectionStatic();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, book.getTitle());
      stmt.setDouble(2, price);
      stmt.setInt(3, book.getCategory().getId());
      stmt.setString(4, book.getBookType());
      stmt.executeUpdate();
    }
  }

  @Override
  public void update(int id, String title, double price) throws SQLException {
    String sql = "UPDATE books SET title = ?, price = ? WHERE id = ?";
    try (Connection conn = DatabaseConnection.getConnectionStatic();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, title);
      stmt.setDouble(2, price);
      stmt.setInt(3, id);
      stmt.executeUpdate();
    }
  }

  @Override
  public void delete(int id) throws SQLException {
    String sql = "DELETE FROM books WHERE id = ?";
    try (Connection conn = DatabaseConnection.getConnectionStatic();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, id);
      stmt.executeUpdate();
    }
  }

  @Override
  public List<BookRowResponse> getAll() throws SQLException {
    String sql = "SELECT b.id, b.title, b.price, c.name as cat_name, b.book_type FROM books b JOIN categories c ON b.category_id = c.id ORDER BY b.id";
    List<BookRowResponse> out = new ArrayList<>();
    try (Connection conn = DatabaseConnection.getConnectionStatic();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        out.add(new BookRowResponse(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getDouble("price"),
            rs.getString("cat_name"),
            rs.getString("book_type")
        ));
      }
    }
    return out;
  }
}
