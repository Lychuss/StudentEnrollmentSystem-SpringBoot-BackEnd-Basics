Enrollment System API
A Spring Boot REST API project that manages Students, Courses, and Enrollments, built as part of my Spring Boot learning journey.
This project demonstrates CRUD operations, REST API design, JPA relationships, and database integration with MySQL.

Features
👨‍🎓 Student Management

Add new students

View all students

Delete students

📚 Course Management

Add new courses

View all courses

📝 Enrollment Management

Enroll students in courses

View all courses a student is enrolled in

Delete enrollments

🔐 Basic Authentication (Spring Security)

Secured endpoints with admin credentials from application.properties

🗄 MySQL Database Integration

students, courses, and enrollments tables with One-to-Many / Many-to-One relationships

Tech Stack
Backend: Spring Boot 3.x

Database: MySQL

ORM: Spring Data JPA + Hibernate

Security: Spring Security (Basic Auth)

Testing: JUnit (basic test setup)

Tools: Maven, Eclipse IDE

API Endpoints
Students
Method	Endpoint	Description
GET	/api/v1/students	Get all students
POST	/api/v1/students	Add new student (JSON body)
DELETE	/api/v1/students/{id}	Delete a student by ID

Courses
Method	Endpoint	Description
GET	/api/v1/courses	Get all courses
POST	/api/v1/courses	Add new course (JSON body)

Enrollments
Method	Endpoint	Description
GET	/api/v1/enrollments/student/{id}	Get all courses for a student
POST	/api/v1/enrollments	Enroll a student to a course
DELETE	/api/v1/enrollments/delete/student={id}	Delete all enrollments of student

Sample JSON Requests
Add Student
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "dob": "2002-06-15"
}
Add Course
json
Copy
Edit
{
  "title": "Spring Boot Fundamentals",
  "description": "Learn the basics of Spring Boot."
}
Enroll a Student
json
Copy
Edit
{
  "studentId": 1,
  "courseId": 2
}
Setup Instructions
Clone the repository

git clone https://github.com/YOUR_USERNAME/enrollment-system.git
cd enrollment-system
Configure Database in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/enrollmentsystem?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.security.user.name=admin
spring.security.user.password=12345
Run the project
mvn spring-boot:run
Test the API using Postman on http://localhost:8080/api/v1/

Future Improvements
✅ Add frontend using React or Angular

✅ Add JWT authentication for better security

✅ Add pagination and filtering for students and courses
