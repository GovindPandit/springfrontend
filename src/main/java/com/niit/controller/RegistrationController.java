package com.niit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;

@Controller
@RequestMapping("/user")
public class RegistrationController 
{
	
	/*
	  @RequestMapping("/add")
	  public void storeUser(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("password") String password)
	  {
		
	  }
	*/
	
	UserDAOImpl udi=new UserDAOImpl();
	
	@RequestMapping("/add")
	public String storeUser(@Valid @ModelAttribute("user") User user,BindingResult result)
	{
		if(!result.hasErrors())
		{
			udi.addUser(user);
			return "redirect:/loginpage";
		}
		else
		{
			return "register";
		}
		
	}
}
