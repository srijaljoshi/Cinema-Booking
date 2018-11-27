package app.controllers;
import java.util.Iterator;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.models.Booking;
import app.models.CardPayment;
import app.models.Promo;
import app.models.Seat;
import app.models.Showtime;
import app.models.Ticket;
import app.service.IBookingService;
import app.service.ICustomerService;

@Controller
@RequestMapping("/u")
public class BookingController {
	
	@Autowired
    private IBookingService bookingService;
	
	/**
	 * Function returns movie information to the user and allows the choice of booking
	 * @return 
	 */
	@RequestMapping("/testBooking")
    public String testBooking() {
        return "testBooking";
    }
	
	/**
	 * Function returns the corresponding available movie seats
	 * @param movieId
	 * @param time
	 * @param date
	 */
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ModelAndView initiateBooking(@RequestParam(value = "time") String time, 
		@RequestParam(value = "movieId") String movieId,
		@RequestParam(value = "date") Date date,
		HttpSession session) {
		Booking booking = new Booking();
		ModelAndView mv = new ModelAndView();
		System.out.println("time: " + time);
		System.out.println("date: " + date.toString());
		System.out.println("movie id " + movieId);
		//make a query to get the showtimeId
		String movieShowingId = bookingService.findShowtimeId(time, date.toString(), movieId);
		System.out.println(movieShowingId);
		booking.setMovieId(Integer.parseInt(movieShowingId));
		booking.setShowTimeId(Integer.parseInt(movieShowingId));
		Showtime showtime = new Showtime();
		showtime.setDate(date.toString());
		showtime.setTime(time.toString());
		booking.setShowtime(showtime);
		List<Seat> seats = bookingService.findAvailableSeats(movieShowingId);
		mv.addObject("seats",seats);
		mv.setViewName("booking");
		session.setAttribute("booking", booking);
		return mv;
	}
	
	
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public String enterTickets(HttpSession session, @RequestParam(value="myArray") String locations,
			@RequestParam(value="total") String totalTickets) throws ParseException {
		System.out.println("<<<<<<<<<<< In tickets");
		Booking booking = (Booking) session.getAttribute("booking");
		System.out.println("got here2");
		System.out.println("showtime: " + booking.getShowTimeId());
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(locations);
		
		JSONArray array = (JSONArray)obj;
		int amount = Integer.parseInt(totalTickets);
		booking.setNumberOfTickets(amount);
		System.out.println("total Tickets: " + amount);
		int hallId = 0;
		ArrayList<Ticket> tickets = new ArrayList<Ticket>(); 
		ArrayList<Seat> seats = new ArrayList<Seat>();
		for(int i = 0; i < amount; ++i) {
			System.out.println("<<<<Creating tickets");
			Ticket x = new Ticket();
			Seat seat = new Seat();
			String seatLocation = array.get(i).toString().trim();
			seat.setLocation(seatLocation);
			System.out.println("Getting seat location: " + seat.getLocation());
			if(i == 0) {
				hallId = bookingService.findHallId(Integer.toString(booking.getShowTimeId()), Integer.toString(booking.getMovieId()));
				System.out.println("Retrieved hall ID: " + hallId);
			}
			int seatId = bookingService.findSeatId(Integer.toString(hallId), seat.getLocation());
			System.out.println("Retrieved seat ID: " + seatId);
			seat.setId(seatId);
			seat.setHallId(hallId);
			x.setSeat(seat);
			tickets.add(x);
			seats.add(seat);
			System.out.println(tickets.size());
			//System.out.println("Added seat to ticket id = " + tickets.get(i).getSeat().getId() + " location = " + tickets.get(0).getSeat().getLocation());
		}
		System.out.println(tickets.size());
		for(int j = 0; j < seats.size(); ++j) {
			tickets.get(j).setSeat(seats.get(j));
		}
		for(int i = 0; i < tickets.size(); ++i) {
			System.out.println("location " + i + ": " + tickets.get(i).getSeat().getLocation());
		}

		booking.setTickets(tickets);
		session.setAttribute("booking", booking);
		return "ticket-category";
	}
	
