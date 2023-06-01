package com.demo.onlinelibrary.controller;

import com.demo.onlinelibrary.dto.BookDto;
import com.demo.onlinelibrary.request.CreateBookRequest;
import com.demo.onlinelibrary.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody @Valid CreateBookRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam("publicId") String publicId) {
        bookService.delete(publicId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getBookByUser(@RequestParam("mail") String mail) {
        return ResponseEntity
                .ok(bookService.getBookByUser(mail));
    }

    @PutMapping("/update-page-number/{publicId}")
    public ResponseEntity<Void> updatePageReadNumber(
            @PathVariable("publicId") String publicId,
            @RequestParam("pageNumber") int pageNumber) {

        bookService.updatePageReadNumber(publicId, pageNumber);
        return ResponseEntity.noContent().build();
    }
}
