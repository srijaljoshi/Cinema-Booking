package app.dao;

import app.models.Booking;
import app.models.Customer;
import app.models.Seat;
import app.models.Showtime;
import app.models.Ticket;

import java.util.List;

/**
 * This interface establishes a standard to be implemented by
 * the classes that implement it - particularly CustomerDaoImpl
 *
 * @author srzyl
 */

public interface ICustomerDao {

    /**
     * Retrive a list of all customers from the database
     *
     * @return List<Cutomer>
     */
    public List<Customer> listAll();

    /**
     * Save one particular customer to the database
     *
     * @param customer object
     * @return
     */
    public int save(Customer customer); //Post

    /**
     * Finds a customer with a particular id
     *
     * @param id
     * @return Customer object
     */
    public Customer findById(int id); // GET

    public void update(Customer customer);

    public void removeById(int id);

    void suspend(int id);
    void reactivate(int id);
    /**
     * Method return the Customer object when customer logs in or returns Null
     *
     * @param email
     * @param password
     * @return Customer
     */
    public Customer queryCustomer(String email, String password);
    
    public String updateStatus(Customer customer);

	public Customer findByEmail(String email);
	
	public String updatePassword(Customer customer);
	
	public String updateToken(Customer customer);

	public List<Booking> getAllBookings(String customerId);

	public List<Ticket> getAllTickets(String string, String bookingId);

	public Seat getSeat(String seatId);

	public Showtime queryShowtimeObj(String showtimeId);

    int deleteUser(Integer id);

	public void updateSeatStatus(String showtimeId, String seatId);

	public void deleteTicket(String ticketId);

	public void deleteBooking(String bookingId);

	String updateFirstName(Customer customer);

	public void updateLastName(Customer customer);
	
	public void updateEmailName(Customer customer);

	public void updateSubscription(Customer customer);
	
}
