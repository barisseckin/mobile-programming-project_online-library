package com.demo.onlinelibrary.dto;

import com.demo.onlinelibrary.model.BookReadStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BookDto {

    private String publicId;
    private String name;
    private String releaseYear;
    private String publisher;
    private String author;
    private int totalPageNumber;
    private int pageRead;
    private BookReadStatus bookReadStatus;
    private UserDto user;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
