package app.dao;

import app.models.Movie;

import java.util.List;

public interface IMovieDao {

//    Get all movies
    List<Movie> listAll();
    void delete(int id);

    void save(Movie m);
    List<Movie> findByTitle(String title);

    Movie findById(Integer id);

    List<Movie> listMoviesByPlaying(int nowPlaying);
}
