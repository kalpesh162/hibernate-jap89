package com.app;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.entity.Address;
import com.entity.Student;

public class App {

	public static void main(String[] args) {

		Address address = new Address("MH", "MLK");
		Student student = new Student("RAJU", address);

		StudentDAO dao = new StudentDAOImpl();

		dao.saveStudent(student);

		System.out.println("+++++++++++++++++++++++++++++++");

	}

}
