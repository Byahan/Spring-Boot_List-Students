package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    Optional<StudentEntity> findByNim(String nim);

    void deleteByNim(String nim);

    @Query("SELECT MAX(s.nim) FROM StudentEntity s")
    String findMaxNim();
}