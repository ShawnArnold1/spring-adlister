package com.codeup.adlister.services;

import com.codeup.adlister.models.Post;
import com.codeup.adlister.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


    @Service
    public class EmailService
    {

        @Autowired
        public JavaMailSender emailSender;

        @Value("${spring.mail.from}")
        private String from;

        public void prepareAndSend(String string, String subject, String body) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(from);
            msg.setTo(string);
//            msg.setTo(user.getEmail());
            msg.setSubject(subject);
            msg.setText(body);

            try{
                this.emailSender.send(msg);
            }
            catch (MailException ex) {
                // simply log it and go on...
                System.err.println(ex.getMessage());
            }
        }
    }
