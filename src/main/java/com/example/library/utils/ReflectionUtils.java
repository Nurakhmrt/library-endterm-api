package com.example.library.utils;

import java.lang.reflect.Field;

public final class ReflectionUtils {
  private ReflectionUtils() {}

  public static void inspect(Object obj) {
    if (obj == null) return;
    System.out.println("Inspecting: " + obj.getClass().getSimpleName());
    for (Field f : obj.getClass().getDeclaredFields()) {
      f.setAccessible(true);
      try {
        System.out.println("  " + f.getName() + " = " + f.get(obj));
      } catch (IllegalAccessException ignored) {}
    }
  }
}
