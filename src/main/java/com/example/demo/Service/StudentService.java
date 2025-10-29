package com.example.demo.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Domain.Student;
import com.example.demo.Domain.StudentRequest;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        // Data awal
        students.add(new Student("231110001", "Ahmad", LocalDate.of(2003, 1, 10), "Jakarta"));
        students.add(new Student("231110002", "Budi", LocalDate.of(2002, 5, 20), "Bandung"));
        students.add(new Student("231110003", "Chandra", LocalDate.of(2004, 3, 15), "Surabaya"));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student addStudent(StudentRequest studentRequest) {
        Student newStudent = new Student(
            studentRequest.getNim(),
            studentRequest.getFullName(),
            studentRequest.getDob(),
            studentRequest.getAddress()
        );

        students.add(newStudent);
        return newStudent;
    }
    
    public void deleteStudent(String nim) {
        Optional<Student> studentOptional = students.stream()
            .filter(student -> student.getNim().equals(nim))
            .findFirst();

        if (studentOptional.isPresent()) {
            Student studentToDelete = studentOptional.get();
            students.remove(studentToDelete);
        } else {
            throw new RuntimeException("Student with NIM " + nim + " not found");
        }
    }

    public Student updateStudent(String nim, Student updatedStudent) {
    // Cari student berdasarkan NIM
        Optional<Student> studentOptional = students.stream()
            .filter(student -> student.getNim().equals(nim))
            .findFirst();

        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();

        // Update data student
        existingStudent.setFullName(updatedStudent.getFullName());
        existingStudent.setAddress(updatedStudent.getAddress());
        existingStudent.setDob(updatedStudent.getDob());

        return existingStudent; // kembalikan student yang sudah diperbarui
        } else {
            throw new RuntimeException("Student with NIM " + nim + " not found");
        }
    }

    public Student findStudentByNim(String nim) {
        Optional<Student> studentOptional = students.stream()
            .filter(student -> student.getNim().equals(nim))
            .findFirst();

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new RuntimeException("Student with NIM " + nim + " not found");
        }
    }

}
