package app.service;

import app.dao.IAddressDao;
import app.dao.ICustomerDao;
import app.models.Address;
import app.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerDao customerDao;
    
    @Autowired
    private IAddressDao addressDao;

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
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void removeById(int id) {
    	
    }
    
    public void addAddress(Address address, int id) {
    	addressDao.save(address, id);
    }

	@Override
	public Customer login(String email, String password) {
		// TODO Auto-generated method stub
		return customerDao.queryCustomer(email, password);
	}
}
