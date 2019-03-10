package com.capgemini.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.payment.beans.Customer;

@Repository
public interface WalletRepository extends CrudRepository<Customer, String> {

}
