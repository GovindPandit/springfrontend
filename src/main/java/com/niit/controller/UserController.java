package com.niit.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;

@Controller
@RequestMapping("/user")
public class UserController 
{
	UserDAOImpl udi=new UserDAOImpl();
	
	@RequestMapping("/display")
	public String display(ModelMap map)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username="";
		if (principal instanceof UserDetails) 
		{
		  UserDetails user= ((UserDetails)principal);
		  username=user.getUsername();
		}
		
		User u=udi.displayUserByName(username);
		map.addAttribute("user",u);
		return "profile";
	}
	
	@RequestMapping("/delete/{username}")
	public String delete(@PathVariable("username") String username)
	{
		User u=udi.displayUserByName(username);
		udi.deleteUser(u.getUserid());
		return "redirect:/registerpage";
	}
}
