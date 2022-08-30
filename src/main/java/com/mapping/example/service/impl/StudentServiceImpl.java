package com.mapping.example.service.impl;

import com.mapping.example.entity.Student;
import com.mapping.example.repository.StudentRepository;
import com.mapping.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<?> saveStudent(Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @Override
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @Override
    public ResponseEntity<?> updateStudent(Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }
}
