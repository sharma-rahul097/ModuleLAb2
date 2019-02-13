package com.lab11.q11_6;

public interface IEmployeeRepo {

	boolean save(Employee e);

	Employee showById(int empId);

}