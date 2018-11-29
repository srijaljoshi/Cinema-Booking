package app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.IBookingDao;
import app.dao.ICustomerDao;
import app.models.Booking;
import app.models.CardPayment;
import app.models.Promo;
import app.models.Seat;
import app.models.Showtime;

@Service
public class BookingServiceImpl implements IBookingService{

	@Autowired
	private IBookingDao bookingDao;

	@Override
	public List<Seat> findAvailableSeats(String showtimeId) {
		return bookingDao.queryShowtime(showtimeId);
	}

	@Override
	public String findShowtimeId(String time, String date, String movieId) {
		return bookingDao.queryShowtimeId(time, date, movieId);
	}

	@Override
	public double getChildPrice() {
		return bookingDao.queryChildTicket();
	}

	@Override
	public double getSeniorPrice() {
		return bookingDao.querySeniorTicket();
	}

	@Override
	public double getAdultPrice() {
		return bookingDao.queryAdultTicket();
	}

	@Override
	public Promo getPromo(String code) {
		return bookingDao.queryPromo(code);
	}

	@Override
	public int findHallId(String showtimeId, String movieId) {
		return bookingDao.queryHallId(showtimeId, movieId);
	}

	@Override
	public void changeSeatAvailability(String showtimeId, String seatId) {
		bookingDao.updateSeat(showtimeId, seatId);
	}

	@Override
	public int findSeatId(String hallId, String location) {
		return bookingDao.querySeatId(hallId, location);
	}

	@Override
	public int addBookingWithPromo(String customerId, String promoId, String movieId, String creditNumber,
			String totalPrice, String numberOfTickets, String showtimeId) {
		return bookingDao.updateBookingWithPromo(customerId, promoId, movieId, creditNumber, totalPrice, numberOfTickets, showtimeId);
	}

	@Override
	public int addBookingNoPromo(String customerId, String movieId, String creditNumber, String totalPrice,
			String numberOfTickets, String showtimeId) {
		return bookingDao.updateBookingNoPromo(customerId, movieId, creditNumber, totalPrice, numberOfTickets, showtimeId);
	}

	@Override
	public int checkCard(String creditNumber) {
		return bookingDao.queryCard(creditNumber);
	}

	@Override
	public void addCreditCard(String creditNumber, String customerId, String securityCode, String year, String month) {
		bookingDao.insertCard(creditNumber, customerId, securityCode, year, month);
		
	}

	@Override
	public int getMovieShowId(String movieId, String showtimeId) {
		return bookingDao.queryMovieShowId(movieId, showtimeId);
	}

	@Override
	public void addTickets(String ageCategoryId, String seatId, String price, String movieShowId, String bookingId) {
		bookingDao.insertTicket(ageCategoryId, seatId, price, movieShowId, bookingId);
		
	}

	@Override
	public int getBookingId(String customerId, String movieShowID) {
		Booking j = bookingDao.queryBooking(customerId, movieShowID);
		return j.getId();
	}

	@Override
	public Showtime queryShowtime(String showtimeId) {
		return bookingDao.queryShowtimeObj(showtimeId);
	}

	@Override
	public String getMovieName(String string) {
		// TODO Auto-generated method stub
		return bookingDao.queryMovieName(string);
	}


}
