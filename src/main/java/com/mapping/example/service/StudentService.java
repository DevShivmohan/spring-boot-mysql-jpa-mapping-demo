package com.mapping.example.service;

import com.mapping.example.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<?> saveStudent(final Student student);
    ResponseEntity<?> getStudents();

    ResponseEntity<?> updateStudent(final Student student);
}
