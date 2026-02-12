package com.example.library.patterns;

import com.example.library.dto.BookCreateRequest;
import com.example.library.model.*;

public final class BookFactory {
  private BookFactory() {}

  public static BookBase create(BookCreateRequest req, Category category) {
    String type = req.getBookType() == null ? "" : req.getBookType().trim().toUpperCase();
    BookBuilder builder = new BookBuilder()
        .id(0)
        .title(req.getTitle())
        .category(category);

    return switch (type) {
      case "EBOOK" -> builder.fileSizeMb(req.getFileSizeMb()).buildEBook();
      case "PRINTED" -> builder.pages(req.getPages()).buildPrintedBook();
      default -> throw new IllegalArgumentException("bookType must be EBOOK or PRINTED");
    };
  }
}
