package app.service;

import app.dao.IAddressDao;
import app.dao.ICustomerDao;
import app.models.Address;
import app.models.Booking;
import app.models.Customer;
import app.models.Seat;
import app.models.Showtime;
import app.models.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private IAddressDao addressDao;

    @Transactional
    @Override
    public List<Customer> listUsers() {
        return customerDao.listAll();
    }

    @Override
    public int save(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    @Override
    public void update(Customer customer) {
    	 customerDao.update(customer);
    }

    @Transactional
    @Override
    public void removeById(int id) {
        customerDao.removeById(id);
    }

    @Override
    public void addAddress(Address address, int id) {
        addressDao.save(address, id);
    }

    @Override
    public Customer login(String email, String password) {
        // TODO Auto-generated method stub
        return customerDao.queryCustomer(email, password);
    }
    
    @Override
    public String updateStatus(Customer customer) {
    	return customerDao.updateStatus(customer);
    }

	@Override
	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

	@Transactional
    @Override
    public int deleteUser(Integer id) {
        return customerDao.deleteUser(id);
    }

    @Override
	public String updatePassword(Customer customer) {
		return customerDao.updatePassword(customer);
	}

	@Override
	public String updateToken(Customer customer) {
		return customerDao.updateToken(customer);
	}

	@Override
	public List<Booking> getBooking(String customerId) {
		return customerDao.getAllBookings(customerId);
	}

	@Override
	public List<Ticket> getTickets(String string, String bookingId) {
		return customerDao.getAllTickets(string, bookingId);
	}

	@Override
	public Seat getSeat(String seatId) {
		return customerDao.getSeat(seatId);
	}
	
	@Override
	public Showtime queryShowtime(String showtimeId) {
		return customerDao.queryShowtimeObj(showtimeId);
	}

	@Override
	public void updateSeatStatus(String showtimeId, String seatId) {
		customerDao.updateSeatStatus(showtimeId, seatId);
	}

	@Override
	public void removeTicket(String ticketId) {
		// TODO Auto-generated method stub
		customerDao.deleteTicket(ticketId);
	}

	@Override
	public void removeBooking(String bookingId) {
		// TODO Auto-generated method stub
		customerDao.deleteBooking(bookingId);
	}

	@Override
	public String updateFirstName(Customer customer) {
		return customerDao.updateFirstName(customer);
	}

	@Override
	public void updateLastName(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateLastName(customer);
	}

	@Override
	public void updateEmail(Customer customer) {
		customerDao.updateEmailName(customer);
	}

	@Override
	public void updateSubscription(Customer customer) {
		customerDao.updateSubscription(customer);
		
	}

	
}
