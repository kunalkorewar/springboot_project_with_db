package com.springboot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.Mydao;
import com.springboot.entity.Student;

//we need to write service here 
//and not to write on  StudentService interface
//bcz obj will be created to implementation class 
//of  StudentService interface and ie StudentService_Impl class

@Service
public class StudentService_Impl implements StudentService {

	@Autowired
	private Mydao dao;

	List<Student> list;

	@Override
	public String saveStudent(Student student) {

		System.out.println(student);

		if (student.getStudentid() == null) {
			String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm:ss"));

			student.setStudentid(formattedDate);

			System.out.println(student);

			String string = dao.saveStudent(student);

			return string;

		} else {
			String string = dao.saveStudent(student);
			return string;
		}

	}

	@Override
	public List<Student> studentList() {
		System.out.println("hi");

		list = dao.studentList();

		System.out.println("hi : " + list);

		return list;
	}

	@Override
	public Student getStudentById(String id) {

		System.out.println("hi : " + id);

		Student std = dao.getStudentById(id);

		return std;

	}

	@Override
	public boolean deleteStudentId(String id) {
		
		boolean result=dao.deleteStudentId(id);
		
		return result;
	}

	@Override
	public Student updateStudent(Student student) {
		return null;
	}

}
