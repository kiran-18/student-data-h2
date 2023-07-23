package com.javabrains.in.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.in.entity.Student;
import com.javabrains.in.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students/{id}")
	public Optional<Student> retrieveStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return service.getStudents();
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@PostMapping("/students")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return service.saveStudents(students);
	}
	
	@DeleteMapping("/students/{id}")
	public Object deleteStudentById(@PathVariable int id) {
		return service.removeStudentById(id);
	}
	
	@PutMapping("/student")
		public Student alterStudent(@RequestBody Student student) {
			return service.updateStudent(student);
		}
}
