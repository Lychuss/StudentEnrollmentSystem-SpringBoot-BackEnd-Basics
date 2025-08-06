package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Course;
import com.example.demo.ErrorHandler.CourseNotFoundException;
import com.example.demo.Repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository repository;
	
	@Autowired
	public CourseService(CourseRepository repository) {
		this.repository = repository;
	}
	
	public boolean addNewCourse(Course courses) {
		Optional<Course> course = repository.findCourseByTitle(courses.getTitle());
		if(course.isPresent()) {
			throw new IllegalStateException("Title already input!");
		} else {
			repository.save(courses);
			return true;
		}
	}
	
	public List<Course> getCourse(){
		return repository.findAll();
	}
	
	public boolean deleteCourse(Long id) {
		Course course = repository.findCourseById(id).get();
		if(course.equals(null)) {
			throw new CourseNotFoundException("Course not found " + id);
		} else {
			repository.delete(course);
			return true;
		}
		
	}
}
