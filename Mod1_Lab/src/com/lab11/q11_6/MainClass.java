package com.lab11.q11_6;

import java.util.Scanner;

public class MainClass {

	static EmployeeService es = new EmployeeService(new EmployeeRepo());
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true)
		{
			menu();
		}
		
	}
	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. Enter the details:");
		System.out.println("2.calculate salary");
		System.out.println("3.exit");
		int ch = sc.nextInt();
		sc.nextLine();
		switch(ch)
		{
		case 1: populateData();
				break;
		case 2: CalSalary();
				break;
		case 3: System.exit(0);		
		}
	}
	private static void CalSalary() {
		// TODO Auto-generated method stub
		
	}
	private static void populateData() {
		// TODO Auto-generated method stub
		
		
		
	}

}
