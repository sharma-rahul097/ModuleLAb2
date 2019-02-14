package com.lab11.q11_6;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Problem11 {

	public static void main(String[] args) {
		// Find out department without employees
		List<Employee> emplist = EmployeeRepository.list;
		
		
		List<Employee> elist = emplist.stream().filter(emp -> emp.getDepartment()!=null).collect(Collectors.toList());
		
	}

}
