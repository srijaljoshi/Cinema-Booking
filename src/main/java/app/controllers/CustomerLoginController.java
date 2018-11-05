package app.controllers;

import javax.servlet.http.HttpSession;

import app.models.Address;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import app.models.Customer;
import app.service.ICustomerService;

@Controller
@RequestMapping("/u")
//@SessionAttributes("customer")
public class CustomerLoginController {
	
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginConfirmation(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		System.out.println("Trying to login with email: " + email + " and password: " + password);
		Customer c = customerService.login(email, password);
		session.setAttribute("customer", c);
		if (c == null) {
			return "redirect:/login";
		} else {
            System.out.println(">>> Logged in successfully as " + email);
			return "home"; // if not logged in
		}
	}

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String confirmation(@ModelAttribute("customer") Customer customer, @ModelAttribute("address")Address address) {
    	int customerId = customerService.save(customer);
        if (customerId < 0) {
            System.out.println(">>> Error creating the user!");
        }
        else {
            // If successfully added the user, add the address of the user too
            customerService.addAddress(address, customerId);
        }
        return "registrationConfirmation";    	
    }
    
    

}
