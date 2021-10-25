package com.luvcode.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class MainDemoApp {
	
	private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		
//		textAfter(theAccountDAO, theMembershipDAO);
		
		
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		boolean tripWire = true;
		String data =  theFortuneService.getFortune(tripWire);
		myLogger.info("\nMy fortune is: " + data);
		myLogger.info("Finished");
		
		context.close();
		
	}

	private static void textAfter(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		boolean getTest = false;
		if (getTest) {
			test(theAccountDAO, theMembershipDAO);
		} else {
			
			try {
				boolean tripWire = true;
				List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);
				myLogger.info("\nMain Program: AfterReturningDemoApp");
				System.out.println(theAccounts);
				
			} catch (Exception exc) {
				myLogger.info("\n\nMain program ... caught exception: " + exc);
			}
			
			
			
		}
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
