package com.example.demo.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.ErrorHandler.StudentNotFoundException;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository repository;
	
	@Autowired
	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}
	
	public boolean addNewStudent(Student student) {
		Optional<Student> students = repository.findStudentByEmail(student.getEmail());
		if(students.isPresent()) {
			throw new IllegalStateException("Title already input!");
		} else {
			repository.save(student);
			return true;
		}
	}
	
	public List<Student> getStudents(){
		return repository.findAll();
	}
	
	public boolean deleteStudent(Long id) {
		Student student = repository.findStudentById(id).get();
		if(student.equals(null)) {
			throw new StudentNotFoundException("Student not found " + id);
		} else {
			repository.delete(student);
			return true;
		}
	}
	
	public Student getStudent(Long id) {
		return repository.findStudentById(id).get();
	}
	
	public Student updateStudent(Long id, Student student) {
		Student students = repository.findStudentById(id).get();
		
		if(!student.getEmail().equals(students.getEmail())) {
			students.setEmail(student.getEmail());
			students.setDob(student.getDob());
			students.setName(student.getName());
		}
		
		return repository.save(students);
	}
}
