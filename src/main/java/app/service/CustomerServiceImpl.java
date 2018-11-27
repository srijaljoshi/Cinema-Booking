package app.service;

import app.dao.IAddressDao;
import app.dao.ICustomerDao;
import app.models.Address;
import app.models.Customer;
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

    @Override
	public String updatePassword(Customer customer) {
		return customerDao.updatePassword(customer);
	}

	@Override
	public String updateToken(Customer customer) {
		return customerDao.updateToken(customer);
	}
}
