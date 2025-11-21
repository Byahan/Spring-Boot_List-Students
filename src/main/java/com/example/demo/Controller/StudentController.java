package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.Service.StudentService;
import com.example.demo.Domain.Student;
import com.example.demo.Domain.StudentRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentRequest request) {
        return studentService.addStudent(request);
    }

    @GetMapping("/nim/{nim}")
    public Student getByNim(@PathVariable String nim) {
        return studentService.findByNim(nim);
    }

    @DeleteMapping("/nim/{nim}")
    public String removeByNim(@PathVariable String nim) {
        studentService.deleteByNim(nim);
        return "Deleted student with NIM: " + nim;
    }

    @PutMapping("/nim/{nim}")
    public Student updateByNim(@PathVariable String nim, @RequestBody StudentRequest request) {
        return studentService.updateByNim(nim, request);
    }
}
