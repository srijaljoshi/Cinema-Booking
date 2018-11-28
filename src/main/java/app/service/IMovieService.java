package app.service;

import app.models.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> listMovies();
    int deleteMovie(int id);
    void saveMovie(Movie m);

    List<Movie> findByTitle(String title);

    Movie findById(Integer id);

    List<Movie> listMoviesByPlaying(int nowPlaying);
}
