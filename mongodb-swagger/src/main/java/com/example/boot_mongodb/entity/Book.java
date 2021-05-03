package com.example.boot_mongodb.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {

    @Id
    private String id; // type을 ObjectId로 하면 에러남... String으로....

    private String title;

    private String author;

    private Integer pages;

    public Book() {
    }

    @Builder
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
}
