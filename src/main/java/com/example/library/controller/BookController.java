package com.example.library.controller;

import com.example.library.dto.BookCreateRequest;
import com.example.library.dto.BookRowResponse;
import com.example.library.dto.BookUpdateRequest;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @GetMapping
  public List<BookRowResponse> list() {
    return service.listAllBooks();
  }

  @PostMapping
  public void create(@Valid @RequestBody BookCreateRequest req) {
    service.addBook(req);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable int id, @Valid @RequestBody BookUpdateRequest req) {
    service.updateBook(id, req);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    service.deleteBook(id);
  }
}
