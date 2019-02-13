package com.lab11.q11_1_to_q11_5;

interface StringFor {
	String str(String input);
}

public class pro_2_StringFormat {
	public static void main(String[] args) {
		
		StringFor sf = (input)->{
			String str1 = input.replace("", " ").trim(); 
			return str1;
		};
		System.out.println(sf.str("CG"));
	}
}
