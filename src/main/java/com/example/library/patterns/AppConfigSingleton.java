package com.example.library.patterns;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfigSingleton {
  private final String name;

  public AppConfigSingleton(@Value("${app.name:Library Endterm API}") String name) {
    this.name = name;
  }

  public String getName() { return name; }
}
