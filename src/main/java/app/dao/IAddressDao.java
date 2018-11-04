package app.dao;

import java.util.List;

import app.models.Address;

public interface IAddressDao {
	/**
	 * Retrive a list of all customers from the database
	 * @return List<Cutomer>
	 */
	public List<Address> listAll();
	
	/**
	 * Save one particular customer to the database
	 * @param customer object
	 * @return 
	 */
	public int save(Address address, int customerId); //Post

	public Address findById(int id); // GET
	
	public void update(Address address);
	
	public void removeById(int id);
}
