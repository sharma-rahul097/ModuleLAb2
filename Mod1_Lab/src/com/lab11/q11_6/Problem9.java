package com.lab11.q11_6;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;



public class Problem9 {

	static void durationService(Employee emp) {
		
		System.out.println(emp.getFirstName()+" "+emp.getLastName()+"  "+Period.between(emp.getHireDate(), LocalDate.now()));
	}
	
	public static void main(String[] args) {
		
		List<Employee> list = EmployeeRepository.list;
		
		//List employee name and duration of their service in months and days.
		
		list.stream().forEach(Problem9::durationService);
	}
}
