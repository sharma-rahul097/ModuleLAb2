package com.capgemini.payment.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.payment.beans.Customer;
import com.capgemini.payment.beans.Wallet;
import com.capgemini.payment.exception.ConnectionLostException;
import com.capgemini.payment.exception.InsufficientBalanceException;
import com.capgemini.payment.exception.InvalidMobileNumberException;
import com.capgemini.payment.repository.WalletRepository;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Override
	public Customer createAccount(Customer customer) throws InvalidMobileNumberException {
		Customer findCustomer = walletRepository.findOne(customer.getMobileNumber());
		if (findCustomer == null) {
			Customer newCustomer = createCustomer(customer.getCustomerName(), customer.getMobileNumber(),
					customer.getWallet().getBalance());
			if (walletRepository.save(newCustomer) != null) {
				return walletRepository.findOne(customer.getMobileNumber());
			}
		}
		throw new InvalidMobileNumberException("Mobile number already in use");
	}

	@Override
	public Customer showBalance(String mobileNumber) throws InvalidMobileNumberException {
		Customer customer = walletRepository.findOne(mobileNumber);
		if (customer == null) {
			throw new InvalidMobileNumberException("This number is not in use for this application");
		}
		return customer;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNumber, String targetMobileNumber, BigDecimal amount)
			throws InvalidMobileNumberException, InsufficientBalanceException, ConnectionLostException {
		Customer sourceCustomer = walletRepository.findOne(sourceMobileNumber);
		Customer targetCustomer = walletRepository.findOne(targetMobileNumber);

		if (sourceCustomer == null) {
			throw new InvalidMobileNumberException("Your number is not in use for this application");
		}
		if (targetCustomer == null) {
			throw new InvalidMobileNumberException("Payment Receiver's number is not in use for this application");
		}
		if (sourceCustomer.getWallet().getBalance().compareTo(amount) < 0) {
			throw new InsufficientBalanceException();
		}
		sourceCustomer.getWallet().setBalance(sourceCustomer.getWallet().getBalance().subtract(amount));
		targetCustomer.getWallet().setBalance(targetCustomer.getWallet().getBalance().add(amount));

		if (walletRepository.save(sourceCustomer) != null && walletRepository.save(targetCustomer) != null) {
			return walletRepository.findOne(sourceMobileNumber);
		}
		throw new ConnectionLostException();
	}

	@Override
	public Customer depositAmount(String mobileNumber, BigDecimal amount)
			throws InvalidMobileNumberException, ConnectionLostException {
		Customer customer = walletRepository.findOne(mobileNumber);
		if (customer == null) {
			throw new InvalidMobileNumberException("This number is not in use for this application");
		}
		customer.getWallet().setBalance(customer.getWallet().getBalance().add(amount));
		if (walletRepository.save(customer) != null) {
			return walletRepository.findOne(mobileNumber);
		}
		throw new ConnectionLostException();
	}

	@Override
	public Customer withdrawAmount(String mobileNumber, BigDecimal amount)
			throws InvalidMobileNumberException, InsufficientBalanceException, ConnectionLostException {
		Customer customer = walletRepository.findOne(mobileNumber);
		if (customer == null) {
			throw new InvalidMobileNumberException("This number is not in use for this application");
		}
		if (customer.getWallet().getBalance().compareTo(amount) < 0) {
			throw new InsufficientBalanceException();
		}
		customer.getWallet().setBalance(customer.getWallet().getBalance().subtract(amount));
		if (walletRepository.save(customer) != null) {
			return walletRepository.findOne(mobileNumber);
		}
		throw new ConnectionLostException();
	}

	private Customer createCustomer(String customerName, String mobileNumber, BigDecimal amount) {
		Customer customer = new Customer();
		Wallet wallet = new Wallet();
		wallet.setWalletId(mobileNumber);
		wallet.setBalance(amount);
		customer.setCustomerName(customerName);
		customer.setMobileNumber(mobileNumber);
		customer.setWallet(wallet);
		return customer;
	}

}
