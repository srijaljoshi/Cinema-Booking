package app.controllers;

import app.models.Customer;
import app.service.ICustomerService;
import app.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
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
    public @ResponseBody
    String viewUser(@PathVariable("id") int id) {
        System.out.println(">>> Id from view: " + id);
        return customerService.findById(id).toString();
    }

    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        customerService.removeById(id);
        return "redirect:/users";
    }


    // FOR RANDOM TESTS
    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }


}
