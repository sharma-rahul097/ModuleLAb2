package com.lab11.q11_6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Problem10 {

	public static void main(String[] args) {
		
		List<Employee> list = EmployeeRepository.list;
		
		// Find out employees without department.
		
		List<Employee> l = list.stream().filter(emp -> emp.getDepartment()==null).collect(Collectors.toList());
		
		l.forEach(emp -> System.out.println(emp));
	}

}
