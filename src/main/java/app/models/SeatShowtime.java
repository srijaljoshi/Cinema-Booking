
public class SeatShowtime {

	private Seat seat;
	private Showtime showtime;
	private int seatId;
	private int showtimeId;
	private boolean taken;
	
	public SeatShowtime(int seatId, int showtimeId, boolean taken) {
		this.seatId = seatId;
		this.showtimeId = showtimeId;
		this.taken = taken;
	}
	
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}
	
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getSeatId() {
		return seatId;
	}
	
	public void setShowtimeId(int showtimeId) {
		this.showtimeId=showtimeId;
	}
	public int getShowtime() {
		return showtimeId;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	public boolean getTaken() {
		return taken;
	}
}
