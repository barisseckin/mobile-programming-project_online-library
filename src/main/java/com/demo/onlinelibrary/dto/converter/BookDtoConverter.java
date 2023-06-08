package com.demo.onlinelibrary.dto.converter;

import com.demo.onlinelibrary.dto.BookDto;
import com.demo.onlinelibrary.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    private final UserDtoConverter userDtoConverter;
    private final CategoryDtoConverter categoryDtoConverter;

    public BookDtoConverter(UserDtoConverter userDtoConverter,
                            CategoryDtoConverter categoryDtoConverter) {
        this.userDtoConverter = userDtoConverter;
        this.categoryDtoConverter = categoryDtoConverter;
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
                categoryDtoConverter.toDto(from.getCategory()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}
