package app.models;

import java.util.Date;

public class MovieShowing {
    private Showtime st;
    private Hall hall;
    private int id;
    private int movieId;
    private int showtimeId;
    private int hallId;
    private String showDate;
    private Movie movie;

    public MovieShowing(Movie movie, int movieId, int showtimeId, int hallId, String showDate) {
        this.movieId = movieId;
        this.showtimeId = showtimeId;
        this.hallId = hallId;
        this.showDate = showDate;

    }

    public MovieShowing() {
		this.id = 0;
	}

	public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setHallId(int hallId) {
        hallId = hall.getId();
        this.hallId = hallId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowDate() {
        return showDate;
    }
}
