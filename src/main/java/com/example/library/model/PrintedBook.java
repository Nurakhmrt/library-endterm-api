package com.example.library.model;

public class PrintedBook extends BookBase {
  private int pages;

  public PrintedBook() {}

  public PrintedBook(int id, String title, Category category, int pages) {
    super(id, title, category);
    this.pages = pages;
  }

  public int getPages() { return pages; }
  public void setPages(int pages) { this.pages = pages; }

  @Override
  public String getBookType() { return "PRINTED"; }

  @Override
  public void displayInfo() {
    System.out.println("[Printed] " + title + " | Category: " + (category == null ? "-" : category.getName()) + " | Pages: " + pages);
  }

  @Override
  public void print() {
    System.out.println("Printing book: " + title + " ... (simulated)");
  }
}
