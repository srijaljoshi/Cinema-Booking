package app.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.models.Booking;
import app.models.CardPayment;
import app.models.Promo;
import app.models.Seat;
import app.models.Showtime;


public interface IBookingDao {
	
	public List<Seat> queryShowtime(String showtimeId);

	public String queryShowtimeId(String time, String date, String movieId);

	public double queryChildTicket();

	public double querySeniorTicket();

	public double queryAdultTicket();

	public Promo queryPromo(String code);

	public int queryHallId(String showtimeId, String movieId);

	public void updateSeat(String showtimeId, String seatId);

	public int querySeatId(String hallId, String location);

	public int updateBookingWithPromo(String customerId, String promoId, String movieId, String creditNumber,
			String totalPrice, String numberOfTickets);

	public int updateBookingNoPromo(String customerId, String movieId, String creditNumber, String totalPrice,
			String numberOfTickets);

	public int queryCard(String creditNumber);

	public void insertCard(String creditNumber, String customerId, String securityCode, String year, String month);

	public int queryMovieShowId(String movieId, String showtimeId);

	public void insertTicket(String ageCategoryId, String seatId, String price, String movieShowId, String bookingId);

	public Booking queryBooking(String customerId, String movieID);

	public Showtime queryShowtimeObj(String showtimeId);

	public String queryMovieName(String string);
}
