package com.lab10.q10_2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lab10.q10_2.bean.Employee;
import com.lab10.q10_2.bean.Employee.Designation;
import com.lab10.q10_2.exception.EmployeeException;
import com.lab10.q10_2.service.EmpInsSystem;
import com.lab10.q10_2.service.EmployeeService;

public class EmployeeTest {
	EmployeeService emp;
	@Before
	public void setUp()
	{
		emp = new EmpInsSystem();
	}
	@Test
	public void whenInfoIsValid()
	{
		Employee e = new Employee(101,"Raj",4000,Designation.Clerk);
		e.setInScheme("No Scheme");
		Employee e1 = new Employee(101, "Raj", 4000, Designation.Clerk);
		e1.setInScheme("No Scheme");
		assertEquals(e, e1);
		
	}
	
	@Test(expected = com.lab10.q10_2.exception.EmployeeException.class)
	public void whenSalIsLessThan3000() throws EmployeeException
	{
		Employee e = new Employee(101,"Raj",2000,Designation.Clerk);
		emp.setInsScheme(200, Designation.Clerk, e);
		
		
	}

}
