package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Enrollment;
import com.example.demo.Entity.Student;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	
	@Query("SELECT s FROM Enrollment s WHERE s.student.id = ?1")
	List<Enrollment> findEnrollmentById (Long id);
	
	@Query("SELECT s.course FROM Enrollment s WHERE s.student.id = ?1")
	List<Course> findStudentById (Long id);
	
	@Query("SELECT s.student FROM Enrollment s WHERE s.course.id = ?1")
	List<Student> findCourseById (Long id);
}
