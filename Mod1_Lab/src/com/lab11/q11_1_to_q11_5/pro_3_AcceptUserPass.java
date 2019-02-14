package com.lab11.q11_1_to_q11_5;


interface UserPass
{
	boolean check(String user,String pass);
}
public class pro_3_AcceptUserPass {

	public static void main(String[] args) {
		
		UserPass up =(String user,String pass)->{
			if(user.equals("rahul")&&pass.equals("abzx8888"))
			{
			return true;
			}
			return false;
		};
		System.out.println(up.check("rahul", "abzx8888"));
	}
}
