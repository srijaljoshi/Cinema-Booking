import java.sql.Time;
import java.util.Date;

public class Showtime {
	private MovieShowing movie;
	private SeatShowtime sst;
	private int id;
	private Time time;
	private Date date;
	
	public Showtime(Time time, Date date) {
		this.time = time;
		this.date = date;
	}
	
	public void setMovieShowing(MovieShowing movie) {
		this.movie = movie;
	}
	
	public void setSeatShowtime(SeatShowtime sst) {
		this.sst = sst;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public Date getShowDate() {
		return date;
	}
	public void setShowDate(Date date) {
		date = movie.getShowDate();
		this.date = date;
	}
	
	public Time getShowTime() {
		return time;
	}
	public void setShowTime(Time time) {
		this.time = time;
	}
}
