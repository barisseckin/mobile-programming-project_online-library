package com.demo.onlinelibrary.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender javaMailSender;

    public void send(String to, String title, String body) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setText(body);
        mailMessage.setSubject(title);
        mailMessage.setTo(to);
        mailMessage.setFrom("library-app");

        javaMailSender.send(mailMessage);
    }
}
