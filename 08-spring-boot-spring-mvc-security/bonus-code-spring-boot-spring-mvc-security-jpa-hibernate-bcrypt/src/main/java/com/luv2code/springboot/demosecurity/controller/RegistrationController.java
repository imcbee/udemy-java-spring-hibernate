package com.luv2code.springboot.demosecurity.controller;

import com.luv2code.springboot.demosecurity.entity.User;
import com.luv2code.springboot.demosecurity.entity.WebUser;
import com.luv2code.springboot.demosecurity.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

  private UserService userService;

  private Logger logger = Logger.getLogger(getClass().getName());

  public RegistrationController(UserService theUserService) {
    this.userService = theUserService;
  }

  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  @GetMapping("/showRegistrationForm")
  public String showMyLoginPage(Model theModel) {
    theModel.addAttribute("webUser", new WebUser());
    return "register/registration-form";
  }

  @GetMapping("/processRegistrationForm")
  public String processRegistrationForm(
    @Valid @ModelAttribute("webUser") WebUser theWebUser,
    BindingResult theBindingResult,
    HttpSession session,
    Model theModel
  ) {
    String userName = theWebUser.getUserName();
    logger.info("Processing registration form for: " + userName);

    //form validation
    if (theBindingResult.hasErrors()) {
      return "register/registration-form";
    }

    // check the database if use aleady exists
    User existing = userService.findByUserName(userName);
    if (existing != null) {
      theModel.addAttribute("webUser", new WebUser());
      theModel.addAttribute("registrationError", "User name already exists.");

      return "register/registration-form";
    }

    // create user account and store in the database
    userService.save(theWebUser);

    logger.info("Successfully created user: " + userName);

    // place user in the web http session for later use
    session.setAttribute("user", theWebUser);


    return "register/registration-confirmation";
  }

}
