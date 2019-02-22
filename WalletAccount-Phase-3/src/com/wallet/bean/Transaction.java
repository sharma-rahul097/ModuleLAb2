package com.wallet.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Enumerated;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name = "transactionss")
public class Transaction {
	@Id
	@Column(name = "sender_phone",length =10)
	private String senderPhone;
	
	@Column(name = "reciever_phone",length =10)
	private String recieverPhone;
	
	@Column(name = "amount",length =10)
	private BigDecimal balance;
	
	public enum TransactionType{deposit,withdraw,fundtransfer_to,fundTransfer_from};
	
	@Enumerated
	private TransactionType transType;
	
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
	public TransactionType getTransType() {
		return transType;
	}
	public void setTransType(TransactionType transType) {
		this.transType = transType;
	}
	@Override
	public String toString() {
		if(transType==TransactionType.deposit || transType==TransactionType.withdraw) {
			return "Transaction Details-----------"+"\n"+"Holder Number:"+senderPhone+"\n"+"Amount:"+balance+"\n"+"Transaction Type:"+transType+"\n";
		}
		else if(transType==TransactionType.fundtransfer_to)
		{
			return "Transaction Details-----------" +"\n"+"SenderPhoneNo.:"+ senderPhone +"\n"+ "RecieverPhoneNo.:" + recieverPhone +"\n"+ "Amount:" + balance
					+"\n"+ "Transaction Type:" + transType + "\n";
		}
		else
		{
			return "Transaction Details-----------" +"\n"+ "RecieverPhoneNo.:" + recieverPhone +"\n"+"SenderPhoneNo.:"+ senderPhone+"\n"+ "Amount:" + balance
					+"\n"+ "Transaction Type:" + transType + "\n";
		}
	}
	
	
}
