package com.BusBookingbackend.service;

import com.BusBookingbackend.dao.EmailSenderServiceDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService implements EmailSenderServiceDao {
    private final JavaMailSender mailSender ;


    public MailService(JavaMailSender mailSender) {

        this.mailSender = mailSender;
    }

    @Value("$(Harmony Bus Pvt.Ltd)")
    private String fromMail;

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
    }
}
