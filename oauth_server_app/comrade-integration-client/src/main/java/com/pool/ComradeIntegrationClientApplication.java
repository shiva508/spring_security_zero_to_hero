package com.pool;

import com.pool.model.Chat;
import com.pool.service.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
public class ComradeIntegrationClientApplication {

    private final MessageService messageService;

    public ComradeIntegrationClientApplication(MessageService messageService) {
        this.messageService = messageService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ComradeIntegrationClientApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(@Qualifier("outbound") MessageChannel outbound){
        return  args -> {
            Chat chat=new Chat("Hello Nithya!!!!!!");
            messageService.sendMessageWithToken(chat);
        };
    }
}
