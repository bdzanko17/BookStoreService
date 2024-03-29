package com.example.book.model.EntityInput;

import com.example.book.model.Book;

public class PageEntityInput {
    private Long ordinalNumber;
    private String content;
    private Book book;

    public PageEntityInput(Long ordinalNumber, String content, Book book) {
        this.ordinalNumber = ordinalNumber;
        this.content = content;
        this.book = book;
    }

    public PageEntityInput() {
    }

    public Long getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Long ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
