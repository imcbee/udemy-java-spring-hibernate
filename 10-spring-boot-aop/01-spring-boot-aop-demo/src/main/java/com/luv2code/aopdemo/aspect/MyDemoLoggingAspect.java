package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
  @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // this is for any class and any method
  //@Before("execution(public void updateAccount())")
  public void beforeAddAccountAdvice() {

    System.out.println("\n=====>>> executing @Before advice on addAccount()");
    //System.out.println("\n=====>>> executing @Before advice on updateAccount()");
  }
}
