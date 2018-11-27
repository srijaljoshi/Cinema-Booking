package app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.service.ICustomerService;

@Controller
@RequestMapping("/u")
public class CustomerController {
	
	@Autowired
    private ICustomerService customerService;
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView getHistory(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	
}
