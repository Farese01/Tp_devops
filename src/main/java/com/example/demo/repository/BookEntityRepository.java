package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity,Integer> {
    List <BookEntity> findAll();
    Optional <BookEntity> findById(Integer id);
    Optional <BookEntity> findByTitle(String title);
    List <BookEntity> findByAuthor(String author);

}
