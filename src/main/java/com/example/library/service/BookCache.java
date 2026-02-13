package com.example.library.service;

import com.example.library.dto.BookRowResponse;
import java.util.List;

public class BookCache {

    private static BookCache instance;
    private List<BookRowResponse> cachedBooks;

    private BookCache() {}

    public static BookCache getInstance() {
        if (instance == null) {
            instance = new BookCache();
        }
        return instance;
    }

    public List<BookRowResponse> getBooks() {
        return cachedBooks;
    }

    public void setBooks(List<BookRowResponse> books) {
        this.cachedBooks = books;
    }

    public void clear() {
        cachedBooks = null;
    }
}