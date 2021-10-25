package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luvcode.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
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
