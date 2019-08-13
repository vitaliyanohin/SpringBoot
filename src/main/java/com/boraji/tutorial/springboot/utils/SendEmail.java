package com.boraji.tutorial.springboot.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

  private static final Logger LOGGER = Logger.getLogger(SendEmail.class);

  public static void sendCode(String email, String code, Double totalPrice) {

    final String username = "testuserma1488@gmail.com";
    final String password = "TestUser1488";

    Properties properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true"); //TLS

    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });
    try {
      Message message = new MimeMessage(session);
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
      message.setSubject("Confirm CODE");
      message.setText("Your order for: " + totalPrice + "UAH\n"
              + "Your Confirm CODE: " + code );
      Transport.send(message);
    } catch (MessagingException e) {
       LOGGER.log(Level.ERROR, "Failed to send email: ", e);
    }
  }
}
