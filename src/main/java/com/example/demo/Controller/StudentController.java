package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.Service.StudentService;
import com.example.demo.Domain.Student;
import com.example.demo.Domain.StudentRequest;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // Konstruktor untuk dependency injection
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Endpoint GET → menampilkan semua student
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    // Endpoint POST → menambah student baru
    @PostMapping
    public Student createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @DeleteMapping("/{nim}")
    public String removeStudent(@PathVariable String nim) {
        try {
            studentService.deleteStudent(nim);
            return "Successfully deleted student with NIM: " + nim;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @PutMapping("/{nim}")
    public Student updateStudent(@PathVariable String nim, @RequestBody Student student) {
        try {
            return studentService.updateStudent(nim, student);
        } catch (Exception e) {
            throw new RuntimeException("Error updating student: " + e.getMessage());
        }
    }

    @GetMapping("/{nim}")
    public Object findStudent(@PathVariable String nim) {
        try {
            return studentService.findStudentByNim(nim);
        } catch (Exception e) {
        // Jika NIM tidak ditemukan, kembalikan pesan
            return "Student not found";
        }
    }

    
}
