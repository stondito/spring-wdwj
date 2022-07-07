package com.example.projectspring.student;

import java.time.LocalDate;

public class Student {
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
    private Integer fn;

    public Student(String name, String email, LocalDate dob, Integer age, Integer fn) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.fn = fn;
    }

    public Student(String name, String email, LocalDate dob, Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFn() {
        return fn;
    }

    public void setFn(Integer fn) {
        this.fn = fn;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", fn=" + fn +
                '}';
    }
}
