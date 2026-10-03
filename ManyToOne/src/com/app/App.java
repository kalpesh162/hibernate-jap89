package com.app;

import com.dao.DepartmentDAO;
import com.dao.DepartmentDAOImpl;
import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.entity.Department;
import com.entity.Student;

public class App {
	
	public static void main(String[] args) {
		
		
		Department department1=new Department("CS");
		Department department2=new Department("IT");
		Department department3=new Department("ENTC");
		Department department4=new Department("CIVIL");
		
		Student student1=new Student("Ravi  Shankar", department4);
		Student student2=new Student("Rajesh Kumar", department4);
		Student student3=new Student("Rahul Dravid", department3);
		Student student4=new Student("Ravi Teja", department2);
		Student student5=new Student("Ravi Loddha", department2);
		Student student6=new Student("Ravi Kishan", department1);
		
		DepartmentDAO departmentDAO=new DepartmentDAOImpl();
		departmentDAO.saveDepartment(department1);
		departmentDAO.saveDepartment(department2);
		departmentDAO.saveDepartment(department3);
		departmentDAO.saveDepartment(department4);
		
		StudentDAO studentDAO=new StudentDAOImpl();
		studentDAO.saveStudent(student1);
		studentDAO.saveStudent(student2);
		studentDAO.saveStudent(student3);
		studentDAO.saveStudent(student4);
		studentDAO.saveStudent(student5);
		studentDAO.saveStudent(student6);
		
		
	}

}
