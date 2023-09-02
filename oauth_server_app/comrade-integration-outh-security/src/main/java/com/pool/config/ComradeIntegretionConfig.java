package com.pool.config;

import com.pool.config.amqp.AmqpCommonConfig;
import com.pool.config.intercepter.JwtAuthenticationInterceptor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.DirectChannelSpec;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.messaging.access.intercept.AuthorizationChannelInterceptor;
import org.springframework.security.messaging.context.SecurityContextChannelInterceptor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;

@Configuration
public class ComradeIntegretionConfig {

    private final AmqpCommonConfig amqpCommonConfig;

    private final String queueName="destination-1";

    private final String headerName="Authorization";

    public ComradeIntegretionConfig(AmqpCommonConfig amqpCommonConfig) {
        this.amqpCommonConfig = amqpCommonConfig;
    }

    @Bean
  public Exchange exchange() {
       return ExchangeBuilder.directExchange(this.queueName).build();
   }

    @Bean
   public Binding binding() {
        return BindingBuilder.bind(this.queue()).to(this.exchange()).with(this.queueName).noargs();
    }

    @Bean
   public Queue queue() {
        return QueueBuilder.durable(this.queueName).build();
    }


    @Bean
    public IntegrationFlow inboundMsgFlow(MessageChannel inboundMsg, ConnectionFactory connectionFactory) throws Exception {
        var amqpInboundAdapter = Amqp.inboundAdapter(connectionFactory, this.queueName);
        return IntegrationFlow
                .from(amqpInboundAdapter)
                .channel(inboundMsg)
                .get();

    }

    @Bean
   public IntegrationFlow loggingInboundFlow(MessageChannel inboundMsg) {
        return IntegrationFlow
                .from(inboundMsg)
                .handle((payload, headers) -> {
                    System.out.println("got a new file whose contents are %s".formatted(payload));
                    headers.forEach((key, value) -> System.out.println(key + '=' + value));
                    return null;
                })
                .get();
    }


    @Bean
    public DirectChannelSpec inboundMsg(JwtAuthenticationProvider jwtAuthenticationProvider) {
        return MessageChannels
                .direct()
                .interceptor(
                        new JwtAuthenticationInterceptor(this.headerName, jwtAuthenticationProvider),
                        new SecurityContextChannelInterceptor(this.headerName),
                        new AuthorizationChannelInterceptor(AuthenticatedAuthorizationManager.authenticated())
                );
    }

}
