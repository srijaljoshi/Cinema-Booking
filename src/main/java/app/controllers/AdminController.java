package app.controllers;

import app.models.Admin;
import app.models.Customer;
import app.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/a")
public class AdminController {

    @Autowired
    IAdminService adminService;


    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session) {
        if(session.getAttribute("admin") != null)
            return "admin-dashboard";
        return "403";
    }

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String loginAdmin() {
        return "admin-login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String verifyAdmin(@RequestParam("email") String email, @RequestParam("password") String password,
                              HttpSession session, RedirectAttributes redirectAttributes) {
        System.out.println(">>> ADMIN <<< >>>Trying to login with email: " + email + " and password: " + password);
        try {
            // Will throw error if login is not successful
            Admin admin = adminService.login(email, password);
            if (admin == null) {
                // failed
                redirectAttributes.addFlashAttribute("error", "a==nulll");
                return "admin-login";
            } else {
                session.setAttribute("admin", admin);
                System.out.println(">>> Logged in successfully as " + email);
                return "redirect:dashboard"; // After successful login go to root
            }
        } catch (Exception e) {
            // FAIL to LOGIN. Add error message to the model to display it in the view
            redirectAttributes.addFlashAttribute("error", "Cannot Login. Please try again! (USING RedirectAttributes)");
            System.out.println(">>> " + e.getMessage());
            System.out.println(">>> Error Model: " + redirectAttributes.getFlashAttributes());
            return "redirect:login";
        }
    }

    @RequestMapping("/logout")
    public String logoutAdmin(HttpSession session, Model model) {
        System.out.println(">>> Logging out as user " + session.getAttribute("admin"));
//        session.invalidate();
        session.removeAttribute("admin");
        model.addAttribute("logout", "SUCCESS");
        return "home";
    }


    @RequestMapping("/users")
    public String manageUsers(Model model) {
        List<Customer> customers = adminService.listCustomers();
        model.addAttribute("customers", customers);
        return "manage-users";
    }


}
