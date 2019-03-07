package com.cg.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactiona")
public class Transaction {

	@Id
	@Column(name = "id")
	private long id;
	

	@Column(name = "sender_phone", nullable = false)
	private String senderPhone;

	@Column(name = "reciever_phone")
	private String recieverPhone;

	@Column(name = "balance")
	private BigDecimal balance;
	
	@Column(name = "total_balance")
	private BigDecimal totalBalance;


	@Column(name = "Type")
	@Enumerated(EnumType.STRING)
	private TransactionType type;

	public enum TransactionType {
		withdraw, deposit, fundtransfer
	};
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getTotalBalance() {
		return totalBalance;
	}
	
	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getRecieverPhone() {
		return recieverPhone;
	}

	public void setRecieverPhone(String recieverPhone) {
		this.recieverPhone = recieverPhone;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		if(type==TransactionType.deposit || type==TransactionType.withdraw) {
			return "Transaction Details-----------"+"\n"+"Holder Number:"+senderPhone+"\n"+"Amount:"+balance+"\n"+"Total Balance:"+totalBalance+"\n"+"Transaction Type:"+type+"\n";
		}
		else 
		{
			return "Transaction Details-----------" +"\n"+"SenderPhoneNo.:"+ senderPhone +"\n"+ "RecieverPhoneNo.:" + recieverPhone +"\n"+ "Amount:" + balance
					+"\n"+"Total Balance:"+totalBalance+"\n"+ "Transaction Type:" + type + "\n";
		}
	}

}
