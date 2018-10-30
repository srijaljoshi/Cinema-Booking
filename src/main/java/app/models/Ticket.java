package app.models;

public class Ticket {

	
	private double price;
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}

enum AgeCategory { 
	CHILD, ADULT, SENIOR; 
}
