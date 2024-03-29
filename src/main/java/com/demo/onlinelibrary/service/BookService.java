package com.demo.onlinelibrary.service;

import com.demo.onlinelibrary.dto.BookDto;
import com.demo.onlinelibrary.dto.converter.BookDtoConverter;
import com.demo.onlinelibrary.exception.GenericException;
import com.demo.onlinelibrary.model.Book;
import com.demo.onlinelibrary.model.Category;
import com.demo.onlinelibrary.model.User;
import com.demo.onlinelibrary.repository.BookRepository;
import com.demo.onlinelibrary.request.CreateBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;
    private final UserService userService;
    private final CategoryService categoryService;

    public BookDto save(CreateBookRequest request) {
        Book saved = new Book(
                request.getName(),
                request.getReleaseYear(),
                request.getPublisher(),
                request.getAuthor(),
                request.getTotalPageNumber(),
                request.getPageRead(),
                request.getBookReadStatus(),
                userService.getByMail(request.getUserMail()),
                categoryService.getByName(request.getCategoryName())
        );

        bookRepository.save(saved);
        return bookDtoConverter.toDto(saved);
    }

    public List<BookDto> getBookByUser(String mail) {
        User user = userService.getByMail(mail);
        return bookRepository.findBookByUser(user)
                .stream()
                .map(bookDtoConverter::toDto)
                .toList();
    }

    public void delete(String publicId) {
        Book fromDb = getByPublicId(publicId);
        bookRepository.deleteById(fromDb.getId());
    }

    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookDtoConverter::toDto)
                .toList();
    }

    public List<BookDto> getByCategory(String mail, String categoryName) {
        User user = userService.getByMail(mail);
        Category category = categoryService.getByName(categoryName);

        return bookRepository.findBookByUserAndCategory(user, category)
                .stream()
                .map(bookDtoConverter::toDto)
                .toList();
    }

    public void updatePageReadNumber(String publicId, int pageNumber) {
        Book fromDb = getByPublicId(publicId);
        fromDb.setPageRead(pageNumber);
        bookRepository.save(fromDb);
    }

    private Book getByPublicId(String publicId) {
        return bookRepository.findBookByPublicId(publicId)
                .orElseThrow(() -> new GenericException("book not found, publicId: " + publicId, HttpStatus.NOT_FOUND));
    }
}
