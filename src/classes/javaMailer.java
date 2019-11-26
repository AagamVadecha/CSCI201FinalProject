package classes;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class javaMailer extends Thread {
    String emailTo;
    String firstName;
    String className;
    public javaMailer(String email, String firstName, String className){
        emailTo = email;
        this.firstName = firstName;
        this.className = className;
        this.start();
    }

    public void run(){
        // Recipient's email ID needs to be mentioned.
        String to = emailTo;//change accordingly

        // Sender's email ID needs to be mentioned
        String from = "ohscheduleemailer@gmail.com";//change accordingly
        final String username = "ohscheduleemailer";//change accordingly
        final String password = "vitalyKresin";//change accordingly

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Next In Office Hour Queue");

            // Now set the actual message
            message.setText("Hello, " + firstName + "\n\nYou are next in the queue for " + className +"" +
                   ". Please come to your office hour location soon.");

            // Send message
            Transport.send(message);

//            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
