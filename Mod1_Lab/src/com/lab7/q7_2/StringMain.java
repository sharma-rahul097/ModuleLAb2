package com.lab7.q7_2;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class StringMain {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("Enter the String 1: ");
		String s1=sc.next();
		System.out.println("Enter the String 2: ");
		String s2=sc.next();
		al.add(Alternate(s1, s2));
		al.add(occuerence(s1, s2));
		al.add(occuerence2(s1, s2));
		al.add(divide(s1, s2));
		al.add(replace(s1, s2));
		
		ListIterator<String> l=al.listIterator();
		while(l.hasNext())
			System.out.println(l.next());
	}

	public static String Alternate(String s1,String s2) {
		
		String a="";
		int j2=0;
		for(int i=0;i<s1.length();i++) {
			if(i%2==1 && j2<s2.length()) {
				a+=s2.charAt(j2);
				j2++;
			}
			else {
				a+=s1.charAt(i);
			}
		}
		
		return a;
	}
	
	public static String occuerence(String s1,String s2)
	{
		String a="";
		
	    if(s1.indexOf(s2)!=s1.lastIndexOf(s2))
		{
			a+=s1.substring(0, s1.lastIndexOf(s2));
			a+=reverse(s2);
			a+=s1.substring( s1.lastIndexOf(s2)+s2.length());
		}
		return a+s2;
	}
	
	public static String occuerence2(String s1,String s2)
	{
		String a="";
		
	    if(s1.indexOf(s2)!=s1.lastIndexOf(s2))
		{
			a+=s1.substring(0, s1.indexOf(s2));
			a+=s1.substring( s1.indexOf(s2)+s2.length());
		}
		return a;
	}

	public static String divide(String s1, String s2) {
		String a="";
		if(s2.length()%2==0)
		{
			a+=s2.substring(0, s2.length()/2);
			a+=s1;
			a+=s2.substring((s2.length()/2));
		}
		else
		{
			a+=s2.substring(0, (s2.length()/2)+1);
			a+=s1;
			a+=s2.substring((s2.length()/2)+1);
		}
		return a;
	}
	
	public static String replace(String s1, String s2) {

		for(int i=0;i<s2.length();i++) {
			s1=s1.replace(s2.charAt(i), '*');
		}
		return s1;
	}
	
	public static String reverse(String a) {
		String b="";
		for(int i=a.length()-1;i>=0;i--)
		{
			b+=a.charAt(i);
		}
		return b;
	}
	
}
