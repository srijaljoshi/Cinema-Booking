package app.controllers;

import app.models.Address;
import app.models.Customer;
import app.service.ICustomerService;
import tools.CustomerTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.SecureRandom;

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
        if (session.getAttribute("customer") != null) // customer session in memory so redirect to root
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
            if (c == null || c.getStatusID() != 1) {
                // failed
            	System.out.println(">>> Customer is null: StatusID => " + c.getStatusID());
            	redirectAttributes.addFlashAttribute("error", "Credetials do not exist or account not activated! (USING RedirectAttributes)");
                return "redirect:login";
            } else {
                session.setAttribute("customer", c);
                System.out.println(">>> Logged in successfully as " + email);
                return "redirect:/"; // After successful login go to root
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Cannot Login. Please try again! (USING RedirectAttributes)");
            System.out.println(">>> " + e.getMessage());
            System.out.println(">>> Error Model: " + redirectAttributes.getFlashAttributes());
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String invalidate(HttpSession session, Model model) {
        if(session.getAttribute("customer") != null) {//if customer session not expired
            System.out.println(">>> Logging out as user " + session.getAttribute("customer"));
            session.invalidate();
            model.addAttribute("logout", "SUCCESS");
            return "home";
        }
        return "redirect:/";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public String confirmation(@ModelAttribute("customer") Customer customer,
                               @ModelAttribute("address") Address address,
                               @RequestParam(name="promo", required = false) String enrollForPromotions,
                               CustomerTools tools) {

        System.out.println(">>> Promo checkbox value = " + enrollForPromotions);
        if(enrollForPromotions == null) {
            customer.setEnrolledForPromotions(0); // did not subscribe
        }
        else if(enrollForPromotions.equals("yes")) {
            System.out.println(">>> Customer subscribed!!!");
            customer.setEnrolledForPromotions(1); // subscribed
        } else {
            System.out.println(">>> Customer DID NOT subscribe!!!");
            customer.setEnrolledForPromotions(0); // did not subscribe
        }


      	customer.setToken(tools.generateToken());
    	customer.setId(customerService.save(customer));
    	
        if (customer.getId() < 0) {
            System.out.println(">>> Error creating the user!");
        } else { 
        	// success
            tools.sendEmail(customer.getEmail(), customer.getToken(), customer.getId());
        }
        return "registrationConfirmation";
    }
    
    /**
     * This function changes the status of user from inactive to active 
     * @param id of the customer
     * @param token
     * @return the sign in page to login
     */
    @RequestMapping(value = "/confirm")
    public String confirmation(@RequestParam(value="token") String token, 
    		@RequestParam(value="id") String id) {
    	Customer customer = customerService.findById(Integer.parseInt(id));
    	System.out.println("customer's token: " + customer.getToken());
    	if(!customer.getToken().equals(token))
    		return "home";
    	customerService.updateStatus(customer);
    	System.out.println("customer status: " + customer.getStatusID());
    	return "login";
    }
    
    @RequestMapping(value="/forgot-password")
    public String forgotPage() {
    	return "forgot-password";
    }
    
    /**
     * Function sends an email to a user to reset password
     * @param token
     * @param id
     * @return
     */
    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public String forgotPassword(@RequestParam(value="email") String email, CustomerTools tools, RedirectAttributes redirectAttributes) {
    	try {
	    	Customer customer = customerService.findByEmail(email);
	    	if(customer.getStatusID() != 1) { 
	    		redirectAttributes.addFlashAttribute("error", "Email does not exist. Go to sign up to register for an account");
	    		return "redirect:forgot-password";
	    	}
	    	customer.setToken(tools.generateToken());
	    	customer.setEmail(email);
	    	customerService.updateToken(customer);
	    	tools.sendPasswordReset(email, customer.getToken(), customer.getId());
    	} catch (Exception e) {
	        redirectAttributes.addFlashAttribute("error", "Make sure that you enter the correct password or go to register an account");
	        return "redirect:forgot-password";
    	}
    	redirectAttributes.addFlashAttribute("error", "A message was sent to your email. Please click on the link from the email to change password :-)");
    	return "redirect:forgot-password";
    }
    
    /**
     * This function checks if a customer's token is valid and redirects 
     * them to change password if token is valid
     * @param customer
     * @return 
     */
    @RequestMapping(value= "/reset-password")
    public String resetPage(@ModelAttribute("customer") Customer customer) {
    	Customer c = customerService.findById(customer.getId());
    	System.out.println("customer c: " + c.getToken());
    	System.out.println("customer entered: " + customer.getToken());
    	if(c.getToken().equals(customer.getToken()) )
    		return "/reset-password";
    	return "";
    }
    
    
    /**
     * This function 
     * @param password
     * @param id
     * @param token
     * @return a page with id and token
     */
    @RequestMapping(value="/reset", method = RequestMethod.POST)
    public String resetPassword(@ModelAttribute("customer") Customer customer) {
    	System.out.println("customer: " + customer.getId() + "   token: " + customer.getToken() + "     " + customer.getPassword());
    	customerService.updatePassword(customer);
    	return "login";
    }
    
}
