package com.cg.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.beans.Customer;
import com.cg.beans.Transaction;
import com.cg.beans.Wallet;
import com.cg.beans.Transaction.TransactionType;
import com.cg.exception.DuplicateIdentityException;
import com.cg.exception.IdNotExistException;
import com.cg.exception.InsufficientWalletBalanceException;
import com.cg.exception.ReceiverIdNotExistException;
import com.cg.exception.SenderIdNotExistException;
import com.cg.repo.WalletRepo;

public class WalletServiceImplementation implements WalletService {
	
	private WalletRepo walletRepo;
	
	public WalletServiceImplementation(WalletRepo walletRepo) {
		
		super();
		this.walletRepo = walletRepo;
	}

	
	/* (non-Javadoc)
	 * @see com.cg.service.WalletService#createAccount(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Customer createAccount(String mobileNumber, String name, BigDecimal initialBalance) throws DuplicateIdentityException {
		
		Wallet wallet = new Wallet();
		wallet.setBalance(initialBalance);
		
		Customer customer = new Customer();
		customer.setMobileNumber(mobileNumber);
		customer.setName(name);
		customer.setWallet(wallet);
		
		List<Transaction> transactionList = new ArrayList<>();
		Transaction t = new Transaction();
		t.setId((long) (Math.random()*1000));
		t.setSenderPhone(mobileNumber);
		t.setBalance(initialBalance);
		t.setTotalBalance(customer.getWallet().getBalance());
		t.setType(TransactionType.deposit);
		transactionList.add(t);
		
		customer.setTransactionList(transactionList);
		
		if(walletRepo.save(customer)) {
			return walletRepo.search(mobileNumber);
		}
		else {
			throw new DuplicateIdentityException();
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.cg.service.WalletService#showBalance(java.lang.String)
	 */
	@Override
	public Customer showBalance(String mobileNumber) throws IdNotExistException {
		
		Customer customer = walletRepo.search(mobileNumber);
		if(customer == null) {
			
			throw new IdNotExistException();
		}
		else {
			
			return customer;
		}
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.cg.service.WalletService#depositAmount(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Customer depositAmount(String mobileNumber, BigDecimal depositAmountValue) throws IdNotExistException {
		
		Customer customer = walletRepo.search(mobileNumber);
		
		if(customer != null) {
			
			customer.getWallet().setBalance(customer.getWallet().getBalance().add(depositAmountValue));
			
			Transaction t = new Transaction();
			t.setId((long) (Math.random()*1000));
			t.setSenderPhone(mobileNumber);
			t.setBalance(depositAmountValue);
			t.setType(TransactionType.deposit);
			t.setTotalBalance(customer.getWallet().getBalance());
			customer.getTransactionList().add(t);
			
			walletRepo.updateAccount(customer);
			
			return walletRepo.search(mobileNumber);
		}
		else {
			
			throw new IdNotExistException();
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.cg.service.WalletService#withdrawAmount(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Customer withdrawAmount(String mobileNumber, BigDecimal withdrawAmountValue) throws IdNotExistException, InsufficientWalletBalanceException {
		
		Customer customer = walletRepo.search(mobileNumber);
		if(customer == null) {
			throw new IdNotExistException();
		}
		
		if(customer != null && customer.getWallet().getBalance().compareTo(withdrawAmountValue) >= 0) {
			
			customer.getWallet().setBalance(customer.getWallet().getBalance().subtract(withdrawAmountValue));
			
			Transaction t = new Transaction();
			t.setId((long) (Math.random()*1000));
			t.setSenderPhone(mobileNumber);
			t.setBalance(withdrawAmountValue);
			t.setTotalBalance(customer.getWallet().getBalance());
			t.setType(TransactionType.withdraw);
			customer.getTransactionList().add(t);
			
			walletRepo.updateAccount(customer);
			return walletRepo.search(mobileNumber);
		}
		else {
			
			throw new InsufficientWalletBalanceException();
		}
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.cg.service.WalletService#fundTransfer(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Customer[] fundTransfer(String senderAccount, String receiverAccount, BigDecimal amount) throws IdNotExistException, InsufficientWalletBalanceException {
		
		Customer sender = walletRepo.search(senderAccount);
		Customer receiver = walletRepo.search(receiverAccount);
		
		if(sender == null) {
			throw new SenderIdNotExistException();
		}
		
		if(receiver == null) {
			throw new ReceiverIdNotExistException();
		}
		
		else if(sender.getWallet().getBalance().compareTo(amount) >= 0) {
			
			sender.getWallet().setBalance(sender.getWallet().getBalance().subtract(amount));
			Transaction senderT = new Transaction();
			senderT.setId((long) (Math.random()*1000));
			senderT.setSenderPhone(senderAccount);
			senderT.setBalance(amount);
			senderT.setTotalBalance(sender.getWallet().getBalance());
			senderT.setType(TransactionType.fundtransfer);
			sender.getTransactionList().add(senderT);
			
			receiver.getWallet().setBalance(receiver.getWallet().getBalance().add(amount));
			Transaction receiverT = new Transaction();
			receiverT.setId((long) (Math.random()*1000));
			receiverT.setRecieverPhone(receiverAccount);
			receiverT.setBalance(amount);
			receiverT.setTotalBalance(receiver.getWallet().getBalance());
			receiverT.setType(TransactionType.fundtransfer);
			receiver.getTransactionList().add(receiverT);
			
			walletRepo.updateAccount(sender, receiver);
			return new Customer[] {walletRepo.search(senderAccount), walletRepo.search(receiverAccount)};
		}
		
		else {
			
			throw new InsufficientWalletBalanceException();
		}
	}
	
	@Override
	public List<Transaction> getTransaction(String mobileNumber) throws IdNotExistException {
		
		List<Transaction> list = walletRepo.getTransaction(mobileNumber);
		if(list != null) {
			return list;
		}
		throw new IdNotExistException();
	}

	@Override
	public boolean closeEntityManager() {
		walletRepo.closeEntityManager();
		return true;
	}

	
}



