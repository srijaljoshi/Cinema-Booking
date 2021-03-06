package app.controllers;

import app.models.*;
import app.service.IAdminService;
import app.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/a")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private ICustomerService customerService;


    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session) {
        if(session.getAttribute("admin") != null) // if admin session running
            return "admin-dashboard";
        return "403"; // else can't access
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
    public String manageUsers(Model model, HttpSession session) {
        if(session.getAttribute("admin") != null) {
            List<Customer> customers = adminService.listCustomers();
            model.addAttribute("customers", customers);
            return "manage-users";
        }
        return "redirect:login";
    }

    /**
     * Get the movies from the database for the admin to manage
     * @param model
     * @return movies view
     */
    @RequestMapping("/movies")
    public String manageMovies(HttpSession session, Model model) {
        if (session.getAttribute("admin") != null) {
            List<Movie> movies = adminService.listMovies();
            model.addAttribute("movies", movies);
            return "manage-movies";
        }
        // else
        return "redirect:login";
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteMovie(@PathVariable("id") Integer id) {

        int deletedStatus = adminService.deleteMovie(id);
        System.out.println(">>> Deleted with status: " + deletedStatus);
        return "redirect:movies";
    }

    @RequestMapping("/users/{id}/suspend")
    public String suspendUser(@PathVariable("id") int id) {

        adminService.suspend(id);
        return "redirect:/a/users";
    }

    @RequestMapping("/users/{id}/reactivate")
    public String reactivateUser(@PathVariable("id") int id) {

        adminService.reactivateUser(id);
        return "redirect:/a/users";
    }

    @RequestMapping(value = "movies/new", method = RequestMethod.POST)
    public String addNewMovie(@ModelAttribute("movie") Movie m) {
        System.out.println(">>>Got movie from form: " + m.getTitle());
        adminService.saveMovie(m);
        return "redirect:/a/movies";
    }

    @PostMapping("/movies/edit")
    public String updateMovie(@ModelAttribute("movie") Movie m) {
        adminService.updateMovie(m);
        return "redirect:/a/movies";
    }

    @GetMapping("/halls")
    public String manageHalls(Model model, HttpSession session) {
        if (session.getAttribute("admin") != null) {
            model.addAttribute("halls", adminService.listHalls());
            return "manage-halls";
        }
        // else
        return "redirect:login";
    }

    @PostMapping("/halls/new")
    public String newHall(@ModelAttribute("hall") Hall hall) {
        System.out.println(">>>Got hall from form: " + hall.getName());
        adminService.saveHall(hall);
        return "redirect:/a/halls";
    }

    @GetMapping("/promos")
    public String managePromos(Model model, HttpSession session) {
        if (session.getAttribute("admin") != null) {
            model.addAttribute("promos", adminService.listPromos());
            return "manage-promo";
        }
        // else
        return "redirect:login";
    }
    @PostMapping("/promos/new")
    public String newPromo(@ModelAttribute("promo") Promo promo) {
        System.out.println(">>>Got promo from form with discount:  " + promo.getDiscountPercent());
        adminService.savePromo(promo);
        return "redirect:/a/promos";
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String deleteUser(@PathVariable("id") Integer id) {

        int deletedStatus = customerService.deleteUser(id);
        System.out.println(">>> Deleted with status: " + deletedStatus);
        return "redirect:users";
    }

    @DeleteMapping("/promos/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String deletePromo(@PathVariable("id") Integer id) {
        int deletedStatus = adminService.deletePromo(id);
        System.out.println(">>> Deleted promo with status: " + deletedStatus);
        return "redirect:promos";
    }
}