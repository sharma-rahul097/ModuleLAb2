package com.lab11.q11_6;

import java.time.LocalDate;

public interface IEmployeeService {

	public Employee createDetails(int empId, String firstName, String lastName, String email, String phoneNo, LocalDate hireDate,
			String designation, double salary, int managerId, Department department);

	Employee findByEmpId(int empId);

}