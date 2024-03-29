package com.demo.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publicId = UUID.randomUUID().toString();
    private String name;
    private String releaseYear;
    private String publisher;
    private String author;
    private int totalPageNumber;
    private int pageRead;
    @Enumerated(EnumType.STRING)
    private BookReadStatus bookReadStatus;
    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    public Book(String name, String releaseYear, String publisher, String author, int totalPageNumber,
                int pageRead, BookReadStatus bookReadStatus, User user, Category category) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.publisher = publisher;
        this.author = author;
        this.totalPageNumber = totalPageNumber;
        this.pageRead = pageRead;
        this.bookReadStatus = bookReadStatus;
        this.user = user;
        this.category = category;
    }
}
