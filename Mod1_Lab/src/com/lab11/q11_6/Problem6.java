package com.lab11.q11_6;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;



public class Problem6 {

	public static void main(String[] args) {
		
		List<Employee> list = EmployeeRepository.list;
		
		//Find out sum of all employee
		 Optional<Double> sum = list.stream().map(l -> l.getSalary()).reduce((a, b) -> a+b);
		 System.out.println(new BigDecimal(sum.get()));
	}

}
