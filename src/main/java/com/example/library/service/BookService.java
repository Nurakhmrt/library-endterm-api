package com.example.library.service;

import com.example.library.dto.BookCreateRequest;
import com.example.library.dto.BookRowResponse;
import com.example.library.dto.BookUpdateRequest;
import com.example.library.exception.InvalidInputException;
import com.example.library.exception.NotFoundException;
import com.example.library.model.BookBase;
import com.example.library.model.Category;
import com.example.library.patterns.BookFactory;
import com.example.library.patterns.LoggingServiceSingleton;
import com.example.library.repository.BookRepository;
import com.example.library.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {
  private final BookRepository repository;
  private final CategoryRepository categories;
  private final LoggingServiceSingleton log = LoggingServiceSingleton.getInstance();

  public BookService(BookRepository repository, CategoryRepository categories) {
    this.repository = repository;
    this.categories = categories;
  }

  public void addBook(BookCreateRequest req) {
    if (req.getPrice() == null || req.getPrice() <= 0) throw new InvalidInputException("Price must be positive");
    try {
      Category cat = categories.findById(req.getCategoryId());
      if (cat == null) throw new NotFoundException("Category not found: id=" + req.getCategoryId());

      BookBase book = BookFactory.create(req, cat);
      repository.create(book, req.getPrice());
      BookCache.getInstance().clear();
      log.info("Created book: " + req.getTitle() + " (" + req.getBookType() + ")");
    } catch (SQLException e) {
      throw new RuntimeException("DB Error: " + e.getMessage());
    }
  }

  public List<BookRowResponse> listAllBooks() {
    try {
      BookCache cache = BookCache.getInstance();
      if (cache.getBooks() != null) {
        return cache.getBooks();
      }
      List<BookRowResponse> books = repository.getAll();
      cache.setBooks(books);
      return books;
    } catch (SQLException e) {
      throw new RuntimeException("DB Error: " + e.getMessage());
    }
  }

  public void updateBook(int id, BookUpdateRequest req) {
    if (req.getPrice() == null || req.getPrice() <= 0) throw new InvalidInputException("Price must be positive");
    try {
      repository.update(id, req.getTitle(), req.getPrice());
      BookCache.getInstance().clear();
      log.info("Updated book id=" + id);
    } catch (SQLException e) {
      throw new RuntimeException("DB Error: " + e.getMessage());
    }
  }

  public void deleteBook(int id) {
    try {
      repository.delete(id);
      BookCache.getInstance().clear();
      log.warn("Deleted book id=" + id);
    } catch (SQLException e) {
      throw new RuntimeException("DB Error: " + e.getMessage());
    }
  }
}