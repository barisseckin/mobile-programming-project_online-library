package com.demo.onlinelibrary.request;

import com.demo.onlinelibrary.model.BookReadStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequest {
    private String name;
    private String releaseYear;
    private String publisher;
    private String author;
    private int totalPageNumber;
    private int pageRead;
    private BookReadStatus bookReadStatus;
    private String userMail;
}
