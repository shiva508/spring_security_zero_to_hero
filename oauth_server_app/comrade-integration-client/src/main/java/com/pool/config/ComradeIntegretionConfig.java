package com.pool.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.DirectChannelSpec;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;

@Configuration
public class ComradeIntegretionConfig {

    private final String queueName="destination-1";

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

    @Bean("outbound")
    public DirectChannelSpec outbound(){
        return MessageChannels.direct();
    }

    @Bean
    public IntegrationFlow outboundIntegrationFlow(AmqpTemplate amqpTemplate){
        var amqpOutboundAdapter= Amqp.outboundAdapter(amqpTemplate)
                                     .routingKey(this.queueName);
        return IntegrationFlow.from( outbound())
                              .handle(amqpOutboundAdapter)
                              .get();
    }

}
