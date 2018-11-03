package app.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Customer")
public class Customer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    @Column
	private String firstName;

    @Column
	private String lastName;

    @Column
    private String email;

    @Column
    private String password;


//    private CustomerStatus customerStatus;

    @Column
    boolean enrolledForPromotions;
	//CardPayment card;
	//Booking booking;
	//Address address;
	
	
//	enum  UserStatus{ACTIVE, INACTIVE, SUSPENDED};

    public Customer() {

    }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public CustomerStatus getCustomerStatus() {
//		return customerStatus;
//	}

//	public void setCustomerStatus(CustomerStatus customerStatus) {
//		this.customerStatus = customerStatus;
//	}

	public boolean isEnrolledForPromotions() {
		return enrolledForPromotions;
	}

	public void setEnrolledForPromotions(boolean enrolledForPromotions) {
		this.enrolledForPromotions = enrolledForPromotions;
	}
}
