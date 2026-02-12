package com.example.library.model;

public class EBook extends BookBase {
  private double fileSizeMb;

  public EBook() {}

  public EBook(int id, String title, Category category, double fileSizeMb) {
    super(id, title, category);
    this.fileSizeMb = fileSizeMb;
  }

  public double getFileSizeMb() { return fileSizeMb; }
  public void setFileSizeMb(double fileSizeMb) { this.fileSizeMb = fileSizeMb; }

  @Override
  public String getBookType() { return "EBOOK"; }

  @Override
  public void displayInfo() {
    System.out.println("[EBook] " + title + " | Category: " + (category == null ? "-" : category.getName()) + " | SizeMB: " + fileSizeMb);
  }

  @Override
  public void print() {
    System.out.println("EBook cannot be physically printed. (simulated)");
  }
}
