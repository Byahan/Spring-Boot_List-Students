package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.Domain.Student;
import com.example.demo.Domain.StudentRequest;
import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private static final int LENGTH = 5;

    public List<Student> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Student addStudent(StudentRequest request) {
        StudentEntity entity = new StudentEntity();
        entity.setNim(generateNIM());
        entity.setFullName(request.getFullName());
        entity.setDob(request.getDob());
        entity.setAddress(request.getAddress());

        return mapToDto(studentRepository.save(entity));
    }

    private String generateNIM() {
        String maxNim = studentRepository.findMaxNim();
        return (maxNim == null)
                ? String.format("%0" + LENGTH + "d", 1)
                : String.format("%0" + LENGTH + "d", Integer.parseInt(maxNim) + 1);
    }

    public Student findByNim(String nim) {
        StudentEntity entity = studentRepository.findByNim(nim)
                .orElseThrow(() -> new RuntimeException("NIM not found"));
        return mapToDto(entity);
    }

   public void deleteByNim(String nim) {
        StudentEntity entity = studentRepository.findByNim(nim)
            .orElseThrow(() -> new RuntimeException("NIM not found"));

        studentRepository.delete(entity);
    }

    public Student updateByNim(String nim, StudentRequest request) {
        StudentEntity entity = studentRepository.findByNim(nim)
                .orElseThrow(() -> new RuntimeException("NIM not found"));

        entity.setFullName(request.getFullName());
        entity.setAddress(request.getAddress());
        entity.setDob(request.getDob());

        return mapToDto(studentRepository.save(entity));
    }

    private Student mapToDto(StudentEntity entity) {
        Student student = new Student();
        student.setNim(entity.getNim());
        student.setFullName(entity.getFullName());
        student.setAddress(entity.getAddress());
        student.setDob(entity.getDob());
        return student;
    }
}
