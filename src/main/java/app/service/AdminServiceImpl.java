package app.service;

import app.dao.IAddressDao;
import app.dao.IAdminDao;
import app.dao.ICustomerDao;
import app.models.Address;
import app.models.Admin;
import app.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    @Autowired
    private IAddressDao addressDao;

    @Transactional
    @Override
    public List<Customer> listCustomers() {
        return adminDao.listAll();
    }

    @Override
    public int addCustomer(Customer customer) {
        return adminDao.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return null;
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
