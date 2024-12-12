package com.example.messenger.MessengerApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody String message) {
        kafkaTemplate.send("messenger", message);
        return "Message sent!";
    }
}
