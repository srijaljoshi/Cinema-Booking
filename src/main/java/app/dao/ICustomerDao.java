package app.dao;

import java.util.List;

import app.models.Customer;

/**
 * This interface establishes a standard to be implemented by
 * the classes that implement it - particularly CustomerDaoImpl
 * @author srzyl
 *
 */

public interface ICustomerDao {
	
	/**
	 * Retrive a list of all customers from the database
	 * @return List<Cutomer>
	 */
	public List<Customer> listAll();
	
	/**
	 * Save one particular customer to the database
	 * @param customer object
	 */
	public void save(Customer customer); //Post
	
	/**
	 * Finds a customer with a particular id
	 * @param id
	 * @return Cutomer object
	 */
	public Customer findById(int id); // GET
	
	public void update(Customer customer);
	
	public void removeById(int id);

}
