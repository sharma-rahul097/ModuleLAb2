package com.lab11.q11_1_to_q11_5;

interface PowerOf
{
	int power(int x,int y);
}
public class pro_1_Power {
	public static void main(String[] args) {
	PowerOf op = (x,y)->{ return (int) Math.pow(x, y); 
						};
			System.out.println(op.power(2, 3));
	}			
}
