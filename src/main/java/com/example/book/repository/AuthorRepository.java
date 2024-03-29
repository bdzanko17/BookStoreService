package com.example.book.repository;

import com.example.book.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> getAuthorEntityById(Long idBook);
    Optional<Author> getAuthorEntityByName(String name);

}
