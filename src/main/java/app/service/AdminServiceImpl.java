package app.service;

import app.dao.IAddressDao;
import app.dao.IAdminDao;
import app.dao.ICustomerDao;
import app.dao.IMovieDao;
import app.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
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

    @Transactional
    @Override
    public void saveMovie(Movie m) {
        movieDao.save(m);
    }

    @Transactional
    @Override
    public List<Hall> listHalls() {
        return adminDao.listHalls();
    }

    @Transactional
    @Override
    public void saveHall(Hall hall) {
        adminDao.saveHall(hall);
    }

    @Transactional
    @Override
    public void updateMovie(Movie m) {
        adminDao.updateMovie(m);
    }

    @Transactional
    @Override
    public void savePromo(Promo promo) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        sdf.applyPattern(promo.getExpirationDate().toString());
//        promo.setExpirationDate(java.sql.Date.valueOf(promo.getExpirationDate().toString()));
        adminDao.savePromo(promo);
    }

    @Transactional
    @Override
    public List<Promo> listPromos() {
        return adminDao.listPromo();
    }

    @Transactional
    @Override
    public int deletePromo(Integer id) {
        return adminDao.deletePromo(id);
    }
}
