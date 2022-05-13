package com.springboot.dao;

import java.util.List;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Student;

@Repository
public class Mydao_Impl implements Mydao {

	@Autowired
	SessionFactory factory;

	Session session;
	Transaction tx;
	List<Student> list;

	Mydao_Impl() {

	}

	@PostConstruct
	public void init() {
		getLatestData();
	}

	public void getLatestData() {

		session = factory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		list = criteria.list();
	}

	@Override
	public String saveStudent(Student student) {
		// System.out.println("hello");
		System.out.println(student);

		try {
			session = factory.openSession();

			tx = session.beginTransaction();

			// System.out.println("hi");

			session.save(student);// here no exception bcz data 1st save in temp teble

			// System.out.println("bye");

			tx.commit();// exception on commit if id is same

		} catch (Exception e) {

			// e.printStackTrace();

			return "data rollBack..";

		} finally {
			session.close();
		}

		// System.out.println("tata");

		return "Data Save Successfully..";
	}

	@Override
	public List<Student> studentList() {
		getLatestData();
		System.out.println("bye");
		System.out.println("bye : " + list);
		return list;
	}

	@Override
	public Student getStudentById(String id) {
		getLatestData();
		/*
		 * getLatestData() method har request me cll krni h tabhi latest data mil
		 * payenga otherwise jo first time database se data ata h if raha db me to to
		 * vahi data milta hai jo badme hum add krte h vo nhi milta so bst practice ye
		 * hai ki har bar getLatestData method ko har method me cll krna h
		 */
		System.out.println("bye bye : " + id);

		Student std = null;

		for (Student student : list) {

			System.out.println("bye bye bye : " + id);

			System.out.println(student.getStudentid() + "stu");

			if (student.getStudentid().equals(id)) {

				System.out.println("bye bye bye bye : " + id);

				std = student;

				break;
			}
		}
		System.out.println("bye bye bye bye bye : " + id);

		return std;
	}

	@Override
	public boolean deleteStudentId(String id) {
		getLatestData();

		Student std = null;

		for (Student student : list) {

			if (student.getStudentid().equals(id)) {

				std = student;
				break;

			}
		}

		if (std != null) {

			session = factory.openSession();
			tx = session.beginTransaction();
			Student student = session.get(Student.class, id);
			session.delete(student);
			tx.commit();

			return true;
		} else {
			return false;
		}

	}

	@Override
	public Student updateStudent(Student student) {
		getLatestData();

		return null;
	}

}
