package com.kayafirat.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailService {
	
	public String receipent;
	public String token;

	private static String myAccountEmail = "noreply@kayatech.me";
	private static String password = "bE99321605848#ASDx@";

	public MailService(String receipent,String token) {
		this.receipent = receipent;
		this.token = "http://localhost:8080/confirm?token="+token;
	}

	public void sendMail() throws Exception {

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.privateemail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareMessage(session);
		Transport.send(message);
	}

	private Message prepareMessage(Session session) throws UnsupportedEncodingException {

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail, "Kayatech.me"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipent));
			message.setSubject("Hata Servisi");
			message.setText(String.valueOf(token));

			return message;

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;

	}

}
