package app.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.models.Booking;
import app.models.Customer;
import app.models.Seat;
import app.models.Showtime;
import app.models.Ticket;
import app.service.ICustomerService;

@Controller
@RequestMapping("/u")
public class CustomerController {
	
	@Autowired
    private ICustomerService customerService;
	
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView getHistory(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//Get the Booking Information for this (booking Id)
		//including the tickets (category)
		//and seats for the tickets (location)
		Customer c = (Customer)session.getAttribute("customer");
		ArrayList<Booking> bookings = (ArrayList<Booking>) customerService.getBooking(Integer.toString(c.getId()));
	
		for(int i = 0; i < bookings.size(); ++i) {
			//Getting tickets
			System.out.println("getting tickets for booking: " + bookings.get(i).getId());
			ArrayList<Ticket> tickets = new ArrayList<Ticket>();
			tickets = (ArrayList<Ticket>) customerService.getTickets(Integer.toString(bookings.get(i).getId()));
			for(int j = 0; j < tickets.size(); ++j) {
				//Getting Seat
				Seat seat = new Seat();
				seat = customerService.getSeat(Integer.toString(tickets.get(j).getSeatId()));
				tickets.get(j).setSeat(seat);
				Showtime showtime = new Showtime();
				showtime = customerService.queryShowtime(Integer.toString(bookings.get(i).getShowTimeId()));
				bookings.get(j).setShowtime(showtime);
			}
			bookings.get(i).setTickets(tickets);
		}
		mv.addObject("bookings", bookings);
		mv.setViewName("history");
		return mv;
	}
	
	
}
