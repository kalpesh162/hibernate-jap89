package com.app;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.entity.Address;

public class App {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAOImpl();
		/*
		Address address = new Address("MH", "MLK");
		Student student = new Student("RAJU", address);

		StudentDAO dao = new StudentDAOImpl();

		dao.saveStudent(student);
		*/
		System.out.println("+++++++++++++++++++++++++++++++");

		/*
		Student student = new Student();
		student.setName("Tushar");

		StudentDAO dao = new StudentDAOImpl();

		dao.saveStudent(student);
		*/
		Address address = new Address("MH", "MUMBAI");
		
		dao.saveAddress(2, address);
		

	}

}
