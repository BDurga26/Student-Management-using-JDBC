package com.example.student.management.using.jdbc.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.student.management.using.jdbc.entity.Student;


@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Student student) {
        String sql = "INSERT INTO students (name, age, section) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getSection());
    }

    public Student findById(Long id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    public int update(Student student) {
        String sql = "UPDATE students SET name = ?, age = ?, section = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getSection(), student.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}