package com.example.student.management.using.jdbc.entity;

public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String section;

    public Student() {}

    public Student(Long id, String name, Integer age, String section) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.section = section;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
}