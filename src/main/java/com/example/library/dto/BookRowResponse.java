package com.example.library.dto;

public class BookRowResponse {
  private int id;
  private String title;
  private double price;
  private String category;
  private String bookType;

  public BookRowResponse(int id, String title, double price, String category, String bookType) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.category = category;
    this.bookType = bookType;
  }

  public int getId() { return id; }
  public String getTitle() { return title; }
  public double getPrice() { return price; }
  public String getCategory() { return category; }
  public String getBookType() { return bookType; }
}
