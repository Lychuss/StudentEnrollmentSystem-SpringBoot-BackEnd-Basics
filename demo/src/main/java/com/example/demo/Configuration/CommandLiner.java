package com.example.demo.Configuration;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.StudentRepository;

@Configuration
public class CommandLiner {

	@Bean
	CommandLineRunner commandRunnerStudent(StudentRepository repository) {
		return args -> {
			Student student = new Student("Carlo", "carlojames@gmail.com", LocalDate.of(2005, Month.JULY, 19));
		};
	}
	
	@Bean
	CommandLineRunner commandRunnerCourse(CourseRepository repository) {
		return args -> {
			Course course = new Course("Java Programmer", "A course that can master OOP");
			Course course1 = new Course("AI Programmer", "A course that can master AI");
		};
	}
}
