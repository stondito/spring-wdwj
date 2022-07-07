package com.example.projectspring.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of( new Student(
                "Stoyan",
                "gabrovskiStoyan@gmail.com",
                LocalDate.of(2000, Month.AUGUST, 7),
                18,
                62401));
    }
}
