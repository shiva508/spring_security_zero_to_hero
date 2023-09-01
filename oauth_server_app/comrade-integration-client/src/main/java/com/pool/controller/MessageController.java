package com.pool.controller;

import com.pool.model.Chat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final DirectChannel outbound;
    public MessageController(@Qualifier("outbound") DirectChannel outbound) {
        this.outbound = outbound;
    }
    @PostMapping("/send")
    public Chat sendMessage(@RequestBody Chat chat){
       var message= MessageBuilder.withPayload(chat.getMessage()).build();
        outbound.send(message);
        return chat;
    }
}
