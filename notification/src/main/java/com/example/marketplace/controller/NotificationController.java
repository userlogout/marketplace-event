package com.example.marketplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @GetMapping("/messages")
    public List<String> message() {
        return generateMessageList();
    }

    private List<String> generateMessageList() {
        return List.of("Message 1", "Message 2", "Message 3");
    }
}

