package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  // define private fields for the dependency
  private Coach myCoach;

  @Autowired
  public void setCoach(Coach theCoach) {
    myCoach = theCoach;
  }
  @GetMapping("/")
  public String getWorkingApp() {
    return "Working app";
  }

  @GetMapping("/dailyworkout")
  public String getDailyWorkout() {
    return myCoach.getDailyWorkout();
  }
}
