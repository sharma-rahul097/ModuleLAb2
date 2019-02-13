package com.lab10.q10_2.service;

import com.lab10.q10_2.bean.Employee;
import com.lab10.q10_2.bean.Employee.Designation;
import com.lab10.q10_2.exception.EmployeeException;

public class EmpInsSystem implements EmployeeService {

	@Override
	public Employee setInsScheme(double Salary, Designation designation, Employee e) throws EmployeeException {

		if (Salary < 3000) {
			throw new EmployeeException();
		}
		if (e.getDeg().name().equals("Clerk") && (e.getSalary() < 5000)) {
			e.setInScheme("No Scheme ");
		}
		if (e.getDeg().name().equals("System_Associate") && (e.getSalary() > 5000 && e.getSalary() < 20000)) {
			e.setInScheme("Scheme " + "C");
		}
		if (e.getDeg().name().equals("Programmer") && (e.getSalary() >= 20000 && e.getSalary() < 40000)) {
			e.setInScheme("Scheme " + "B");
		}
		if (e.getDeg().name().equals("Manager") && (e.getSalary() > 40000)) {
			e.setInScheme("Scheme " + "A");
		}

		return e;

	}

}
