package app.service;

import app.dao.IAddressDao;
import app.dao.IAdminDao;
import app.dao.ICustomerDao;
import app.dao.IMovieDao;
import app.models.Address;
import app.models.Admin;
import app.models.Customer;
import app.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private IAddressDao addressDao;

    @Autowired
    private IMovieDao movieDao;

    @Transactional
    @Override
    public List<Customer> listCustomers() {
        return customerDao.listAll();
    }

    @Override
    public int addCustomer(Customer customer) {
        return adminDao.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Transactional
    @Override
    public void suspend(int id) {
        customerDao.suspend(id);
    }

    @Transactional
    @Override
    public void reactivateUser(int id) {
        customerDao.reactivate(id);
    }

    @Transactional
    @Override
    public List<Movie> listMovies() {
        return movieDao.listAll();
    }

    @Transactional
    @Override
    public int deleteMovie(int id) {
        try {
            movieDao.delete(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }


    public void addAddress(Address address, int id) {
        addressDao.save(address, id);
    }

    @Override
    @Transactional
    public Admin login(String email, String password) {
        // TODO Auto-generated method stub
        return adminDao.getAdmin(email, password);
    }
}
