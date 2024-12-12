package com.example.messenger.MessengerApplication.listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @Autowired
    private JavaMailSender mailSender;

    @KafkaListener(topics = "messenger", groupId = "mailer-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("chakrabortyannie20@gmail.com");
        email.setSubject("Subject Text");
        email.setText(message);
        mailSender.send(email);
    }
}
