package com.pool.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.amqp.dsl.Amqp;

import java.io.IOException;

@Configuration
public class ComradeIntegretionConfig {

    private final String queueName="destination";

    @Bean
    public Exchange exchange(){
        return ExchangeBuilder.directExchange(this.queueName).build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(this.queue()).to(this.exchange()).with(this.queueName).noargs();
    }
    @Bean
    public Queue queue(){
        return QueueBuilder.durable(this.queueName).build();
    }

    @Bean
    public IntegrationFlow inboundIntegrationFlow(ConnectionFactory connectionFactory) throws IOException {
        //@Value("${HOME}/Desktop/input")Resource fileResource
        //var inboundFileAdapatar= Files.inboundAdapter(fileResource.getFile()).autoCreateDirectory(true);
        var inboundRabbitMq=Amqp.inboundAdapter(connectionFactory,this.queueName);
        return IntegrationFlow.from(inboundRabbitMq)
                .handle((payload, headers) -> {
                    System.out.println("Object "+payload);
                    headers.forEach((s, o) -> System.out.println("Key="+s+",o="+o));
                    return null;
                }).get();
    }

}
