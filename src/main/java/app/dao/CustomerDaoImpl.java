package app.dao;

import app.models.Booking;
import app.models.Customer;
import app.models.Seat;
import app.models.Showtime;
import app.models.Ticket;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> listAll() {
//        return jdbcTemplate.query("select * from Customer", new RowMapper<Customer>() {
//
//            @Override
//            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Customer c = new Customer();
//                c.setId(rs.getInt("id"));
//                c.setEmail(rs.getString("email"));
//                c.setPassword(rs.getString("password"));
//                c.setFirstName(rs.getString("firstName"));
//                c.setLastName(rs.getString("lastName"));
//                return c;
//            }
//        });

        return sessionFactory.getCurrentSession().createQuery("from Customer").list();
    }

    /**
     * This function save a customer into the database
     *
     * @param customer object
     */
    @Transactional
    @Override
    public int save(Customer customer) {
        System.out.println("insert a customer into DB");
        //        sessionFactory.getCurrentSession().persist(customer);
        String INSERT_SQL = "insert into Customer (statusID, firstName, lastName, email, password, enrolledForPromotions, token) values(?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                        ps.setInt(1, 2);
                        ps.setString(2, customer.getFirstName());
                        ps.setString(3, customer.getLastName());
                        ps.setString(4, customer.getEmail());
                        ps.setString(5, customer.getPassword());
                        ps.setInt(6, customer.getEnrolledForPromotions());
                        ps.setString(7, customer.getToken());
                        return ps;
                    }
                },
                keyHolder);
        System.out.println(keyHolder.getKey());
        return keyHolder.getKey().intValue();
    }

    @Override
    public Customer findById(int id) {
        Customer customer = jdbcTemplate.queryForObject("select * from Customer where id=?", new Object[] {id}, new RowMapper<Customer>() {
        	@Override
        	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
        		Customer customer = new Customer();
        		customer.setId(rs.getInt("id"));
        		customer.setEmail(rs.getString("email"));
        		customer.setEnrolledForPromotions(rs.getInt("enrolledForPromotions"));
        		customer.setFirstName(rs.getString("firstName"));
        		customer.setLastName(rs.getString("lastName"));
        		customer.setToken(rs.getString("token"));
        		customer.setStatusID(rs.getInt("statusID"));
        		return customer;
        	}
        });
        System.out.println("found customer: " + customer.getId());
        System.out.println("found customer: " + customer.getStatusID());
        return customer;
    }

    @Override
    public void update(Customer customer) {

    }
    
    /**
     * Function updates the user status once the email is received and clicked on link
     * @param customer object
     * @return string indicating Unsuccessfull or Successfull
     */
    public String updateStatus(Customer customer) {
    	this.jdbcTemplate.update("update Customer set statusID = ? where id = ?", 1, customer.getId());
    	System.out.println("updated status for user");
    	return "Successfull";
    }


    
    @Override
    public void removeById(int id) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().createQuery("delete from Customer where id=:uid").setInteger("uid", id).executeUpdate();
    }

    @Override
    public void suspend(int id) {
        int res = sessionFactory.getCurrentSession().createQuery("update Customer set statusID = 2 where id = :uid").setParameter("uid", id).executeUpdate();
        System.out.println(">>> Update status of customer result: " + res);
    }

    @Override
    public void reactivate(int id) {

        int res = sessionFactory.getCurrentSession().createQuery("update Customer set statusID = 1 where id = :uid").setParameter("uid", id).executeUpdate();
        System.out.println(">>> Update status of customer result: " + res);
    }

    /**
     * Function checks if a customer is already in the database and returns their information
     *
     * @param email
     * @param password
     * @return customer object
     */
    @Override
    public Customer queryCustomer(String email, String password) {
        System.out.println(">>> querying customer");
        String query = "select id, firstName, lastName, statusID, enrolledForPromotions from Customer where email = ? and password = ?";
        Customer customer = this.jdbcTemplate.queryForObject(query, new Object[]{email, password}, new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer = new Customer();
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setEmail(email);
                customer.setId(rs.getInt("id"));
                customer.setEnrolledForPromotions(rs.getInt("enrolledForPromotions"));
                customer.setPassword(password);
                customer.setStatusID(rs.getInt("statusID"));
                return customer;
            }

        });
        System.out.println("done querying customer " + customer.getEmail() + "    " + customer.getPassword());
        return customer;
    }

	@Override
	public Customer findByEmail(String email) {
		Customer customer = jdbcTemplate.queryForObject("select * from Customer where email=?", new Object[] {email}, new RowMapper<Customer>() {
        	@Override
        	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
        		Customer customer = new Customer();
        		customer.setId(rs.getInt("id"));
        		customer.setEmail(rs.getString("email"));
        		customer.setEnrolledForPromotions(rs.getInt("enrolledForPromotions"));
        		customer.setFirstName(rs.getString("firstName"));
        		customer.setLastName(rs.getString("lastName"));
        		customer.setToken(rs.getString("token"));
        		customer.setStatusID(rs.getInt("statusID"));
        		return customer;
        	}
        });
        System.out.println("found customer: " + customer.getId());
        System.out.println("found customer: " + customer.getStatusID());
        return customer;
	}

	@Override
    public String updatePassword(Customer customer) {
    	this.jdbcTemplate.update("update Customer set password = ? where id = ?", customer.getPassword(), customer.getId());
    	return "Successfull";
    }

	@Override
	public String updateToken(Customer customer) {
		this.jdbcTemplate.update("update Customer set token = ? where email = ?", customer.getToken(), customer.getEmail());
    	System.out.println("updated token for user");
    	return "Successfull";
	}

	@Override
	public List<Booking> getAllBookings(String customerId) {
		String query = "select * from Booking where customerID = ?";
		List<Booking> bookings = jdbcTemplate.query(
				query,
				new Object[] {customerId},
				new RowMapper<Booking>() {
					public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
						Booking b = new Booking();
						b.setId(rs.getInt("id"));
						b.setCustomerId(rs.getInt("customerID"));
						b.setMovieId(rs.getInt("movieID"));
						b.setCouponId(rs.getInt("promoId)"));
						b.setTotalPrice(rs.getDouble("totalPrice"));
						b.setNumberOfTickets(rs.getInt("numTickets"));
						b.setCreditCardNo(rs.getString("creditCardNo"));
						b.setShowTimeId(rs.getInt("showtimeId"));
						return b;
					}
				}
		);
		return bookings;
	}

	@Override
	public List<Ticket> getAllTickets(String string) {
		String query = "select * from Ticket where customerID = ?";
		List<Ticket> tickets = jdbcTemplate.query(
				query,
				new Object[] {string},
				new RowMapper<Ticket>() {
					public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
						Ticket t = new Ticket();
						t.setCategory(rs.getInt("ageCategoryID"));
						t.setId(rs.getInt("id"));
						t.setSeatId(rs.getInt("seatID"));
						t.setMovieShowId(rs.getInt("movieShowID"));
						t.setPrice(rs.getDouble("price"));
						t.setBookingId(rs.getInt("bookingID"));
						return t;
					}
				}
		);
		return tickets;
	}

	@Override
	public Seat getSeat(String seatId) {
		String query = "select * from Seat where id = ?";
		Seat seat = jdbcTemplate.queryForObject(query, new Object[] {seatId}, new RowMapper<Seat>() {
        	@Override
        	public Seat mapRow(ResultSet rs, int rowNum) throws SQLException{
        		Seat s = new Seat();
        		s.setId(rs.getInt("id"));
        		s.setHallId(rs.getInt("hallID"));
        		s.setLocation(rs.getString("location"));
        		return s;
        	}
        });
        return seat;
	}

	@Override
	public Showtime queryShowtimeObj(String showtimeId) {
		
		String query = "select * from Showtime where id = ?";
		Showtime showtime = jdbcTemplate.queryForObject(query, new Object[] {showtimeId}, new RowMapper<Showtime>() {
			@Override
        	public Showtime mapRow(ResultSet rs, int rowNum) throws SQLException{
				Showtime s = new Showtime();
				s.setDate(rs.getDate("date").toString());
				s.setTime(rs.getString("time"));
				return s;
			}
		});
		return showtime;
	}


	
}