package org.example.spring.boot.configuration.controllers;

import org.example.spring.boot.configuration.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    
    private final MessageService messageService;
    
    public MessageController(@Qualifier("messageService") MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/list")
    public String listMessages() {
        messageService.serviceList();
        return "listMessage";
    }
}
