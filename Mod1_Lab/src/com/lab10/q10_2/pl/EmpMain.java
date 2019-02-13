package com.lab10.q10_2.pl;

import java.util.Scanner;

import com.lab10.q10_2.bean.Employee;
import com.lab10.q10_2.bean.Employee.Designation;
import com.lab10.q10_2.exception.EmployeeException;
import com.lab10.q10_2.service.EmpInsSystem;

public class EmpMain {

	static Scanner sc=new Scanner(System.in);
	static EmpInsSystem e;
	static Employee e1;
	//static Designation d1;
	public static void main(String[] args) {
	
	    try {
			getDetails();
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    	Display();
	    }
	    catch(NullPointerException n) {
	    	System.out.println("");
	    }
	    
		

	}
	
	public static void getDetails() throws EmployeeException {
		
		e=new EmpInsSystem();
		Designation d;
		
		
		System.out.println("Enter the Id: ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your name: ");
		String name=sc.nextLine();
		d=desig();
		System.out.println("Enter your Salary: ");
		double sal=sc.nextDouble();
		
	    e1=new Employee(id, name, sal, d);
		if(sal<3000)
			throw new EmployeeException();
    	
    }
	
	public static void Display()
	{

		System.out.println("\n\nEmpId: "+e1.getId());
		System.out.println("Name: "+e1.getName());
		System.out.println("Designation: "+e1.getDeg().name());
		System.out.println("Salary: "+e1.getSalary());
		System.out.println("Insurence Scheme: "+e1.getInScheme());
		System.out.println("\n");
	}
   
	public static Designation desig() {
		
		Designation d = null;
		
		System.out.println("Select your Designation: ");
		System.out.println("1. Clerk");
		System.out.println("2. Programmer");
		System.out.println("3. System Associate");
		System.out.println("4. Manager");
		System.out.println("Enter your choice: ");
		int ch=sc.nextInt();
		switch(ch) {
			
		          case 1: d=Designation.Clerk;
		          			break;
		          case 2: d=Designation.Programmer;
		          			break;
		          case 3: d=Designation.System_Associate;
		          			break;
		          case 4: d=Designation.Manager;
		          			break;
		          default: System.out.println("Wrong Choice !!");
		}
		return d;
	}
	
}
