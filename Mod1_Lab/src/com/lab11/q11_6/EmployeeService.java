package com.lab11.q11_6;

import java.time.LocalDate;

public class EmployeeService implements IEmployeeService {

	private IEmployeeRepo ir;

	public EmployeeService(IEmployeeRepo ir) {
		super();
		this.ir = ir;
	}
	
	public Employee createDetails(int empId, String firstName, String lastName, String email, String phoneNo, LocalDate hireDate,
			String designation, double salary, int managerId, Department department) 
	{
		Employee e = new Employee(managerId, designation, designation, designation, designation, hireDate, designation, salary, managerId, department);
		if(ir.save(e))
		{
			return e;
		}
		return null;
	}
	
	public Employee findByEmpId(int empId)
	{
		return ir.showById(empId);
	}
}
