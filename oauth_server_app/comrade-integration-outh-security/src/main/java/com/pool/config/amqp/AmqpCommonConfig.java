package com.pool.config.amqp;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "comrade.amqp")
public class AmqpCommonConfig {
    private String queueName;
    private String headerName;
}
