package com.example.demo.service;

import com.example.demo.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookEntity> findAllBook();
    Optional<BookEntity> findbyTitle(String title);
    List<BookEntity> findbyAuthor(String author);
    BookEntity createBook(BookEntity bookRequest);


}
