package app.dao;

import app.models.Admin;
import app.models.Customer;
import app.models.Hall;
import app.models.Movie;

import java.util.List;

/**
 * This interface establishes a standard to be implemented by
 * the classes that implement it - particularly CustomerDaoImpl
 *
 * @author srzyl
 */

public interface IAdminDao {
    /**
     * Save one particular customer to the database
     *
     * @param customer object
     * @return
     */
    public int save(Customer customer); //Post

    /**
     * Finds a customer with a particular id
     *
     * @param id
     * @return Cutomer object
     */
    public Customer findById(int id); // GET

    public void update(Customer customer);

    public void removeById(int id);

    public Admin getAdmin(String email, String password);

    List<Hall> listHalls();

    void saveHall(Hall hall);

    void updateMovie(Movie m);
}
