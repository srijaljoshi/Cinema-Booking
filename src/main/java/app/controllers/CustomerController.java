package app.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping(value = "/order-history", method = RequestMethod.GET)
	public ModelAndView getHistory(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Booking> bookings;
		//if(session.getAttribute("bookingsHistory") == null) {
			//Get the Booking Information for this (booking Id)
			//including the tickets (category)
			//and seats for the tickets (location)
			Customer c = (Customer)session.getAttribute("customer");
			bookings = (ArrayList<Booking>) customerService.getBooking(Integer.toString(c.getId()));
		
			for(int i = 0; i < bookings.size(); ++i) {
				//Getting tickets
				System.out.println("getting tickets for booking: " + bookings.get(i).getId());
				ArrayList<Ticket> tickets = new ArrayList<Ticket>();
				String b = Integer.toString(bookings.get(i).getId());
				tickets = (ArrayList<Ticket>) customerService.getTickets(Integer.toString(bookings.get(i).getId()), b);
				for(int j = 0; j < tickets.size(); ++j) {
					//Getting Seat
					Seat seat = new Seat();
					seat = customerService.getSeat(Integer.toString(tickets.get(j).getSeatId()));
					tickets.get(j).setSeat(seat);
					if(tickets.get(j).getCategory() == 1)
						tickets.get(j).setType("child");
					else if(tickets.get(j).getCategory() == 2)
						tickets.get(j).setType("adult");
					else if(tickets.get(j).getCategory() == 3)
						tickets.get(j).setType("senior");
					Showtime s = bookings.get(i).getShowtime();
					System.out.println("got showtime ");
				}
				Showtime showtime = new Showtime();
				showtime = customerService.queryShowtime(Integer.toString(bookings.get(i).getShowTimeId()));
				bookings.get(i).setShowtime(showtime);
				
				bookings.get(i).setTickets(tickets);
			}
			session.setAttribute("bookingsHistory", bookings);
		//}//if no history session for bookings
		
		//bookings = (ArrayList<Booking>) session.getAttribute("bookingsHistory");

		mv.addObject("bookings", bookings);
		mv.setViewName("order-history");
		return mv;
		
	}
	
	@RequestMapping(value = "/refund", method = RequestMethod.GET)
	public String removeBooking(HttpSession session, @RequestParam(value="bookingId")String bookingId) {
		ArrayList<Booking> bookings = (ArrayList<Booking>) session.getAttribute("bookingsHistory");
		//open up the seats that became available
		//remove the tickets from DB
		//remove the booking from the DB
		System.out.println(">>>>>>>>>>>>canceling booking");
		int removeBookingId = Integer.parseInt(bookingId);
		System.out.println("booking size: " + bookings.size());
		for(int i = 0; i < bookings.size(); ++i) {
			System.out.println("looking for booking");
			if(bookings.get(i).getId() == removeBookingId) {
				System.out.println("found the booking and removing the tickets for this");
				//open up the seats for the specified tickets:
				for(int j = 0; j < bookings.get(i).getTickets().size(); ++j) {
					//opening up the seats from the ticket using showtimeId and seatId
					int showtimeIdInt = bookings.get(i).getShowTimeId();
					String showtimeId = Integer.toString(showtimeIdInt);
					String seatId = Integer.toString(bookings.get(i).getTickets().get(j).getSeatId());
					//updating SeatShowtime in DB for seat taken from 1 (take) to 0 (open)
					customerService.updateSeatStatus(showtimeId, seatId);
					//okay to remove ticket using the ticketId
					String ticketId = Integer.toString(bookings.get(i).getTickets().get(j).getId());
					customerService.removeTicket(ticketId);
				}
				customerService.removeBooking(bookingId);
				bookings.remove(i);
			}//if
			session.setAttribute("bookings", bookings);
		}
		return "redirect:/history";
	}
	
	@RequestMapping(value = "/edit-profile", method = RequestMethod.GET)
	public ModelAndView editProfile(HttpSession session) {
		System.out.println("<<<<<<<<<<<<<<<<<< editing profile");
		ModelAndView mv = new ModelAndView();
		//get the users data and enter it in the input boxes:
		//I will use session to get the user's data:
		Customer c = (Customer) session.getAttribute("customer");
		Customer customer = customerService.findById(c.getId());
		customer.setPassword(c.getPassword());
		System.out.println("customer first name: "  + customer.getPassword());
		mv.addObject("customer", customer);
		mv.setViewName("edit-profile");
		return mv;
	}
	
	@RequestMapping(value = "/change-first-name", method = RequestMethod.GET)
	public String changeFirstName(HttpSession session, @RequestParam(value="first")String firstName){
		firstName = firstName.replaceAll("\"", "");
		System.out.println("<<<<<<<< Changing first name");
		//change the first-name in DB:
		Customer customer = (Customer)session.getAttribute("customer");
		System.out.println(customer.getEmail() + "; " + customer.getLastName() + "; " + customer.getEnrolledForPromotions() + " " + customer.getLastName());
		System.out.println("firstName: "  + firstName);
		customer.setFirstName(firstName);
		System.out.println("customer first name: " + customer.getPassword());
		customerService.updateFirstName(customer);
		session.setAttribute("customer", customer);
		return "/edit-profile";
	}
	
	@RequestMapping(value = "/change-last-name", method = RequestMethod.GET)
	public String changeLastName(HttpSession session, @RequestParam(value="last")String lastName){
		lastName = lastName.replaceAll("\"", "");
		System.out.println("<<<<<<<< Changing last name");
		//change the first-name in DB:
		Customer customer = (Customer)session.getAttribute("customer");
		System.out.println(customer.getEmail() + "; " + customer.getLastName() + "; " + customer.getEnrolledForPromotions() + " " + customer.getLastName());
		System.out.println("firstName: "  + lastName);
		customer.setLastName(lastName);
		System.out.println("customer first name: " + customer.getPassword());
		customerService.updateLastName(customer);
		session.setAttribute("customer", customer);
		return "/edit-profile";
	}
	
	@RequestMapping(value = "/change-email", method = RequestMethod.GET)
	public String changeEmail(HttpSession session, @RequestParam(value="email")String email){
		email = email.replaceAll("\"", "");
		System.out.println("<<<<<<<< Changing email");
		//change the first-name in DB:
		Customer customer = (Customer)session.getAttribute("customer");
		System.out.println(customer.getEmail() + "; " + customer.getLastName() + "; " + customer.getEnrolledForPromotions() + " " + customer.getLastName());
		System.out.println("email: "  + email);
		customer.setEmail(email);
		System.out.println("customer first name: " + customer.getPassword());
		customerService.updateEmail(customer);
		session.setAttribute("customer", customer);
		return "/edit-profile";
	}
	
	@RequestMapping(value = "/change-password", method = RequestMethod.GET)
	public String changePassword(HttpSession session, @RequestParam(value="password")String password){
		password = password.replaceAll("\"", "");
		System.out.println("<<<<<<<< Changing email");
		//change the first-name in DB:
		Customer customer = (Customer)session.getAttribute("customer");
		customer.setPassword(password);
		customerService.updatePassword(customer);
		session.setAttribute("customer", customer);
		return "/edit-profile";
	}
	
	@RequestMapping(value = "/change-subscription", method = RequestMethod.GET)
	public String changeSubscription(HttpSession session, @RequestParam(value="subscription")String subscription) {
		System.out.println("<<<<<<<<<<< Editing subscription");
		System.out.println("subscription: " + subscription);
		Customer customer = (Customer)session.getAttribute("customer");
		customer.setEnrolledForPromotions(Integer.parseInt(subscription));
		customerService.updateSubscription(customer);
		session.setAttribute("customer", customer);
		return "/edit-profile";
	}
}
