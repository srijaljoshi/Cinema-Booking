package app.service;

import app.models.Address;
import app.models.Booking;
import app.models.Customer;
import app.models.Seat;
import app.models.Showtime;
import app.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerService {

    public List<Customer> listUsers();

    public int save(Customer customer); //Post

    public Customer findById(int id); // GET

    public void update(Customer customer);
    
    public String updatePassword(Customer customer);
    
    public String updateToken(Customer customer);

    public void removeById(int id);

    public void addAddress(Address address, int id);

    public Customer login(String email, String password);
    
    public String updateStatus(Customer customer);

	public Customer findByEmail(String email);

	public List<Booking> getBooking(String customerId);

	public List<Ticket> getTickets(String string);

	public Seat getSeat(String seatId);
	
	public Showtime queryShowtime(String showtimeId);

}
