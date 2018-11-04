package app.controllers;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import app.models.Customer;
import app.service.ICustomerService;

@Controller
//@SessionAttributes("customer")
public class CustomerLoginController {
	
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginConfirmation(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		System.out.println("Trying to login with email: " + email + " and password: " + password);
		Customer c = customerService.login(email, password);
		session.setAttribute("customer", c);
		if(c == null)
			return "redirect:/login";
		else
			return "home";
	}
}
