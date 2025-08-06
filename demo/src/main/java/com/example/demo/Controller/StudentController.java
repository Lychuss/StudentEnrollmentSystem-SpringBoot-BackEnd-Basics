package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Services.StudentService;

@RestController
@RequestMapping(path= "api/students")
public class StudentController {

	private final StudentService service;
	
	@Autowired
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return service.getStudents();
	}
	
	@GetMapping("/search/{id}")
	public Student getStudent(@PathVariable Long id) {
		return service.getStudent(id);
	}
	
	@PostMapping("/addstudent")
	public boolean addStudent(@RequestBody Student student) {
		return service.addNewStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteStudent(@PathVariable Long id) {
		return service.deleteStudent(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
		Student students = service.updateStudent(id, student);
		return ResponseEntity.ok(students);
	}
}
