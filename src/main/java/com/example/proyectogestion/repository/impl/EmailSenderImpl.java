package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.repository.EmailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Service
public class EmailSenderImpl implements EmailSender {

    @Override
    @Async
    public void send(String to, String message) {
        try{
            final String username = "userviolet@zohomail.com";
            final String password = "CEOofsleep1709";

            Properties propiedad = new Properties();
            propiedad.setProperty("mail.smtp.host", "smtp.zoho.com");
            propiedad.setProperty("mail.smtp.starttls.enable", "true");
            propiedad.setProperty("mail.smtp.port", "587");
            propiedad.setProperty("mail.smtp.auth", "true");

            Session sesion = Session.getDefaultInstance(propiedad);
            String asunto = "Activa tu cuenta: código de confirmación";
            MimeMessage mail = new MimeMessage(sesion);
            BodyPart codigo = new MimeBodyPart();
            codigo.setContent(message, "text/html");
            MimeMultipart partes = new MimeMultipart();
            partes.addBodyPart(codigo);
            mail.setFrom(new InternetAddress(username));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mail.setSubject(asunto);
            mail.setContent(partes);
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(username, password);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            System.out.println("Correo enviado");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
