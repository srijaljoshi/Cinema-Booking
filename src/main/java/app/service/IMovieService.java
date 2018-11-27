package app.service;

import app.models.Admin;
import app.models.Customer;
import app.models.Hall;
import app.models.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> listMovies();
    int deleteMovie(int id);
    void saveMovie(Movie m);

    List<Movie> findByTitle(String title);

}
