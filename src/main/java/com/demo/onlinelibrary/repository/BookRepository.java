package com.demo.onlinelibrary.repository;

import com.demo.onlinelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
