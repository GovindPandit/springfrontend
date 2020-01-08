package com.niit.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.daoimpl.BookDAOImpl;
import com.niit.daoimpl.CartDAOImpl;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.Book;
import com.niit.model.CartItem;
import com.niit.model.User;

@Controller
@RequestMapping("/cart")
public class CartController  
{
	BookDAOImpl bdi=new BookDAOImpl();
	UserDAOImpl udi=new UserDAOImpl();
	CartDAOImpl cdi=new CartDAOImpl();
	
	
	@RequestMapping("/addtocart/{i}")
	public String addToCart(@PathVariable("i") int bookid)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username="";
		if (principal instanceof UserDetails) 
		{
		  UserDetails user= ((UserDetails)principal);
		  username=user.getUsername();
		}
		
		CartItem c=new CartItem();
		Book b=bdi.displayBookById(bookid);
		User u=udi.displayUserByName(username);
		
		c.setBook(b);
		c.setUser(u);
		
		cdi.addCartItem(c);
		return "redirect:/books";
		
	}
	
	@RequestMapping("/display")
	public ModelAndView addToCart(ModelAndView mv)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username="";
		if (principal instanceof UserDetails) 
		{
		  UserDetails user= ((UserDetails)principal);
		  username=user.getUsername();
		}
		
		List<CartItem> cartItems=cdi.displayCartItems(username);
		for(CartItem ci:cartItems)
		{
			System.out.println(ci.getCartitemid());
			System.out.println(ci.getBook().getBookname());
			System.out.println(ci.getUser().getUsername());
		}
		
		mv=new ModelAndView("carts","cartitems", cartItems);
		return mv;
	}
	
	@RequestMapping("/remove/{i}")
	public String removeCartItem(@PathVariable("i") int id)
	{
		cdi.deleteCartItem(id);
		return "redirect:/cart/display";
	}
}
