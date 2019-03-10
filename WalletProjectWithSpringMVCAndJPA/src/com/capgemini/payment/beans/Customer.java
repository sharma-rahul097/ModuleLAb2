package com.capgemini.payment.beans;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@Column(name = "mobile")
	@NotNull
	@Pattern(regexp="[7-9][0-9]{9}", message="Please a valid mobile number")
	private String mobileNumber;

	@Column(name = "name")
	@NotNull
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String customerName;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Wallet.class)
	private Wallet wallet;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "Customer Name : " + customerName + "\nMobile Number : " + mobileNumber + "\nWallet : \n" + wallet
				+ "\n";
	}

}
