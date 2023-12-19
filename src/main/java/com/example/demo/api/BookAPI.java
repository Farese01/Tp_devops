package com.example.demo.api;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.BookEntityRepository;
import com.example.demo.repository.StudentEntityRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.BookServiceImpl;
import com.example.demo.service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@AllArgsConstructor

public class BookAPI {

    private BookServiceImpl bookService;
    private StudentServiceImpl studentService;
    private BookEntityRepository bookEntityRepository;

    @GetMapping()
    public List<BookEntity> getAll() {
        return bookService.findAllBook();
    }

    @GetMapping("/title/{title}")
    public Optional<BookEntity> getbyTitle(@PathVariable String title) {return bookService.findbyTitle(title);}

    @GetMapping("/author/{author}")
    public List<BookEntity> getbyAuthor(@PathVariable String author) {return bookService.findbyAuthor(author);}

    @PostMapping(consumes = "application/json")
    public BookEntity save(@RequestBody BookEntity book_created) {return bookService.createBook(book_created);}



}
