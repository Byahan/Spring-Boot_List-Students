package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

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

    public void addStudent(Student student) {
        students.add(student);
    }
}
