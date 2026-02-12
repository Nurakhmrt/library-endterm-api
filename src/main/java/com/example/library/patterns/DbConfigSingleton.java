package com.example.library.patterns;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbConfigSingleton {
  private final String url;
  private final String user;

  public DbConfigSingleton(@Value("${spring.datasource.url}") String url,
                           @Value("${spring.datasource.username}") String user) {
    this.url = url;
    this.user = user;
  }

  public String getUrl() { return url; }
  public String getUser() { return user; }
}
