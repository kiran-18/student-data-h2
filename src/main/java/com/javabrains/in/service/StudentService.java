package com.javabrains.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabrains.in.entity.Student;
import com.javabrains.in.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Optional<Student> getStudentById(int id) {
		return repo.findById(id);
	}
	
	public List<Student> getStudents() {
		return repo.findAll();
	}
	
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	public List<Student> saveStudents(List<Student> students) {
		return repo.saveAll(students);
	}
	
	public  String removeStudentById(int id) {
		repo.deleteById(id);
		return "deleted id is :-> " + id;
	}
	
	public Student updateStudent(Student student) {
		Student existingStudent = repo.getById(student.getId());
		existingStudent.setName(student.getName());
		existingStudent.setId(student.getId());
		existingStudent.setRollno(student.getRollno());
		
		return repo.save(existingStudent);
		}
	
	
	
	

}
