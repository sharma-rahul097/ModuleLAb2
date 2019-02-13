package com.lab10.q10_2.service;

import com.lab10.q10_2.bean.Employee;
import com.lab10.q10_2.bean.Employee.Designation;
import com.lab10.q10_2.exception.EmployeeException;

public interface EmployeeService {
	
	public Employee setInsScheme(double Salary, Designation designation, Employee e) throws EmployeeException; 
}
