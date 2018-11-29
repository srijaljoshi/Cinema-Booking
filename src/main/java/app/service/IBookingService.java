package app.service;
import app.models.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IBookingService {
	
	/**
	 * This function creates a Showtime object to initiate booking
	 * @param time of the showtime
	 * @param date of the showtime
	 */
	public List<Seat> findAvailableSeats(String showtimeId);

	public String findShowtimeId(String time, String date, String movieId);

	public double getChildPrice();

	public double getSeniorPrice();

	public double getAdultPrice();

	public Promo getPromo(String promoCode);

	public int findHallId(String showtimeId, String movieId);

	public void changeSeatAvailability(String showtimeId, String seatId);

	public int findSeatId(String hallId, String location);

	public int addBookingWithPromo(String customerId, String promoId, String movieId, String creditNumber,
			String totalPrice, String numberOfTickets, String showtimeId);

	public int addBookingNoPromo(String customerId, String movieId, String creditNumber, String totalPrice,
			String numberOfTickets, String showtimeId);

	public int checkCard(String creditNumber);

	public void addCreditCard(String creditNumber, String customerId, String securityCode, String year, String month);

	public int getMovieShowId(String movieId, String showtimeId);

	public void addTickets(String ageCategoryId, String seatId, String price, String movieShowId, String bookingId);

	public int getBookingId(String customerId, String movieShowID);

	public Showtime queryShowtime(String showtimeId);

	public String getMovieName(String string);
	
}
