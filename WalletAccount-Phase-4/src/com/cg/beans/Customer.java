package com.cg.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Customera")
public class Customer {

	@Id
	@Column(name = "mobile_number", nullable=false)
	private String phone;
	
	@Column(name = "name")
	private String name;
	
	@Embedded
	private Wallet wallet;

	@OneToMany(targetEntity=Transaction.class)
	private List<Transaction> transactionList;

	public String getMobileNumber() {
		return phone;
	}

	public void setMobileNumber(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	
		
}
