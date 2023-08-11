package com.yassine.StudentRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.StudentRoster.models.Student;
import com.yassine.StudentRoster.repositories.StudentRepository;

@Service
public class StudentService {
	//
	@Autowired
	private StudentRepository studentRepository;
	//SHOW ALL Students
	public List<Student> allStudents(){
		return studentRepository.findAll();
	}
	//retrieve all without dorms
	public List<Student> allStudentsWithoutADorm(){
		List<Student> allStudents = studentRepository.findAll();
	for (int i = 0; i< allStudents.size();i++) {
		Student temp = allStudents.get(i);
		if(temp.getDorm()!= null) {
			allStudents.remove(i);
			i--;
		}
	}
	return allStudents;
	}
	
	//+---++--+-+-+- CREATE ONE
	public Student createStudent(Student s) {
		return studentRepository.save(s);
		
	}
	//retrives ONE BY ID
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		}
		else {
			return null;
		}
		
	}
	
	//+-+-+-+-UPDATE ONE#
	public Student updateStudent(Student s) {
		return studentRepository.save(s);
	}
	//+*-+-+-+-*-DELETE ONE
	public void  deleteStudent(Long id) {
	 studentRepository.deleteById(id);
	}
}
