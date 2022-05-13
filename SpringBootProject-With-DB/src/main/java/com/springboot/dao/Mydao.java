package com.springboot.dao;

import java.util.List;


import com.springboot.entity.Student;


public interface Mydao {
	public String saveStudent(Student student);

	public List<Student> studentList();

	public Student getStudentById(String id);

	public boolean deleteStudentId(String id);

	public Student updateStudent(Student student);

}
