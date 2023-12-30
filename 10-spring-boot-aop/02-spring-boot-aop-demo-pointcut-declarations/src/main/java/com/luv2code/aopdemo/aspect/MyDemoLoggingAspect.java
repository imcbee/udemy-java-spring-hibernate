package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
  // this is where we add all of our related advices for logging

  // let's start with an @Before advice

//  @Before("execution(public void addAccount())")
//  //@Before("execution(public void updateAccount())")
//  public void beforeAddAccountAdvice() {
//
//    System.out.println("\n=====>>> executing @Before advice on addAccount()");
//    //System.out.println("\n=====>>> executing @Before advice on updateAccount()");
//  }

//!  @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//!  //@Before("execution(public void updateAccount())")
//!  public void beforeAddAccountAdvice() {
//!
//!    System.out.println("\n=====>>> executing @Before advice on addAccount()");
//!    //System.out.println("\n=====>>> executing @Before advice on updateAccount()");
//!  }

  //@Before("execution(public void add*())")
  //@Before("execution(void add*())")
  //@Before("execution(* add*(..))") // we need the fully qualified class name, .. for any params
  //@Before("execution(public void updateAccount())")  // this wrong if no method is here

  @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
  private void forDaoPackage() {

  }

  // create a pointcut for getter methods
  @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
  private void getter() {

  }

  // create a pointcut for setter methods
  @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
  private void setter() {

  }

  // create pointcut: include package ... exclude getter/setter
  @Pointcut("forDaoPackage() && !(getter() || setter())")
  private void forDaoPackageNoGetterSetter() {

  }

  @Before("forDaoPackageNoGetterSetter()") // this is for any class and any method
  public void beforeAddAccountAdvice() {
    System.out.println("\n=====>>> executing @Before advice on addAccount()");
    //System.out.println("\n=====>>> executing @Before advice on updateAccount()");
  }

  @Before("forDaoPackageNoGetterSetter()")
  public void performApiAnalytics() {
    System.out.println("\n=====>>> Performing API analytics");
  }
}
