package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luvcode.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
			
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
	
	
//	@Before("forDaoPackage()")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on beforeAddAccountAdvice()");
//	}
	
	
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(public void updateAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n====>>> Executing @Before advice on updateAccount()");
//	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n====>>> Executing @Before advice on beforeAddAccountAdvice()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		
		// display method arguments
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object arg : args) {
			System.out.println(arg);
			
			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
	}
}
