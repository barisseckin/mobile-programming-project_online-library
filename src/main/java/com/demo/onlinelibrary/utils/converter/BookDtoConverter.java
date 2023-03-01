package com.demo.onlinelibrary.utils.converter;

import com.demo.onlinelibrary.dto.BookDto;
import com.demo.onlinelibrary.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    private final UserDtoConverter userDtoConverter;
    private final ImageFileDtoConverter imageFileDtoConverter;

    public BookDtoConverter(UserDtoConverter userDtoConverter,
                            ImageFileDtoConverter imageFileDtoConverter) {
        this.userDtoConverter = userDtoConverter;
        this.imageFileDtoConverter = imageFileDtoConverter;
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
                imageFileDtoConverter.toDto(from.getImageFile()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}
