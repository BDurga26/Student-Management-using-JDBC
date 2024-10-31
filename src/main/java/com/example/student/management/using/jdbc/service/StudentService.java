package com.example.student.management.using.jdbc.service;



import org.springframework.stereotype.Service;

import com.example.student.management.using.jdbc.entity.Student;
import com.example.student.management.using.jdbc.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public int addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public int updateStudent(Student student) {
        return studentRepository.update(student);
    }

    public int deleteStudent(Long id) {
        return studentRepository.deleteById(id);
    }
}