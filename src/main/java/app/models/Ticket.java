package app.models;

public class Ticket {


    private int category;
    private String seatLocation;
    private Seat seat;
    private double price;
    
    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(int category) {
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

	public String getSeatLocation() {
		return seatLocation;
	}

	public void setSeatLocation(String seatLocation) {
		this.seatLocation = seatLocation;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}