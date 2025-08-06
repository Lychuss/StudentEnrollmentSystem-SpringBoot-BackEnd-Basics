package com.example.demo.Entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min= 2, max= 50)
	private String name;
	
	@Email
	@NotNull
	private String email;
	
	@Getter(AccessLevel.NONE)
	@Transient
	private int age;
	
	@Past
	private LocalDate dob;
	
	@OneToMany(mappedBy= "student")
	private List<Enrollment> enrollees = new ArrayList<>();
	
	public int getAge() {
		return Period.between(dob, LocalDate.now()).getYears();
	}
	
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
}

