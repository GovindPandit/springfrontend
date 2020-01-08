package com.niit.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.instamojo.wrapper.api.ApiContext;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;
import com.niit.daoimpl.BookDAOImpl;
import com.niit.daoimpl.CartDAOImpl;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.dbconfig.HibernateUtil;
import com.niit.model.Book;
import com.niit.model.CartItem;
import com.niit.model.User;

@Controller
@RequestMapping("/book")
public class BookController 
{
	BookDAOImpl bdi=new BookDAOImpl();
	UserDAOImpl udi=new UserDAOImpl();
	CartDAOImpl cdi=new CartDAOImpl();
	
	@RequestMapping("/add")
	public String add(@ModelAttribute("book") Book book)
	{
		bdi.addBook(book);
		return "redirect:/books";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("searchValue") String searchValue,ModelMap map)
	{
		List<Book> books=bdi.displayBookByName(searchValue);
		map.addAttribute("books",books);
		return "books";
	}
	
	@RequestMapping("/hightolow")
	public String hightolow(ModelMap map)
	{
		List<Book> books=bdi.displayBookByPriceHighToLow();
		map.addAttribute("books",books);
		return "books";
	}
	
	@RequestMapping("lowtohigh")
	public String lowtohigh(ModelMap map)
	{
		List<Book> books=bdi.displayBookByPriceLowToHigh();
		map.addAttribute("books",books);
		return "books";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("b") Book book)
	{
		bdi.updateBook(book);
		return "redirect:/books";
	}
	
	@RequestMapping("/display")
	public String displayBook(@RequestParam("bookid") int bookid,ModelMap map)
	{
		Book b=bdi.displayBookById(bookid);
		map.addAttribute("book",b);
		return "book";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("bookid") int bookid,ModelMap map)
	{
		Book b=bdi.displayBookById(bookid);
		map.addAttribute("b",b);
		return "addbook";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("bookid") int bookid)
	{
		bdi.deleteBook(bookid);
		return "redirect:/books";
	}
	
	@RequestMapping("/buy")
	public void Buy(HttpServletResponse resp)
	{
		   try 
	       {
	           ApiContext context = ApiContext.create("test_BaRDDGvbDNj0ZcudrrjqHnGKHtQqkC6iiDF", "test_5qikY6U2ikPAqCCcje7IZjXDG7yHMKG8nnLnibJXaZHiO8kmW8ayuXFyxGwOzqqc4u0PhrkqG4jfJ3RjXGEefqSdIwnnKfPiCvegi0qmjM62DX97ZHNFIWmqcyV", ApiContext.Mode.TEST);
	           Instamojo api = new InstamojoImpl(context);

	           PaymentOrder order = new PaymentOrder();
	           order.setName("Govind123");
	           order.setEmail("govindpanditniit@gmail.com");
	           order.setPhone("7977518582");
	           order.setCurrency("INR");
	           order.setAmount((double)11);
	           order.setDescription("This is a test transaction.");
	           order.setRedirectUrl("https://niit-gae.appspot.com/displayproducts.jsp");
	           order.setWebhookUrl("https://niit-gae.appspot.com/");
	           order.setTransactionId(UUID.randomUUID().toString());

	           PaymentOrderResponse paymentOrderResponse = api.createPaymentOrder(order);
	           resp.sendRedirect(paymentOrderResponse.getPaymentOptions().getPaymentUrl());
	       }
	       catch (Exception e) 
	       {
	           System.out.println(e);
	       }
	}
	
	
}
