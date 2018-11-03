package app.service;

import app.dao.ICustomerDao;
import app.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> listUsers() {
        return customerDao.listAll();
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
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
}
