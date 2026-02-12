package com.example.library.model;

public abstract class BookBase implements PricedItem {
  protected int id;
  protected String title;
  protected Category category;

  protected BookBase() {}

  protected BookBase(int id, String title, Category category) {
    this.id = id;
    this.title = title;
    this.category = category;
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public Category getCategory() { return category; }
  public void setCategory(Category category) { this.category = category; }

  public abstract String getBookType();
  public abstract void displayInfo();
  public abstract void print();
}
