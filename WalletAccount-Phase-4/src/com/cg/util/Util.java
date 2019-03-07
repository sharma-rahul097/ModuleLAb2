package com.cg.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
	
	private static EntityManagerFactory emfactory;
	private static EntityManager entitymanager;
	
	public static EntityManager getEntityManager(){
		
		emfactory = Persistence.createEntityManagerFactory("Customer_Details");
		
		entitymanager = emfactory.createEntityManager();
		
		return entitymanager;
	}
	
	public static boolean closeEntityManager(){
		
		entitymanager.close();
		emfactory.close();
		
		return true;
	}
}
