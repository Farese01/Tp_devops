package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

@Repository
public interface StudentEntityRepository extends JpaRepository<StudentEntity, UUID> {
    List <StudentEntity> findAll();
    Optional <StudentEntity> findById(UUID id);
    Optional <StudentEntity> findByEmail(String email);
    Optional <StudentEntity> findByLastName(String lastName);

}
