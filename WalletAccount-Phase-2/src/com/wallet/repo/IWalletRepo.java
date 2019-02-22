package com.wallet.repo;



import java.util.ArrayList;
import java.util.List;

import com.wallet.bean.Customer;
import com.wallet.bean.Transaction;
import com.wallet.exception.CustomerNotFoundException;
import com.wallet.exception.DuplicatePhoneException;

public interface IWalletRepo {

	boolean save(Customer cus) throws DuplicatePhoneException;

	Customer showByPhone(String phone) throws CustomerNotFoundException;
	public boolean saveTransaction(String mobileNo, Transaction t) throws CustomerNotFoundException;
	public boolean updateBal(Customer cus, String phone);
	ArrayList<Transaction> retriveAllDetails(String phone);

}