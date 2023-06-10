package com.demo.onlinelibrary.repository;

import com.demo.onlinelibrary.model.Book;
import com.demo.onlinelibrary.model.Category;
import com.demo.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByPublicId(String publicId);
    List<Book> findBookByUser(User user);
    List<Book> findBookByUserAndCategory(User user, Category category);
}
