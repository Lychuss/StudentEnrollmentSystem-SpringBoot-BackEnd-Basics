package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	@Query("SELECT s FROM Course s WHERE s.title = ?1")
	Optional<Course> findCourseByTitle (String title);
	
	@Query("SELECT s FROM Course s WHERE s.id = ?1")
	Optional<Course> findCourseById (Long id);
}
