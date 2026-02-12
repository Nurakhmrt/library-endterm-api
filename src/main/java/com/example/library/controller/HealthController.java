package com.example.library.controller;

import com.example.library.patterns.AppConfigSingleton;
import com.example.library.patterns.DbConfigSingleton;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {
  private final AppConfigSingleton app;
  private final DbConfigSingleton db;

  public HealthController(AppConfigSingleton app, DbConfigSingleton db) {
    this.app = app;
    this.db = db;
  }

  @GetMapping("/api/health")
  public Map<String, Object> health() {
    return Map.of("status","OK","app",app.getName(),"dbUrl",db.getUrl(),"dbUser",db.getUser());
  }
}
