package com.demo.onlinelibrary.request;

import com.demo.onlinelibrary.model.BookReadStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequest {
    @NotBlank
    private String name;
    private String releaseYear;
    private String publisher;
    private String author;
    private int totalPageNumber;
    private int pageRead;
    private BookReadStatus bookReadStatus;
    @Email
    private String userMail;
    @NotBlank
    private String categoryName;
}
