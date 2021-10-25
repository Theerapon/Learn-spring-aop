package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luvcode.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public List<Account> findAccounts(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("No soup for you");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my db work: adding an account with account, boolean");
	}
	
	public void addAccount(Account theccount) {
		System.out.println(getClass() + ": Doing my db work: adding an account with account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": Doing work");
		return true;
	}

	public void sleep() {
		System.out.println(getClass() + ": Doing sleep");
	}

	public String getName() {
		System.out.println(getClass() + ": Doing getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": Doing setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": Doing getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": Doing setServiceCode");
		this.serviceCode = serviceCode;
	}
	
}
