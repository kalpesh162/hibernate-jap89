package com.app;

import java.util.ArrayList;

import com.dao.DepartmentDAO;
import com.dao.DepartmentDAOImpl;
import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.entity.Department;
import com.entity.Student;

public class App {

	public static void main(String[] args) {
		/*
		Student student1 = new Student("Rajesh");
		Student student2 = new Student("Ravi");
		Student student3 = new Student("Rohit");

		ArrayList<Student> list1 = new ArrayList<Student>();
		list1.add(student1);
		list1.add(student2);
		list1.add(student3);

		Department department = new Department();
		department.setDeptName("IT");
		department.setStudents(list1);

		DepartmentDAO dao = new DepartmentDAOImpl();
		dao.addDepartment(department);

		System.out.println("------------------------");
		*/
		
		DepartmentDAO dao = new DepartmentDAOImpl();
		Student student4 = new Student("Pawan");
		
		StudentDAO studentDAO=new StudentDAOImpl();
		studentDAO.saveStudent(1, student4);
		
		System.out.println("---------------------------");
		
	}

}
