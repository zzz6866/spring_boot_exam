package com.example.boot_mongodb.repository;

import com.example.boot_mongodb.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    Optional<Book> findById(String id);

}
