package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
//	@Before("execution(public void addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(public void add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(boolean add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount() return boolean");
//	}
	
//	@Before("execution(* add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
	
//	@Before("execution(* add*(com.luvcode.aopdemo.Account))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(* add*(com.luvcode.aopdemo.Account, ..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(* add*(..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
	}
	
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(public void updateAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on updateAccount()");
//	}
}
