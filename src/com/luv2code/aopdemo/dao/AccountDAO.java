package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luvcode.aopdemo.Account;

@Component
public class AccountDAO {
	
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
}