	@RequestMapping(value = "/ticket-category")
	public String selectTicets(HttpSession session){
		Booking booking = (Booking) session.getAttribute("booking");
		for(int i = 0; i < booking.getTickets().size(); ++i) {
			System.out.println("Checking on ticket-category: " + booking.getTickets().get(i).getSeat().getLocation());
		}
		return "ticket-category";
	}
	
	@RequestMapping(value="calculate")
	public String calculations(@RequestParam(value="child") String childValue,
			@RequestParam(value="adult") String adultValue,
			@RequestParam(value="senior") String seniorValue,
			HttpSession session) {
		Booking booking = (Booking) session.getAttribute("booking");
		double adultPrice = bookingService.getAdultPrice();
		double childPrice = bookingService.getChildPrice();
		double seniorPrice = bookingService.getSeniorPrice();
		
		int child = Integer.parseInt(childValue);
		int adult = Integer.parseInt(adultValue);
		int senior = Integer.parseInt(seniorValue);
		int place = 0;
		for(int i = 0; i < child; ++i) {
			booking.getTickets().get(place).setCategory(1);
			++place;
		}
		for(int i = 0; i < adult; ++i) {
			booking.getTickets().get(place).setCategory(2);
			++place;
		}
	
		for(int i = 0; i < senior; ++i) {
			booking.getTickets().get(place).setCategory(3);
			++place;
		}
		for(int j = 0; j < booking.getTickets().size(); ++j) {
			if(booking.getTickets().get(j).getCategory() == 1) {
				booking.getTickets().get(j).setPrice(child);
			}
			else if(booking.getTickets().get(j).getCategory() == 2) {
				booking.getTickets().get(j).setPrice(adult);
			}
			else if(booking.getTickets().get(j).getCategory() == 3) {
				booking.getTickets().get(j).setPrice(senior);
			}
		}
		for(int j = 0; j < booking.getTickets().size(); ++j) {
			System.out.println("ticket categories: " +booking.getTickets().get(j).getCategory() );
		}
		
		double salesTax = 0.08;
		double fees = 2;
		booking.setFees(fees);
		
		double rawPrice = child * childPrice + adultPrice * adult + senior * seniorPrice;
		booking.setPrice(rawPrice);
		salesTax *= rawPrice;
		salesTax = Math.round(salesTax * 100.0) / 100.0;
		booking.setSalesTax(salesTax);
		double total = rawPrice + booking.getSalesTax() + fees;
		total = Math.round(total * 100.0) / 100.0;
		booking.setTotalPrice(total);
		System.out.println("total Price: " + total);
		booking.setDiscount(0);
		session.setAttribute("booking", booking);
		return "order-summary";
	}
	
	@RequestMapping(value="order-summary")
	public ModelAndView orderSummary(HttpSession session){
		ModelAndView mv = new ModelAndView();
		Booking booking = (Booking)session.getAttribute("booking");
		mv.addObject("booking", booking);
		mv.setViewName("order-summary");
		session.setAttribute("booking", booking);
		return mv;
	}
	
	@RequestMapping(value="apply-promo")
	public String applyPromo(@RequestParam(value = "promoCode") String promoCode, HttpSession session, RedirectAttributes redirectAttributes){
		Booking booking = (Booking)session.getAttribute("booking");
		try {
			Promo promo = bookingService.getPromo(promoCode);
			if(promo != null) {
				double discount = booking.getTotalPrice() * promo.getDiscountPercent();
				discount = Math.round(discount * 100.0) / 100.0;
				booking.setDiscount(discount);
				double newTotal = booking.getTotalPrice() - discount;
				newTotal = Math.round(newTotal * 100.0) / 100.0;
				booking.setTotalPrice(newTotal);
				booking.setCouponId(promo.getId());
			}
			else {
				System.out.println(">>>>>>>>>>promo is null");
				redirectAttributes.addFlashAttribute("error", "Promo is not valid");
				session.setAttribute("booking", booking);
		        return "redirect:order-summary";
			}
		}
		catch(Exception e) {
			redirectAttributes.addFlashAttribute("error", "Promo not valid");
			session.setAttribute("booking", booking);
			return "redirect:order-summary";
		}
		session.setAttribute("booking", booking);
		return "order-summary";
	}
	
	
	@RequestMapping(value="checkout")
	public ModelAndView checkout(HttpSession session) {
		Booking booking = (Booking) session.getAttribute("booking");
		ModelAndView mv = new ModelAndView();
		mv.addObject("booking",booking);
		mv.setViewName("checkout");
		return mv;
	}	
	
