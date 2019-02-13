package com.lab11.q11_1_to_q11_5;

interface CreationIns {
	 String say();
}

public class pro_4_Creation {

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		pro_4_Creation p = new pro_4_Creation();
		p.setName("rahul");
		CreationIns ci = p::getName;
		System.out.println(ci.say());
	}
}
