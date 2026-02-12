package com.example.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {
  private static volatile DatabaseConnection instance;

  private String url;
  private String user;
  private String pass;

  private DatabaseConnection() {}

  public static DatabaseConnection getInstance() {
    if (instance == null) {
      synchronized (DatabaseConnection.class) {
        if (instance == null) instance = new DatabaseConnection();
      }
    }
    return instance;
  }

  public void configure(String url, String user, String pass) {
    this.url = url;
    this.user = user;
    this.pass = pass;
  }

  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, user, pass);
  }

  public static Connection getConnectionStatic() throws SQLException {
    DatabaseConnection inst = getInstance();
    if (inst.url == null) throw new SQLException("DatabaseConnection is not configured");
    return inst.getConnection();
  }
}
