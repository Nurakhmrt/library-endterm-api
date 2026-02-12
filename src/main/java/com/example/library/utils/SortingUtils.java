package com.example.library.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class SortingUtils {
  private SortingUtils() {}

  public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {
    List<T> copy = new ArrayList<>(list);
    copy.sort(comparator);
    return copy;
  }
}
