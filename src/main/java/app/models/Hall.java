package app.models;


public class Hall {
	private MovieShowing movie;
	private int id;
	private final int totalSeats=30;
	private int availableSeats=totalSeats; 
	
	public Hall(MovieShowing movie, int availableSeats) {
		this.movie = movie;
		this.availableSeats = availableSeats;
	}
	
	public void setMovieShowing(MovieShowing movie) {
		this.movie = movie;
	}
	
	public MovieShowing getMovieShowing() {
		return movie;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		 this.availableSeats = availableSeats;	
	}
	
}
