package com.capgemini.payment.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "Wallet")
public class Wallet {

	@Id
	@Column(name = "walletId")
	private String walletId;

	@Column(name = "balance")
	@Digits(integer = 5, fraction = 2)
	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	@Override
	public String toString() {
		return "Wallet balance : " + balance;
	}

}
