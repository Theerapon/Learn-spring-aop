package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private Logger myLogger = Logger.getLogger(getClass().getName());		
	
//	@Before("execution(public void addAccount())")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(public void add*())")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(boolean add*())")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount() return boolean");
//	}
	
//	@Before("execution(* add*())")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
//	}
	
	
//	@Before("execution(* add*(com.luvcode.aopdemo.Account))")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(* add*(com.luvcode.aopdemo.Account, ..))")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(* add*(..))")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
//	}
	
	
//	@Before("forDaoPackage()")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on beforeAddAccountAdvice()");
//	}
	
	
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(public void updateAccount())")
//	public void beforeAddAccountAdvice() {
//		myLogger.info("\n====>>> Executing @Before advice on updateAccount()");
//	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Executing @Before advice on beforeAddAccountAdvice()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);
		
		
		// display method arguments
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object arg : args) {
			myLogger.info(arg.toString());
			
			if (arg instanceof Account) {
				Account account = (Account) arg;
				myLogger.info("account name: " + account.getName());
				myLogger.info("account level: " + account.getLevel());
			}
		}
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);
		
		myLogger.info("\n=====>>> result is: " + result);
		
		// post-process the data
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n=====>>> result is: " + result);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterThrowingFindAccountsAdvice on method: " + method);
		myLogger.info("\n=====>>> The exception is: " + theExc);
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterFinallyFindAccountsAdvice on method: " + method);
	}
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
			String method = theProceedingJoinPoint.getSignature().toShortString();
			myLogger.info("\n=====>>> Executing @AroundGetFortune on method: " + method);
			
			long begin = System.currentTimeMillis();
			
			Object result = null;
			
			try {
				result = theProceedingJoinPoint.proceed();
			} catch (Exception e) {
				myLogger.warning(e.getMessage());
				
				throw e;
			}
			
			long end = System.currentTimeMillis();
			long duration = end - begin;
			myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
		return result;
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
		
	}
 }
