package app.service;

import app.models.Address;
import app.models.Customer;

import java.util.List;

public interface ICustomerService {

    public List<Customer> listUsers();

    public int save(Customer customer); //Post

    public Customer findById(int id); // GET

    public void update(Customer customer);

    public void removeById(int id);

    public void addAddress(Address address, int id);

    public Customer login(String email, String password);
}
