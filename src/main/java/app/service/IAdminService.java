package app.service;

import app.models.*;

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

    List<Hall> listHalls();

    void saveHall(Hall hall);

    void updateMovie(Movie m);
}