package com.luvcode.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account myAccount = new Account();
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
		
		context.close();
		
	}
}
