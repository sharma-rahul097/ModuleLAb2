package com.lab11.q11_1_to_q11_5;
interface Fact
{
	int Facto(int num);
}
public class pro_5_fact {

	public static int Factorial(int a)
	{
		int fact = 1;
		for(int i =1;i<=a;i++)
		{
			fact*=i;
		}
		return fact;
	}
	public static void main(String[] args) {
		Fact fac = pro_5_fact::Factorial;
		System.out.println(fac.Facto(5));
	}
}