	@RequestMapping(value="payment", method = RequestMethod.POST)
	public String payment(@RequestParam("name") String name, 
			@RequestParam("cardNumber") String creditNumber,
			@RequestParam("month") String month,
			@RequestParam("year") String year,
			@RequestParam("cvv") String securityCode,
			HttpSession session) {
		//1. Change availability of the seats in the movie theater - done
		//2. Save the users Booking into DB 
		//3. Add user's credit info into the DB if not already there
		Booking booking = (Booking) session.getAttribute("booking");

		String showtimeId = Integer.toString(booking.getShowTimeId());	
		for(int i = 0; i < booking.getTickets().size(); ++i) {
			//changing seat status to 1 in DB
			int seat = booking.getTickets().get(i).getSeat().getId();
			String seatId = Integer.toString(seat);
			System.out.println("removing a ticket in booking controller");
			bookingService.changeSeatAvailability(showtimeId, seatId);
		}
		String customerId = "31";

		//Saving Credit Card info
		System.out.println("---------credit card number: " + creditNumber);
		int card = bookingService.checkCard(creditNumber);
		if(card == 0) {
			//inserting card into DB
			bookingService.addCreditCard(creditNumber, customerId, securityCode, year, month);
		}
		/**** saving the user's booking info: *****/
		String promoId = Integer.toString(booking.getCouponId());
		String movieId = Integer.toString(booking.getMovieId());
		//already have creditCardNumber in parameters
		String totalPrice = Double.toString(booking.getTotalPrice());
		String numberOfTickets = Integer.toString(booking.getNumberOfTickets());
		int bookingId = -1;
		if(promoId != null) {
			bookingId = bookingService.addBookingWithPromo(customerId, promoId, movieId, creditNumber, totalPrice, numberOfTickets);			
		}
		else {
			bookingId = bookingService.addBookingNoPromo(customerId, movieId, creditNumber, totalPrice, numberOfTickets);
		}
		
		int MovieShowID = bookingService.getMovieShowId(movieId, showtimeId);
		//int bookingId = bookingService.getBookingId(customerId, Integer.toString(booking.getMovieId()));
		booking.setId(bookingId);
		booking.setId(bookingId);
		//Adding tickets to DB: ageCategoryID, seatID, movieShowID, price, bookingID
		for(int i = 0; i < booking.getTickets().size(); ++i) {
			int ageCategoryID = booking.getTickets().get(i).getCategory();
			int seatID = booking.getTickets().get(i).getSeat().getId();
			double price = booking.getTickets().get(i).getPrice();
			bookingService.addTickets(Integer.toString(ageCategoryID), Integer.toString(seatID), Double.toString(price), Integer.toString(MovieShowID), Integer.toString(bookingId));
		}
		session.setAttribute("booking", booking);
		return "confirmation";
	}
	
	@RequestMapping(value="confirmation")
	public ModelAndView confirmation(HttpSession session, ModelAndView mv) {
		Booking booking = (Booking) session.getAttribute("booking");
		
		
		//need to 
		// add a Showtime to view - done
		// add the Seats - done with booking
		// add the amount of ticket types - done with booking
		// add the theater - done with tickets in booking
		// add the total - done with the booking
		// add a title of the the movie
		String movieTitle = bookingService.getMovieName(Integer.toString(booking.getMovieId()));
		Showtime showtime = new Showtime();
		Map modelMap = new HashMap();
		modelMap.put("title", movieTitle);
		mv.addAllObjects(modelMap);
		/*showtime = bookingService.queryShowtime(Integer.toString(booking.getShowTimeId()));
		System.out.println("showtime date = " + showtime.getDate() + " showtime time = " + showtime.getTime());
		mv.addObject("showtime", showtime);*/
		mv.addObject("booking", booking);
		mv.setViewName("/u/confirmation");
		System.out.println("Movie title: " + movieTitle);
		return mv;
	}
	
}
