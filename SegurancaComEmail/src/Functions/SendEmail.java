/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author guilh
 */
public class SendEmail {
    
   public void sendEmail(String email, String key){
       
        String host = "mail.savioliti.com.br";
        
        String port = "587"; 
        String username = "aulajava@savioliti.com.br"; 
        String password = "@1b2c3d4e5"; 

        // Configurações para iniciar a sessão
        
        Properties props = new Properties();
        
        props.put("mail.smtp.ssl.trust", "mail.savioliti.com.br");
        //props.put("mail.smtp.auth.mechanisms", "XOAUTH2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
       

        // Criando uma sessão com autenticação
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Criando uma mensagem de e-mail
            Message message;
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Password Authentication");
            
            message.setText("Thank you, your password is: " + key);
            // Enviando o e-mail
            Transport.send(message);

            System.out.println("E-mail sent successfully!");
            
            
        
        } catch (MessagingException e) {
            System.err.println("Error sending the email:" + e.getMessage());
        }
   }
    
}
