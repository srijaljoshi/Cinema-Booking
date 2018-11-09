package app.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Customer")
public class Customer extends User {

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

    @Column
    int enrolledForPromotions;
    
    @Column
    String token;
    
    @Column
    int statusID;

    ArrayList<Address> addresses;

    ArrayList<Booking> bookings;


    public Customer() {

    }


    /**
     * This method returns a customer to be cached for a singleton session
     *
     * @return new Customer
     */
    @Bean
    @Scope("singleton")
    public Customer customerSingleton() {
        return new Customer();
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

    public int getEnrolledForPromotions() {
        return enrolledForPromotions;
    }

    public void setEnrolledForPromotions(int enrolledForPromotions) {
        this.enrolledForPromotions = enrolledForPromotions;
    }


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public int getStatusID() {
		return statusID;
	}


	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

    

}
