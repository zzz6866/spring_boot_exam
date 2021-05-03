package com.example.boot_mongodb.service;


import com.example.boot_mongodb.entity.Book;
import com.example.boot_mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }

    public Page<Book> findBookList(PageRequest pageable) {
        return bookRepository.findAll(pageable);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
