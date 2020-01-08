package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.daoimpl.BookDAOImpl;
import com.niit.model.Book;
import com.niit.model.User;

@Controller
public class IndexController 
{
	BookDAOImpl bdi=new BookDAOImpl();
	
	@RequestMapping(value= {"","/","/home"})
	public String m1()
	{
		return "index";
	}
	
	@RequestMapping("/loginpage")
	public String m2()
	{
		return "login";
	}
	
	@RequestMapping("/registerpage")
	public String m3(ModelMap map)
	{
		map.addAttribute("user",new User());
		return "register";
	}
	
	@RequestMapping("/addbook")
	public String m4(ModelMap map)
	{
		map.addAttribute("book",new Book());
		return "addbook";
	}
	
	@RequestMapping("/books")
	public String m5(ModelMap map)
	{
		map.addAttribute("books",bdi.displayBooks());
		return "books";
	}
}
