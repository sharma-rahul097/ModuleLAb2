package com.wallet.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wallet.bean.Customer;
import com.wallet.bean.Transaction;
import com.wallet.bean.Transaction.TransactionType;
import com.wallet.bean.Wallet;
import com.wallet.exception.CustomerNotFoundException;
import com.wallet.exception.DuplicatePhoneException;
import com.wallet.exception.InsuffiecientBalanceException;
import com.wallet.exception.NoTransactionOccurException;
import com.wallet.repo.IWalletRepo;

public class WalletService implements IWalletService {

	private IWalletRepo iw;

	public WalletService(IWalletRepo iw) {
		super();
		this.iw = iw;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	save(String name, String phone, BigDecimal balance)
	 - Input Parameters	:	String name, String phone, BigDecimal balance
	 - Return Type		:	Customer
	 - Throws			:  	DuplicatePhoneException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	return the added customer to main
	 ********************************************************************************************************/
	
	public Customer save(String name, String phone, BigDecimal balance) throws DuplicatePhoneException {
		Customer cus = new Customer();
		Wallet wallet = new Wallet();
		cus.setName(name);
		cus.setPhone(phone);
		cus.setWallet(wallet);
		wallet.setBalance(balance);
		if (iw.save(cus)) {
			return cus;
		}
		return null;
	}

	/*******************************************************************************************************
	 - Function Name	:	findByPhone(String phone)
	 - Input Parameters	:	String phone
	 - Return Type		:	Customer
	 - Throws			:  	CustomerNotFoundException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	return the Customer searched customer to main
	 ********************************************************************************************************/
	public Customer findByPhone(String phone) throws CustomerNotFoundException {
		return iw.showByPhone(phone);
	}

	/*******************************************************************************************************
	 - Function Name	:	getDetails(String phone)
	 - Input Parameters	:	String phone
	 - Return Type		:	ArrayList<Transaction>
	 - Throws			:  	CustomerNotFoundException,NoTransactionOccurException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	return the transaction happen between Customer to Main
	 * @param phone 
	 ********************************************************************************************************/
	public ArrayList<Transaction> getDetails(String phone)
			throws NoTransactionOccurException, CustomerNotFoundException {
	
		return iw.retriveAllDetails(phone);
	}

	/*******************************************************************************************************
	 - Function Name	:	depositAmount(String phone, BigDecimal balance) 
	 - Input Parameters	:	String phone, BigDecimal balance
	 - Return Type		:	Customer
	 - Throws			:  	CustomerNotFoundException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	return the Deposit operation
	 ********************************************************************************************************/
	public Customer depositAmount(String phone, BigDecimal balance) throws CustomerNotFoundException {
		Customer cus = iw.showByPhone(phone);
		Wallet wallet = cus.getWallet();
		wallet.setBalance(wallet.getBalance().add(balance));
		cus.setWallet(wallet);

		iw.updateBal(cus,phone);
		Transaction transaction = new Transaction();
		transaction.setSenderPhone(phone);
		transaction.setBalance(balance);
		transaction.getTransType();
		transaction.setTransType(TransactionType.deposit);
		iw.saveTransaction(phone, transaction);
		return cus;
	}

	/*******************************************************************************************************
	 - Function Name	:	withdrawAmount(String phone, BigDecimal balance) 
	 - Input Parameters	:	String phone, BigDecimal balance
	 - Return Type		:	Customer
	 - Throws			:  	CustomerNotFoundException,InsuffiecientBalanceException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	return the withdraw operation
	 ********************************************************************************************************/
	public Customer withdrawAmount(String phone, BigDecimal balance)
			throws CustomerNotFoundException, InsuffiecientBalanceException {
		Customer cus = iw.showByPhone(phone);
		if (cus.getWallet().getBalance().compareTo(balance) < 0) {
			throw new InsuffiecientBalanceException();
		} else {
			Wallet wallet = cus.getWallet();
			wallet.setBalance(wallet.getBalance().subtract(balance));
			cus.setWallet(wallet);
			iw.updateBal(cus,phone);
			Transaction transaction = new Transaction();
			transaction.setSenderPhone(phone);
			transaction.setBalance(balance);
			transaction.setTransType(TransactionType.withdraw);
			iw.saveTransaction(phone, transaction);
			return cus;
		}
	}

	/*******************************************************************************************************
	 - Function Name	:	fundTransfer(String senderPhone, String recieverPhone, BigDecimal balance)
	 - Input Parameters	:	String senderPhone, String recieverPhone, BigDecimal balance
	 - Return Type		:	Customer
	 - Throws			:  	CustomerNotFoundException,InsuffiecientBalanceException
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	return the fund transfer
	 ********************************************************************************************************/
	public Customer fundTransfer(String senderPhone, String recieverPhone, BigDecimal balance)
			throws CustomerNotFoundException, InsuffiecientBalanceException {
		Transaction transaction = new Transaction();
		Customer cus1 = new Customer();
		Customer cus2 = new Customer();
		Wallet wallet1 = new Wallet();
		Wallet wallet2 = new Wallet();
		transaction.setSenderPhone(senderPhone);
		transaction.setRecieverPhone(recieverPhone);
		transaction.setBalance(balance);
		transaction.setTransType(TransactionType.fundtransfer);
		cus1 = iw.showByPhone(senderPhone);
		if (cus1.getWallet().getBalance().compareTo(balance) < 0) {
			throw new InsuffiecientBalanceException();
		}
		wallet1 = cus1.getWallet();
		wallet1.setBalance(wallet1.getBalance().subtract(balance));
		cus1.setWallet(wallet1);
		iw.updateBal(cus1,senderPhone);
		iw.saveTransaction(senderPhone, transaction);
		
		cus2 = iw.showByPhone(recieverPhone);
		wallet2 = cus2.getWallet();
		wallet2.setBalance(wallet2.getBalance().add(balance));
		cus2.setWallet(wallet2);
		iw.updateBal(cus2,recieverPhone);
		return cus1;
	}

	/*******************************************************************************************************
	 - Function Name	:	Validation
	 - Input Parameters	:	String name,String phone
	 - Return Type		:	boolean
	 - Throws			:  	
	 - Author			:	Rahul sharma
	 - Creation Date	:	8/02/2019
	 - Description		:	validate the name and phone number
	 ********************************************************************************************************/
	public boolean isValidName(String name) {
		// TODO Auto-generated method stub
		Pattern namePattern = Pattern.compile("^[A-Za-z ]{3,}$");
		Matcher nameMatcher = namePattern.matcher(name);
		return nameMatcher.matches();
	}

	public boolean isvalidPhone(String phone) {
		Pattern namePattern = Pattern.compile("^[6-9][0-9]{9}$");
		Matcher nameMatcher = namePattern.matcher(phone);
		return nameMatcher.matches();
	}
}
