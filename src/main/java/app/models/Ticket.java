
public class Ticket {

	enum AgeCategory { CHILD, ADULT, SENIOR }	//http://mrbool.com/how-to-create-enum-class-in-java/26900
	
	private double price;
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}
