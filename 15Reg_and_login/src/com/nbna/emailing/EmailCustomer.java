package com.nbna.emailing;


import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
 
public class EmailCustomer {
 
	public EmailCustomer(HttpServletRequest request) {
 
		final String username = "SalesAndServiceProdcution@gmail.com";
		final String password = "secrect123";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
			
			String user = request.getParameter("name");
			String to_email = request.getParameter("email");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("a"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to_email));
			message.setSubject("Welcome to Sai's Website");
			message.setText("Hi"+ user+","
				+ "\n\n I developed this code as a proof of concept for the alert system that you were planning");
 
			Transport.send(message);
 
			System.out.println("Sent message");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}