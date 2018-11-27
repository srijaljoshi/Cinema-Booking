package app.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import app.models.*;

@Repository("bookingDao")
public class BookingDaoImpl implements IBookingDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;
	
    public List<Seat> queryShowtime(String showtimeId) {
		String query = "select Seat.location, SeatShowtime.taken FROM Seat JOIN SeatShowtime ON Seat.id = SeatShowtime.seatID WHERE SeatShowtime.showtimeID = ? ORDER BY location";
		List<Seat> seats = this.jdbcTemplate.query(
				query,
				new Object[] {showtimeId},
				new RowMapper<Seat>() {
					public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
						Seat seat = new Seat();
						seat.setSeatTaken(rs.getInt("taken"));
						seat.setLocation(rs.getString("location"));
						System.out.println("Location: " + seat.getLocation() + " taken: " + seat.getSeatTaken());
						return seat;
					}
				});
		System.out.println("done");
		return seats;
	}

	@Override
	public String queryShowtimeId(String time, String date, String movieId) {
		String query = "select Showtime.id FROM Showtime JOIN MovieShow ON Showtime.id = MovieShow.showTimeID where Showtime.time = ? AND Showtime.date = ? AND MovieShow.movieID = ?";
		Showtime showtime = jdbcTemplate.queryForObject(query, new Object[] {time, date, movieId}, new RowMapper<Showtime>() {
			@Override
			public Showtime mapRow(ResultSet rs, int rowNum) throws SQLException{
				Showtime showtime = new Showtime();
				showtime.setId(rs.getInt("id"));
				return showtime;
			}
		});
		return Integer.toString(showtime.getId());
	}

	@Override
	public double queryChildTicket() {
		String query = "select price from AgeCategory where category = 'child'";
		return jdbcTemplate.queryForObject(query, Double.class);
		
	}

	@Override
	public double querySeniorTicket() {
		String query = "select price from AgeCategory where category = 'senior'";
		return jdbcTemplate.queryForObject(query, Double.class);
	}

	@Override
	public double queryAdultTicket() {
		String query = "select price from AgeCategory where category = 'adult'";
		return jdbcTemplate.queryForObject(query, Double.class);
	}

	@Override
	public Promo queryPromo(String code) {
		String query = "select * from Promo where code = ?";
		Promo promo = jdbcTemplate.queryForObject(query, new Object[] {code}, new RowMapper<Promo>() {
			@Override
			public Promo mapRow(ResultSet rs, int rowNum) throws SQLException{
				Promo promo = new Promo();
				promo.setDiscountPercent(rs.getDouble("discountPercent"));
				promo.setExpirationDate(rs.getDate("expirationDate"));
				promo.setId(rs.getInt("id"));
				return promo;
			}
		});
		return promo;
	}

	@Override
	public int queryHallId(String showtimeId, String movieId) {
		System.out.println("movieId = " + movieId + " showtimeId = " + showtimeId);
		String query = "select hallId from MovieShow where movieID = ? and showTimeID = ?";
		Seat seat= jdbcTemplate.queryForObject(query, new Object[] {movieId, showtimeId}, new RowMapper<Seat>() {
			@Override
			public Seat mapRow(ResultSet rs, int rowNum) throws SQLException{
				Seat seat = new Seat();
				seat.setHallId(rs.getInt("hallID"));
				return seat;
			}
		});
		return seat.getHallId();
	}

	@Override
	public void updateSeat(String showtimeId, String seatId) {
		String query = "update SeatShowtime set taken = '1' where showtimeID = ? and seatID = ?";
		jdbcTemplate.update(query, showtimeId, seatId);
		
	}

	@Override
	public int querySeatId(String hallId, String location) {
		System.out.println("In DB: hallId = " + hallId + " and location = " + location);
		String query = "select id from Seat where hallID = ? and location = ?";
		Seat seat= jdbcTemplate.queryForObject(query, new Object[] {hallId, location}, new RowMapper<Seat>() {
			@Override
			public Seat mapRow(ResultSet rs, int rowNum) throws SQLException{
				Seat seat = new Seat();
				seat.setId(rs.getInt("id"));
				return seat;
			}
		});
		return seat.getId();
	}

	@Override
	public int updateBookingWithPromo(String customerId, String promoId, String movieId, String creditNumber,
		String totalPrice, String numberOfTickets, String showtimeId) {
		/*
		String query = "INSERT INTO Booking (customerID, movieID, creditCardNo, totalPrice, numTickets, promoId) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(query, customerId, movieId, creditNumber, totalPrice, numberOfTickets, promoId);
		*/
		
		String query = "INSERT INTO Booking (customerID, movieID, creditCardNo, totalPrice, numTickets, promoId, showtimeId) VALUES(?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(query, new String[]{"id"});
                        ps.setInt(1, Integer.parseInt(customerId));
                        ps.setInt(2, Integer.parseInt(movieId));
                        ps.setString(3, creditNumber);
                        ps.setDouble(4, Double.parseDouble(totalPrice));
                        ps.setInt(5, Integer.parseInt(numberOfTickets));
                        ps.setInt(6, Integer.parseInt(promoId));
                        ps.setInt(7, Integer.parseInt(showtimeId));
                        return ps;
                    }
                },
                keyHolder);
        System.out.println(keyHolder.getKey());
        return keyHolder.getKey().intValue();
	}

	@Override
	public int updateBookingNoPromo(String customerId, String movieId, String creditNumber, String totalPrice,
			String numberOfTickets, String showtimeId) {
		String query = "INSERT INTO Booking (customerID, movieID, creditCardNo, totalPrice, numTickets, showtimeId) VALUES(?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(query, new String[]{"id"});
                        ps.setInt(1, Integer.parseInt(customerId));
                        ps.setInt(2, Integer.parseInt(movieId));
                        ps.setString(3, creditNumber);
                        ps.setDouble(4, Double.parseDouble(totalPrice));
                        ps.setInt(5, Integer.parseInt(numberOfTickets));
                        ps.setInt(6, Integer.parseInt(showtimeId));
                        return ps;
                    }
                },
                keyHolder);
        System.out.println(keyHolder.getKey());
        return keyHolder.getKey().intValue();
	}

	@Override
	public int queryCard(String creditNumber) {
		String query = "select * from CardPayment where creditCardNo = ?";
		List<CardPayment> cards = this.jdbcTemplate.query(
			query,
			new Object[] {creditNumber},
			new RowMapper<CardPayment>() {
				public CardPayment mapRow(ResultSet rs, int rowNum) throws SQLException {
					CardPayment card = new CardPayment();
					card.setCreditCardNo(rs.getString("creditCardNo"));
					return card;
				}
			});
		return cards.size();
	}


		


	@Override
	public void insertCard(String creditNumber, String customerId, String securityCode, String year, String month) {
		String query = "INSERT INTO CardPayment (customerID, creditCardNo, securityCode, year, month) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(query, customerId, creditNumber, securityCode, year, month);
	}

	@Override
	public int queryMovieShowId(String movieId, String showtimeId) {
		String query = "select * from MovieShow where movieID = ? and showTimeID = ?";
		MovieShowing movieShow = jdbcTemplate.queryForObject(query, new Object[] {movieId, showtimeId}, new RowMapper<MovieShowing>() {
			@Override
			public MovieShowing mapRow(ResultSet rs, int rowNum) throws SQLException{
				MovieShowing movieShow = new MovieShowing();
				movieShow.setId(rs.getInt("id"));
				return movieShow;
			}
		});
		
		return movieShow.getId();
	}

	@Override
	public void insertTicket(String ageCategoryId, String seatId, String price, String movieShowId, String bookingID) {
		String query = "INSERT INTO Ticket (ageCategoryID, seatID, movieShowID, price, bookingID) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(query, ageCategoryId, seatId, movieShowId, price, bookingID);
	}

	@Override
	public Booking queryBooking(String customerId, String movieID) {
		String query = "select * from Booking where movieID = ? and customerID = ?";
		Booking book = jdbcTemplate.queryForObject(query, new Object[] {movieID, customerId}, new RowMapper<Booking>() {
			@Override
			public Booking mapRow(ResultSet rs, int rowNum) throws SQLException{
				Booking book = new Booking();
				book.setId(rs.getInt("id"));
				return book;
			}
		});
		
		return book;
	}

	@Override
	public Showtime queryShowtimeObj(String showtimeId) {
		String query = "select * from Showtime where id = ?";
		Showtime showtime = jdbcTemplate.queryForObject(query, new Object[] {showtimeId}, new RowMapper<Showtime>() {
			@Override
			public Showtime mapRow(ResultSet rs, int rowNum) throws SQLException{
				Showtime showtime = new Showtime();
				showtime.setDate(rs.getDate("date").toString());
				showtime.setTime(rs.getString("time"));
				return showtime;
			}
		});
		return showtime;
	}

	@Override
	public String queryMovieName(String string) {
		System.out.println("querying movie name");
		String query = "select title from Movie where id = ?";
		String movieName = (String) jdbcTemplate.queryForObject(
				query, new Object[] { string }, String.class);
		System.out.println("Got movie name as: " + movieName);
		System.out.println("getting movie name: " + movieName);
	    return movieName;
	}
	
	
}
