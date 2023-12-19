package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class BookServiceImpl implements BookService{

    private final BookEntityRepository bookEntityRepository;

    @Override
    public List<BookEntity> findAllBook() {
        List<BookEntity> bookList = bookEntityRepository.findAll();
        return bookList;
    }
    @Override
    public Optional<BookEntity> findbyTitle(@PathVariable String title) {
        String correct_title = title.replaceAll("%20", " ");
        Optional<BookEntity> found_book = bookEntityRepository.findByTitle(correct_title);
        return found_book;
    }

    @Override
    public List<BookEntity> findbyAuthor(@PathVariable String author) {
        String correct_author = author.replaceAll("%20", " ");
        List<BookEntity> bookList = bookEntityRepository.findByAuthor(correct_author);
        return bookList;
    }

    @Override
    public BookEntity createBook(@RequestBody BookEntity createdBook) {
        return bookEntityRepository.save(createdBook);
    }

}
