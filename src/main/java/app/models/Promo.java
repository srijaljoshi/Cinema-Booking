package app.models;

import java.util.Date;

public class Promo {
	
	private String code;
	private Date expirationDate;
	private double discountPercent;
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public double getDiscountPercent() {
		return discountPercent;
	}
	
}
