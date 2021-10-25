package com.luvcode.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		
		boolean getTest = false;
		if (getTest) {
			test(theAccountDAO, theMembershipDAO);
		} else {
			
			try {
				boolean tripWire = true;
				List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);
				System.out.println("\nMain Program: AfterReturningDemoApp");
				System.out.println(theAccounts);
				
			} catch (Exception exc) {
				System.out.println("\n\nMain program ... caught exception: " + exc);
			}
			
			
			
		}
		
		
		
		context.close();
		
	}

	private static void test(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("Fakie");
		myAccount.setLevel("Platium");
		
		theAccountDAO.addAccount(myAccount);
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		theAccountDAO.sleep();
		theAccountDAO.setName("fakie");
		theAccountDAO.getName();
		theAccountDAO.setServiceCode("Code 7832");
		theAccountDAO.getServiceCode();
		
		theMembershipDAO.addSillyMemner();
		theMembershipDAO.addAccount();
	}
}
