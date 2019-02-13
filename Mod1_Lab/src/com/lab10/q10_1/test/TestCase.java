package com.lab10.q10_1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lab10.q10_1.Person;
import com.lab10.q10_1.Person.*;

public class TestCase {

	@Test
	public void testGetFullName()
	{
	System.out.println("from TestPerson2");
	Person per = new Person("Rahul","Singh",Gen.M, "81818181818" );
	assertEquals("Rahul Singh",per.getF_name()+" "+per.getL_name());
	}
	
	@Test (expected=NullPointerException.class)
	public void testNullsInName()
	{
		System.out.println("from TestPerson2 testing exceptions");
		Person per1 = new Person(null,null,Gen.M, "81818181818");
		per1.disp();
		}
	
	@Test
	public void getFirstName()
	{
		Person p = new Person("Robert", "Dicosta",Gen.M, "81818181818");
		assertEquals(p.getF_name(),"Robert");
	}
	
	@Test
	public void getLastName()
	{
		Person p = new Person("Robert", "Dicosta",Gen.M, "81818181818");
		assertEquals(p.getL_name(),"Dicosta");
	}

}
