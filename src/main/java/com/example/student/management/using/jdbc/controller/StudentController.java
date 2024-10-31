package com.example.student.management.using.jdbc.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.student.management.using.jdbc.entity.Student;
import com.example.student.management.using.jdbc.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

 private final StudentService studentService;

 public StudentController(StudentService studentService) {
     this.studentService = studentService;
 }

 @PostMapping
 public ResponseEntity<String> addStudent(@RequestBody Student student) {
     studentService.addStudent(student);
     return ResponseEntity.ok("Student added successfully");
 }

 @GetMapping("/{id}")
 public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
     return ResponseEntity.ok(studentService.getStudentById(id));
 }

 @GetMapping
 public ResponseEntity<List<Student>> getAllStudents() {
     return ResponseEntity.ok(studentService.getAllStudents());
 }

 @PutMapping("/{id}")
 public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
     student.setId(id);
     studentService.updateStudent(student);
     return ResponseEntity.ok("Student updated successfully");
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
     studentService.deleteStudent(id);
     return ResponseEntity.ok("Student deleted successfully");
 }
}
