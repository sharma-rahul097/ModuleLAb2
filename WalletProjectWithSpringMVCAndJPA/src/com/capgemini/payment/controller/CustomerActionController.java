package com.capgemini.payment.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.payment.beans.Customer;
import com.capgemini.payment.exception.ConnectionLostException;
import com.capgemini.payment.exception.InsufficientBalanceException;
import com.capgemini.payment.exception.InvalidMobileNumberException;
import com.capgemini.payment.service.WalletService;

@Controller
public class CustomerActionController {
	@Autowired
	private WalletService walletService;
	
	@RequestMapping(value = "/")
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/signin")
	public String getSigninPage() {
		return "signin";
	}

	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}

	@RequestMapping(value = "/registerCustomer")
	public ModelAndView registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("signin");
		try {
			customer = walletService.createAccount(customer);
		} catch (InvalidMobileNumberException e) {
			return new ModelAndView("error","message",e.getMessage());
		}
		return new ModelAndView("welcomepage", "customer", customer);
	}

	@RequestMapping(value = "/viewwallet")
	public ModelAndView viewCustomer(@RequestParam("mobileNumber") String mobileNumber) {
		Customer customer = null;
		try {
			customer = walletService.showBalance(mobileNumber);
		} catch (InvalidMobileNumberException e) {
			return new ModelAndView("error","message",e.getMessage());
		}
		return new ModelAndView("viewwallet", "customer", customer);
	}

	@RequestMapping(value = "/deposit")
	public String deposit() {
		return "deposit";
	}

	@RequestMapping(value = "/depositAmount", method = RequestMethod.GET)
	public ModelAndView deposit(HttpServletRequest request) {
		Customer customer = null;
		String mobileNumber = request.getParameter("mobileNumber");
		String balance = request.getParameter("balance");
		try {
			customer = walletService.depositAmount(mobileNumber, new BigDecimal(balance));
		} catch (InvalidMobileNumberException | ConnectionLostException e) {
			return new ModelAndView("error","message",e.getMessage());
		}
		return new ModelAndView("depositsucess", "customer", customer);
	}

	@RequestMapping(value = "/withdraw")
	public String getwithdraw() {
		return "withdraw";
	}

	@RequestMapping(value = "/withdrawAmount", method = RequestMethod.GET)
	public ModelAndView withdraw(HttpServletRequest request) {
		Customer customer = null;
		String mob = request.getParameter("mobileNumber");
		String bal = request.getParameter("balance");
		try {
			customer = walletService.withdrawAmount(mob, new BigDecimal(bal));
		} catch (InvalidMobileNumberException | InsufficientBalanceException | ConnectionLostException e) {
			return new ModelAndView("error","message",e.getMessage());
		}
		return new ModelAndView("withdrawsucess", "customer", customer);
	}

	@RequestMapping(value = "/fundTransfer")
	public String getFundTransfer() {
		return "fundtransfer";
	}

	@RequestMapping(value = "/fundTransfered", method = RequestMethod.GET)
	public ModelAndView fundTransfer(HttpServletRequest request) {
		Customer customer = null;
		String sourceMobileNumber = request.getParameter("sourceMobileNumber");
		String targetMobileNumber = request.getParameter("targetMobileNumber");
		String amount = request.getParameter("balance");
		try {
			customer = walletService.fundTransfer(sourceMobileNumber, targetMobileNumber, new BigDecimal(amount));
		} catch (InvalidMobileNumberException | InsufficientBalanceException | ConnectionLostException e) {
			return new ModelAndView("error","message",e.getMessage());
		}
		return new ModelAndView("fundstransfered", "customer", customer);
	}

}
