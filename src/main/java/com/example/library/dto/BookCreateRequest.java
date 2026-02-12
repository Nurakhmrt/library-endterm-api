package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookCreateRequest {
  @NotBlank
  private String title;

  @NotNull
  private Double price;

  @NotNull
  private Integer categoryId;

  @NotBlank
  private String bookType;

  private Double fileSizeMb;
  private Integer pages;

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }
  public Integer getCategoryId() { return categoryId; }
  public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
  public String getBookType() { return bookType; }
  public void setBookType(String bookType) { this.bookType = bookType; }
  public Double getFileSizeMb() { return fileSizeMb; }
  public void setFileSizeMb(Double fileSizeMb) { this.fileSizeMb = fileSizeMb; }
  public Integer getPages() { return pages; }
  public void setPages(Integer pages) { this.pages = pages; }
}
