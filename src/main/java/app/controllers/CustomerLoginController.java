package app.controllers;

import app.models.Address;
import app.models.Customer;
import app.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/u")
//@SessionAttributes("customer")
public class CustomerLoginController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        if (session.getAttribute("customer") != null) // customre session in memory so redirect to root
            return "redirect:";
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginConfirmation(@RequestParam("email") String email, @RequestParam("password") String password,
                                    HttpSession session, RedirectAttributes redirectAttributes) {
        System.out.println("Trying to login with email: " + email + " and password: " + password);
        try {
            // Will throw error if login is not successful
            Customer c = customerService.login(email, password);
            if (c == null) {
                // failed
               redirectAttributes.addFlashAttribute("error", "c==nulll");
                return "login";
            } else {
                session.setAttribute("customer", c);
                System.out.println(">>> Logged in successfully as " + email);
                return "redirect:/"; // After successful login go to root
            }
        } catch (Exception e) {
            // FAIL to LOGIN. Add error message to the model to display it in the view
//            model.addAttribute("error", "Incorrect credentials. Please try again!");
            redirectAttributes.addFlashAttribute("error", "Cannot Login. Please try again! (USING RedirectAttributes)");
            System.out.println(">>> " + e.getMessage());
            System.out.println(">>> Error Model: " + redirectAttributes.getFlashAttributes());
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String invalidate(HttpSession session, Model model) {
        System.out.println(">>> Logging out as user " + session.getAttribute("customer"));
        session.invalidate();
        model.addAttribute("logout", "SUCCESS");
        return "home";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String confirmation(@ModelAttribute("customer") Customer customer, @ModelAttribute("address") Address address) {
        int customerId = customerService.save(customer);
        System.out.println(address.getState());
        if (customerId < 0) {
            System.out.println(">>> Error creating the user!");
        } else {
            // If successfully added the user, add the address of the user too
            customerService.addAddress(address, customerId);
        }
        return "registrationConfirmation";
    }

}
