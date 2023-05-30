package com.demo.onlinelibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
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
    private BookReadStatus bookReadStatus;
    @ManyToOne
    private User user;

    public Book(String name, String releaseYear, String publisher, String author, int totalPageNumber,
                int pageRead, BookReadStatus bookReadStatus, User user) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.publisher = publisher;
        this.author = author;
        this.totalPageNumber = totalPageNumber;
        this.pageRead = pageRead;
        this.bookReadStatus = bookReadStatus;
        this.user = user;
    }
}
