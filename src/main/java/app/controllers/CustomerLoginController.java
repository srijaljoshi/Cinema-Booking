package app.controllers;

import javax.servlet.http.HttpSession;

import app.models.Address;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.models.Customer;
import app.service.ICustomerService;

@Controller
@SessionAttributes("customer1")
public class CustomerLoginController {
	
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}


    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String confirmation(@ModelAttribute("customer") Customer customer, @ModelAttribute("address")
            Address address) {
        int customerId = customerService.save(customer);
        //TODO add an error msg if something went wrong
        if (customerId < 0) {
            System.out.println(">>> Error creating the user!");
        }
        else {
            // If successfully added the user, add the address of the user too
            customerService.addAddress(address, customerId);
        }
        return "registrationConfirmation";
    }



    @RequestMapping(value="/loginForm", method=RequestMethod.POST)
	public String loginConfirmation(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession s) {
		System.out.println("Trying to login with email: " + email + " and password: " + password);
		Customer c = customerService.login(email, password);

		if (c == null) {
			return "redirect:/login";
		} else {
            System.out.println(">>> Logged in successfully as " + email);
			return "home"; // if not logged in
		}
	}
}
