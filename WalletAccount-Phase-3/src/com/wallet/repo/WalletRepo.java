package com.wallet.repo;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wallet.bean.Customer;
import com.wallet.bean.Transaction;
import com.wallet.exception.CustomerNotFoundException;
import com.wallet.exception.DuplicatePhoneException;
import com.wallet.util.JPAUtil;


public class WalletRepo implements IWalletRepo {

	EntityManager em = null;
	EntityTransaction enTrans = null;
	public WalletRepo() {
		// TODO Auto-generated constructor stub 
		em = JPAUtil.getEntManager();
		enTrans = em.getTransaction();
	}
	//********************************Wallet Account*******************************************************
	/*******************************************************************************************************
	 - Function Name	:	save(Customer cus)
	 - Input Parameters	:	Customer cus
	 - Return Type		:	boolean
	 - Throws			:  	DuplicatePhoneException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	Adding Customer
	 ********************************************************************************************************/
	public boolean save(Customer cus) throws DuplicatePhoneException
	{
	/*	if(hm.containsKey(cus.getPhone()))
		{
		}
		else
		{
		hm.put(cus.getPhone(), cus);*/
		enTrans.begin();
		if(em.find(Customer.class, cus.getPhone())==null)
		{
			em.persist(cus);
			enTrans.commit();
			return true;
		}
		throw new DuplicatePhoneException();
	}
	/*******************************************************************************************************
	 - Function Name	:	showByPhone(String phone)
	 - Input Parameters	:	String phone
	 - Return Type		:	Customer
	 - Throws			:  	CustomerNotFoundException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	Show information through Mobile number
	 ********************************************************************************************************/
	public Customer showByPhone(String phone) throws CustomerNotFoundException
	{
		Customer cus = new Customer();
		cus= em.find(Customer.class, phone);
		if(cus == null)
		{
			throw new CustomerNotFoundException();
		}
		return cus;
		/*if(hm.containsKey(phone))
			{
				 return hm.get(phone);
			}*/
	}
	
	/*******************************************************************************************************
	 - Function Name	:	retriveAllDetails(String phone)
	 - Input Parameters	:	String phone
	 - Return Type		:	ArrayList<Transaction>
	 - Throws			:  	NA
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	return the Transaction happen between Customer List
	 ********************************************************************************************************/
	public ArrayList<Transaction> retriveAllDetails(String phone) 
	{
		return null;
	/*	return hm.get(phone).getAl();*/
	}
	/*******************************************************************************************************
	 - Function Name	:	saveTransaction(String mobileNo, Transaction t)
	 - Input Parameters	:	String mobileNo, Transaction t
	 - Return Type		:	boolean
	 - Throws			:  	CustomerNotFoundException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	add the transaction happen between Customer
	 ********************************************************************************************************/
	public boolean saveTransaction(String mobileNo, Transaction t) throws CustomerNotFoundException
	{
		enTrans.begin();
		if(em.find(Transaction.class, mobileNo)==null)
		{
			em.persist(t);
			enTrans.commit();
			return true;
		}
		throw new CustomerNotFoundException();
		/*if(hm.containsKey(mobileNo))
		{
			hm.get(mobileNo).getAl().add(t);
			return true;
		}
		throw new CustomerNotFoundException();*/
	}
	
	public void updateBal(Customer cus)
	{
		enTrans.begin();
		em.merge(cus);
		enTrans.commit();
		
	}
}
