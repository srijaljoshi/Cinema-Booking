package app.service;

import app.models.Address;
import app.models.Admin;
import app.models.Customer;
import app.models.Movie;

import java.util.List;

public interface IAdminService {

    public List<Customer> listCustomers();
    public int addCustomer(Customer customer); //Post
    public Customer findById(int id); // GET

    void suspend(int id);
    void reactivateUser(int id);
    /*
    Movies management
     */
    public List<Movie> listMovies();
    int deleteMovie(int id);

    public Admin login(String email, String password);

    void saveMovie(Movie m);
}
