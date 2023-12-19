package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class StudentServiceImpl implements StudentService{
    private final StudentEntityRepository studentEntityRepository;

    public StudentEntity update(StudentEntity s, String email){
        Optional<StudentEntity> studentOptional;
        return null;
    }

    @Override
    public List<StudentEntity> findAll(){
        /*
        StudentEntityRepository.findAll().var + enter
         */
        List<StudentEntity> entities = studentEntityRepository.findAll();
        return entities;
    }

    @Override
    public Optional<StudentEntity> findbyLastName(@PathVariable String lastName){
        Optional<StudentEntity> entities = studentEntityRepository.findByLastName(lastName);
        return entities;
    }

    @Override
    public List<StudentEntity> findAgeOver(@PathVariable Integer age){
        List<StudentEntity> entities = new ArrayList<>();
        List<StudentEntity> students = studentEntityRepository.findAll();
        for (StudentEntity student : students) {
            if (student.getAge() < age){
                entities.add(student);
            }
        }
        return entities;
    }
    @Override
    public StudentEntity createStudent(@RequestBody StudentEntity s) {
        return studentEntityRepository.save(s);
    }


    public Optional<StudentEntity> change_email(@PathVariable String email1, @PathVariable String email2){
        Optional<StudentEntity> entity = studentEntityRepository.findByEmail(email1);
        StudentEntity updated_student = entity.get();
        updated_student.setEmail(email2);
        studentEntityRepository.save(updated_student) ;
        return entity;
    }

    public List<StudentEntity> increment_age_by(@PathVariable Integer add_age) {
        List<StudentEntity> entity = studentEntityRepository.findAll();
        for (StudentEntity student : entity) {
            student.setAge(student.getAge() + add_age);
            studentEntityRepository.save(student);
        }
        return entity;
    }

    @Override
    public Optional<StudentEntity> change_book_list(@RequestBody String email, @RequestBody List<BookEntity> book_list) {
        Optional <StudentEntity> entity = studentEntityRepository.findByEmail(email);
        StudentEntity student = entity.get();
        student.setBooks(book_list);
        studentEntityRepository.save(student) ;
        return entity;
    }

}
