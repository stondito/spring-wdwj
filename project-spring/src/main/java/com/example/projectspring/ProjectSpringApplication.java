package com.example.projectspring;

import com.example.projectspring.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class ProjectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringApplication.class, args);
	}

	@GetMapping
	public List<Student> hello() {
		return List.of( new Student(
						"Stoyan",
						"gabrovskiStoyan@gmail.com",
						LocalDate.of(2000, Month.AUGUST, 7),
						18,
						62401));
	}

}
