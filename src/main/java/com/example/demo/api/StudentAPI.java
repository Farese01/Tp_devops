package com.example.demo.api;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentEntityRepository;
import com.example.demo.service.BookServiceImpl;
import com.example.demo.service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@AllArgsConstructor

public class StudentAPI {
    private StudentServiceImpl studentService;

    @GetMapping()
    public List<StudentEntity> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/lastname/{lastName}")
    public Optional<StudentEntity> getbyLastName(@PathVariable String lastName) {return studentService.findbyLastName(lastName);}

    @PostMapping(consumes = "application/json")
    public StudentEntity save(@RequestBody StudentEntity s) {return studentService.createStudent(s);}

    @GetMapping("/age/{age}")
    public List<StudentEntity> getAgeOver(@PathVariable Integer age) {return studentService.findAgeOver(age);}


    @PutMapping("/email/{email1}/email/{email2}")
    public Optional<Optional<StudentEntity>> change_email_by_email(@PathVariable String email1, @PathVariable String email2){
        return Optional.ofNullable(studentService.change_email(email1, email2));}

    @PutMapping("/increment_age/{add_age}")
    public List<StudentEntity> increment_age(@PathVariable Integer add_age){
        return studentService.increment_age_by(add_age);}

    @PutMapping("/{email}")
    public Optional<StudentEntity> updateBookList(@PathVariable String email, @RequestBody List<BookEntity> bookList){
        return studentService.change_book_list(email, bookList);
    };

}

