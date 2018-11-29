package tools;

import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import app.models.Booking;

@Service
public class CustomerTools {
	public String generateToken() {
		SecureRandom random = new SecureRandom();
    	byte bytes[] = new byte[20];
    	random.nextBytes(bytes);
    	String token = bytes.toString();
    	System.out.println("token: " + token);
    	return token;
	}
	
	public void sendEmail(String to, String token, int id) {
		//Get properties object    
		System.out.println("entering id: " + id);
		String from = "fortheTeamProject@gmail.com";
		String password = "drinkMoreBleach";
		String sub = "Confirmation registration: please click on the link below to confirm registration for project website";
		String msg = "click on link to complete registration: http://localhost:8080/u/confirm?id=" + Integer.toString(id) + "&token=" + token;
		System.out.println("MESSAGE: " + msg);
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);
         }    
        });       
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);} 		
	}
	
	public void sendPasswordReset(String to, String token, int id) {
		//Get properties object    
				String from = "fortheTeamProject@gmail.com";
				String password = "drinkMoreBleach";
				String sub = "Password reset request";
				String msg = "click on link to reset password: http://localhost:8080/u/reset-password?id=" + Integer.toString(id) + "&token=" + token;
				System.out.println("MESSAGE: " + msg);
		        Properties props = new Properties();    
		        props.put("mail.smtp.host", "smtp.gmail.com");    
		        props.put("mail.smtp.socketFactory.port", "465");    
		        props.put("mail.smtp.socketFactory.class",    
		                  "javax.net.ssl.SSLSocketFactory");    
		        props.put("mail.smtp.auth", "true");    
		        props.put("mail.smtp.port", "465");    
		        //get Session   
		        Session session = Session.getDefaultInstance(props,    
		         new javax.mail.Authenticator() {    
		         protected PasswordAuthentication getPasswordAuthentication() {    
		         return new PasswordAuthentication(from,password);
		         }    
		        });       
		        try {    
		         MimeMessage message = new MimeMessage(session);    
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
		         message.setSubject(sub);    
		         message.setText(msg);    
		         //send message  
		         Transport.send(message);    
		         System.out.println("message sent successfully"); 
		        } catch (MessagingException e) {throw new RuntimeException(e);} 
	}
	
	public void sendBookingConfirmation(String to, Booking booking) {
		//Get properties object    
				String from = "fortheTeamProject@gmail.com";
				String password = "drinkMoreBleach";
				String sub = "Booking Confirmation";
				String msg = "Confirmation for booking: " + booking.getId() + " for a total of " + booking.getTotalPrice() + ".\nThe date for the movie is: " + booking.getShowtime().getDate() + " at " + booking.getShowtime().getTime();
				System.out.println("MESSAGE: " + msg);
		        Properties props = new Properties();    
		        props.put("mail.smtp.host", "smtp.gmail.com");    
		        props.put("mail.smtp.socketFactory.port", "465");    
		        props.put("mail.smtp.socketFactory.class",    
		                  "javax.net.ssl.SSLSocketFactory");    
		        props.put("mail.smtp.auth", "true");    
		        props.put("mail.smtp.port", "465");    
		        //get Session   
		        Session session = Session.getDefaultInstance(props,    
		         new javax.mail.Authenticator() {    
		         protected PasswordAuthentication getPasswordAuthentication() {    
		         return new PasswordAuthentication(from,password);
		         }    
		        });       
		        try {    
		         MimeMessage message = new MimeMessage(session);    
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
		         message.setSubject(sub);    
		         message.setText(msg);    
		         //send message  
		         Transport.send(message);    
		         System.out.println("message sent successfully"); 
		        } catch (MessagingException e) {throw new RuntimeException(e);} 
	}
}
