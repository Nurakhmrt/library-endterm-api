package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookUpdateRequest {
  @NotBlank
  private String title;

  @NotNull
  private Double price;

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }
}
