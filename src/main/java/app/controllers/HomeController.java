package app.controllers;

import app.models.Address;
import app.models.Customer;
import app.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/registration")
	public String register() {
		return "registration";
	}
	
	@RequestMapping(value="registrationForm", method=RequestMethod.POST)
	public String confirmation(@ModelAttribute("customer") Customer customer, @ModelAttribute("address")
	Address address){
		int customerId = customerService.save(customer);
		//TODO add an error msg if something went wrong
		if(customerId < 0)
			System.out.println("ewor");
		customerService.addAddress(address, customerId);
		return "registrationConfirmation";
	}
	
	
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/users";
	}
	
	@RequestMapping("/users") // display all users
	public String listAllUsers(Model model) {
		List<Customer> customers = customerService.listUsers();
		model.addAttribute("customers", customers);
		System.out.println(">>> Extracted the following users: " + customers);
		return "customers";
	}
	
	@RequestMapping("/user/{id}")
	public @ResponseBody String viewUser(@PathVariable("id") int id) {
		System.out.println(">>> Id from view: " + id);
		return customerService.findById(id).toString();
	}
	
	@RequestMapping(value="/users/{id}/delete", method=RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id) {
		customerService.removeById(id);
		return "redirect:/users";
	}

}
