package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
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



  @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()") // this is for any class and any method
  public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
    System.out.println("\n=====>>> executing @Before advice on addAccount()");
    //System.out.println("\n=====>>> executing @Before advice on updateAccount()");

    // display the method signature
    MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

    // display method arguments
    System.out.println("Method: " + methodSig);

    // get args
    Object[] args = theJoinPoint.getArgs();

    // loop thru args
    for (Object tempArg: args) {
      System.out.println(tempArg);

      if (tempArg instanceof Account) {
        // downcast and print Account specific stuff
        Account theAccount = (Account) tempArg;

        System.out.println("account name: " + theAccount.getName());
        System.out.println("account level: " + theAccount.getLevel());
      }
    }
  }

  // add a new advice for @AfterReturning on the findAccounts method
  @AfterReturning(
    pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
    returning = "result"
  )
  public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
    // print out which method we are advising on
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("\n=====>>> Executing @AfterREturning on method: " + method);

    // print out the results of the method call
    System.out.println("\n=====>>> result is: " + result);
  }

}
