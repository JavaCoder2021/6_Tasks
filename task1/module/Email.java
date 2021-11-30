package by.epam.tasks.task1.module;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
//import javax.activation.*;

public class Email {
   
    public static void Send(String to, String Text) {

        String from = "admin@myBookLibrary.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Letter subject");
            message.setText(Text);
            Transport.send(message);
            System.out.println("Message sent successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
      
   } 
    
}
