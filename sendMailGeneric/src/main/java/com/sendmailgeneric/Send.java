/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sendmailgeneric;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;

public class Send {

    public static void main(String[] args) {
        // Configuración para enviar correos electrónicos (SMTP)
        final String username = "alertfenix1@gmail.com";//mail del correo creado para alertas
        final String password = "vwxymiulrfztoaxx";//contraseña del correo creado para alertas
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Crear sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear un objeto de mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Argomez120@gmail.com"));
            message.setSubject("Pruebas correo");
            message.setText("Hola desde java");

            // Enviar el correo electrónico
            Transport.send(message);
            System.out.println("Correo enviado con éxito");

            // Configuración para recibir correos electrónicos (POP3)
            props = new Properties();
            props.put("mail.pop3.host", "pop.gmail.com");
            props.put("mail.pop3.port", "995");
            props.put("mail.pop3.ssl.enable", "true");

             } catch (AddressException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
            
}
