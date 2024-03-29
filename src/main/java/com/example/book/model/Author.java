package com.example.book.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "authors", cascade = {CascadeType.ALL})
    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if (books == null)
            books = new ArrayList<>();
        books.add(book);
    }

    @Override
    public String toString() {
        return "Author{id=" + this.getId() + ", name=" + this.getName() + "}";
    }
}
