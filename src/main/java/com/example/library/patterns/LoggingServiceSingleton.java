package com.example.library.patterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggingServiceSingleton {
  private static volatile LoggingServiceSingleton instance;
  private final Logger log = LoggerFactory.getLogger("LibraryEndtermApi");

  private LoggingServiceSingleton() {}

  public static LoggingServiceSingleton getInstance() {
    if (instance == null) {
      synchronized (LoggingServiceSingleton.class) {
        if (instance == null) instance = new LoggingServiceSingleton();
      }
    }
    return instance;
  }

  public void info(String msg) { log.info(msg); }
  public void warn(String msg) { log.warn(msg); }
  public void error(String msg) { log.error(msg); }
  public void error(String msg, Throwable t) { log.error(msg, t); }
}
