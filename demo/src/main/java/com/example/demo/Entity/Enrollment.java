package com.example.demo.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enrollment")
@Data
@NoArgsConstructor
public class Enrollment {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	@JsonIgnore
	private Course course;
	
	public Enrollment(Student student, Course course) {
		this.student = student;
		this.course = course;
	}
	
}
