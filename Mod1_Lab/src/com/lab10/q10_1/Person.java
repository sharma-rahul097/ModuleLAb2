package com.lab10.q10_1;

public class Person {

	public enum Gen{
		M,F;
	}
	
	String f_name;
	String l_name;
	Gen gen;
	String p_no;
	
	
	
	public Person(String f_name, String l_name, Gen gen, String p_no) {
		super();
		if(f_name == null || l_name == null)
			throw new NullPointerException();
		this.f_name = f_name;
		this.l_name = l_name;
		this.gen = gen;
		this.p_no = p_no;
	}

	public String getP_no() {
		return p_no;
	}

	public void setP_no(String p_no) {
		this.p_no = p_no;
	}

	
	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public Gen getGen() {
		return gen;
	}

	public void setGen(Gen gen) {
		this.gen = gen;
	}

	public void disp() {
		
		System.out.println("Person Details:");
		System.out.println("_______________");
		System.out.println("\nFirst Name: "+getF_name());
		System.out.println("Last Name: "+getL_name());
		System.out.println("Gender: "+gen.name());
		System.out.println("Phone Num: "+getP_no());

	}
	
}
