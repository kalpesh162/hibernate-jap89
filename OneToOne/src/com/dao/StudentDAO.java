package com.dao;

import com.entity.Address;
import com.entity.Student;

public interface StudentDAO {

	void saveStudent(Student student);

	public void saveAddress(int id, Address address);

}
