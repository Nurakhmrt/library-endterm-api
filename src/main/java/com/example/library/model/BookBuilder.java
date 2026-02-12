package com.example.library.model;

public class BookBuilder {
  private int id;
  private String title;
  private Category category;
  private Double fileSizeMb;
  private Integer pages;

  public BookBuilder id(int id) { this.id = id; return this; }
  public BookBuilder title(String title) { this.title = title; return this; }
  public BookBuilder category(Category category) { this.category = category; return this; }
  public BookBuilder fileSizeMb(Double fileSizeMb) { this.fileSizeMb = fileSizeMb; return this; }
  public BookBuilder pages(Integer pages) { this.pages = pages; return this; }

  public EBook buildEBook() {
    return new EBook(id, title, category, fileSizeMb == null ? 0.0 : fileSizeMb);
  }

  public PrintedBook buildPrintedBook() {
    return new PrintedBook(id, title, category, pages == null ? 0 : pages);
  }
}
