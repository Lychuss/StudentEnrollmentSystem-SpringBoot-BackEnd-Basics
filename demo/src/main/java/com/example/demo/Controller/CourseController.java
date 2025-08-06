
package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Course;
import com.example.demo.Services.CourseService;

@RestController
@RequestMapping(path= "/api/courses")
public class CourseController {
	
	private final CourseService service;
	
	@Autowired
	public CourseController(CourseService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Course> getCourse() {
		return service.getCourse();
	}
	
	@PostMapping("/addcourses")
	public boolean addStudent(@RequestBody Course student) {
		return service.addNewCourse(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteStudent(@PathVariable Long id) {
		return service.deleteCourse(id);
	}
}
