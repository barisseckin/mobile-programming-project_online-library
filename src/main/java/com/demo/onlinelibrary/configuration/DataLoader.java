package com.demo.onlinelibrary.configuration;

import com.demo.onlinelibrary.model.Book;
import com.demo.onlinelibrary.model.BookReadStatus;
import com.demo.onlinelibrary.model.Category;
import com.demo.onlinelibrary.model.User;
import com.demo.onlinelibrary.repository.BookRepository;
import com.demo.onlinelibrary.repository.CategoryRepository;
import com.demo.onlinelibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("barisseckin");
        user.setMail("barisseckin0@gmail.com");
        user.setActive(true);
        user.setPassword("12345");
        userRepository.save(user);

        Category category = new Category();
        category.setName("Software");
        categoryRepository.save(category);

        Book book = new Book();
        book.setPageRead(0);
        book.setName("Java17");
        book.setTotalPageNumber(700);
        book.setBookReadStatus(BookReadStatus.ADDED);
        book.setUser(user);
        book.setCategory(category);
        book.setPublisher("Kodlab");
        book.setReleaseYear("2013");
        bookRepository.save(book);
    }
}
