package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Student;
import com.example.demo.Services.EnrollmentService;

@RestController
@RequestMapping(path= "api/enrollment")
public class EnrollmentController {

	private final EnrollmentService enrollServ;
	
	@Autowired
	public EnrollmentController(EnrollmentService enrollServ) {
		this.enrollServ = enrollServ;
	}
	
	@PostMapping
	public boolean addEnrollees(@RequestParam Long studentId, @RequestParam Long courseId) {
		return enrollServ.addNewEnrollees(studentId, courseId);
	}
	
	@GetMapping("/enroll/student/{id}/courses")
	public List<Course> getCourses(@PathVariable Long id){
		return enrollServ.getCourses(id);
	}
	
	@GetMapping("/enroll/course/{id}/students")
	public List<Student> getStudents(@PathVariable Long id){
		return enrollServ.getStudents(id);
	}
	
	@DeleteMapping("/delete/enrollees/student/{id}")
	public boolean deleteEnrollees(@PathVariable Long id) {
		return enrollServ.deleteEnrollees(id);
	}
	
}
