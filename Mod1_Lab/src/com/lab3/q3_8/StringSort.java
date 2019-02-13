package com.lab3.q3_8;

import java.util.Arrays;

public class StringSort {

	public static void main(String[] args) {
		
		String[] a= {"abc","kite","zebra","apple","carrot","action"};
		Arrays.sort(a);
		for(int i=0;i<a.length;i++) {
			if(a.length%2==0) {
				if(i<(a.length/2))
					a[i]=a[i].toUpperCase();
				else
					a[i]=a[i].toLowerCase();
			}
			else
			{
				if(((a.length/2)+1)>i)
					a[i]=a[i].toUpperCase();
				else
					a[i]=a[i].toLowerCase();
			}
		}
		for(String i:a)
			System.out.println(i);
	}

}
