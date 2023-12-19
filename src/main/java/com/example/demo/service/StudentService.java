package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentEntity> findAll();
    Optional<StudentEntity> findbyLastName(String lastName);
    List<StudentEntity> findAgeOver(Integer age);
    StudentEntity createStudent(StudentEntity studentRequest);
    Optional<StudentEntity> change_email(String email1, String email2);
    List<StudentEntity> increment_age_by(Integer add_age);
    Optional<StudentEntity> change_book_list(String email, List<BookEntity> book_list);

}

