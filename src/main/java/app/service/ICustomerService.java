package app.service;

import app.models.Customer;

import java.util.List;

public interface ICustomerService {

	public List<Customer> listUsers();

	public void save(Customer customer); //Post

    public Customer findById(int id); // GET

    public void update(Customer customer);

	public void removeById(int id);
}
