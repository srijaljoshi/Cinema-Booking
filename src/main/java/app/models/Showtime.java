package app.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Showtime {
    private String movie;
    private int id;
    private String time;
    private String date;
    
    public Showtime() {
    	this.movie = null;
    	this.id = -1;
    	this.time = null;
    	this.date = null;
    }

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
    
}
