package com.example.library;

import com.example.library.dto.BookRowResponse;
import java.util.List;

public class BookCache {

    private static final BookCache instance = new BookCache();
    private List<BookRowResponse> cachedBooks;

    private BookCache() {}

    public static BookCache getInstance() {
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