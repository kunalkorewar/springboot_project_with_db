package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	List<Student> list;

	@PostMapping(value = "saveStudent")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {

		System.out.println(student);

		String string = service.saveStudent(student);

		if (string.equals("Data Save Successfully..")) {
			return new ResponseEntity<>(string, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(string, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("studentList")
	public ResponseEntity<List<Student>> studentList() {

		System.out.println("hello");

		list = service.studentList();

		System.out.println("hello : " + list);

		if (!list.isEmpty()) {
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);

		}
	}

	@GetMapping("getStudentById/{id}")
	public ResponseEntity<String> getStudentById(@PathVariable String id) {

		System.out.println("hello : " + id);

		Student student = service.getStudentById(id);

		if (student != null) {

			return new ResponseEntity<String>(student + "", HttpStatus.OK);

		} else {

			String sid = "This sId Is Not Present..";

			return new ResponseEntity<String>(sid, HttpStatus.NO_CONTENT);
//		    if internal server error hai tohi yaha se string bhej 
//		    sakte if contain not found hai to nhi bhj sakte

		}

	}

	@DeleteMapping("deleteStudentId/{id}")
	public ResponseEntity<Boolean> deleteStudentId(@PathVariable String id) {

		boolean result = service.deleteStudentId(id);

		if (result) {
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(result, HttpStatus.NO_CONTENT);
		}

	}
}