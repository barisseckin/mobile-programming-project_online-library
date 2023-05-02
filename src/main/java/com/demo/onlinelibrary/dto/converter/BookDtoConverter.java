package com.demo.onlinelibrary.dto.converter;

import com.demo.onlinelibrary.dto.BookDto;
import com.demo.onlinelibrary.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    private final UserDtoConverter userDtoConverter;

    public BookDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }

    public BookDto toDto(Book from) {
        return new BookDto(
                from.getPublicId(),
                from.getName(),
                from.getReleaseYear(),
                from.getPublisher(),
                from.getAuthor(),
                from.getTotalPageNumber(),
                from.getPageRead(),
                from.getBookReadStatus(),
                userDtoConverter.toDto(from.getUser()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}
