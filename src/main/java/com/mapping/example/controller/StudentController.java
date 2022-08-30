package com.mapping.example.controller;

import com.mapping.example.entity.Student;
import com.mapping.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStudents(){
        return studentService.getStudents();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
}
