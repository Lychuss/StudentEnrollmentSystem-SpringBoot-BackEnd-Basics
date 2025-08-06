package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Enrollment;
import com.example.demo.Entity.Student;
import com.example.demo.ErrorHandler.CourseNotFoundException;
import com.example.demo.ErrorHandler.StudentNotFoundException;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.EnrollmentRepository;
import com.example.demo.Repository.StudentRepository;

@Service
public class EnrollmentService {

	private final StudentRepository studentRepo;
	private final CourseRepository courseRepo;
	private final EnrollmentRepository enrollmentRepo;
	
	@Autowired
	public EnrollmentService( StudentRepository studentRepo, CourseRepository courseRepo, EnrollmentRepository enrollmentRepo) {
		this.studentRepo = studentRepo;
		this.courseRepo = courseRepo;
		this.enrollmentRepo = enrollmentRepo;
	}
	
	public boolean addNewEnrollees(Long studentId, Long courseId) {
		Student student = studentRepo.findStudentById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found: " + studentId));
		Course course = courseRepo.findCourseById(courseId)
				.orElseThrow(() -> new CourseNotFoundException("Course not found: " + courseId));
		Enrollment enrollees = new Enrollment(student, course);
		enrollmentRepo.save(enrollees);
		return true;
	}
	
	public List<Course> getCourses(Long id) {
		return enrollmentRepo.findStudentById(id);
	}
	
	public List<Student> getStudents(Long id) {
		return enrollmentRepo.findCourseById(id);
	}
	
	public boolean deleteEnrollees(Long id) {
		  List<Enrollment> enroll = enrollmentRepo.findEnrollmentById(id);
		  if(!enroll.isEmpty()) {
			  enrollmentRepo.deleteAll(enroll);
			  return true;
		  }
		  return false;
	}
}
