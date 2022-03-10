package com.icreon.demo.service;



import java.util.Properties;



import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import org.springframework.stereotype.Service;
@Service
public class Emailservice {
	
	public boolean sendEmail(String subject,String message,String to) throws MessagingException {
		
		boolean f=false;
		
		String from="vinayaknikam60@gmail.com";
		
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","8080");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		Session session=Session.getInstance(properties,new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("vinayaknikam60@gmail.com","vinayak@47");
				
			}
		});
		session.setDebug(true);
		
		MimeMessage m=new MimeMessage(session);
		m.setFrom(from);
		 
		m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		
		m.setSubject(subject);
		
		m.setText(message);
		
		Transport.send(m);
		
		
		System.out.println("sent success....");
		
		 f=true;
		
		 return f;
		
		
	}

}
