package com.pool.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.pool.model.Chat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;

@Service
public class MessageService {
    private final DirectChannel outbound;
    private final RestTemplate restTemplate;

    @Value("${comrade.oauth2.client-id}")
    private String clientId;

    @Value("${comrade.oauth2.client-secret}")
    private String clientSecret;

    @Value("${comrade.oauth2.oauth-url}")
    private String oauthUrl;
    public MessageService(@Qualifier("outbound") DirectChannel outbound, RestTemplate restTemplate) {
        this.outbound = outbound;
        this.restTemplate=restTemplate;
    }

    public String getToken(){
        try {
            var headers = new HttpHeaders();
            headers.setBasicAuth(this.clientId, this.clientSecret);
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            var body = new LinkedMultiValueMap<String, String>();
            body.add("grant_type", "client_credentials");
            body.add("scope", "user.read");
            var httpEntity=new HttpEntity<>(body, headers);
            var response= restTemplate.postForEntity(oauthUrl, httpEntity, JsonNode.class);
            Assert.state(response.getStatusCode().is2xxSuccessful(), "the response needs to be 200x");
            return Objects.requireNonNull(response.getBody()).get("access_token").asText();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Chat sendMessage(Chat chat){
        var message= MessageBuilder.withPayload(chat.getMessage()).build();
        outbound.send(message);
        return chat;
    }

    public Chat sendMessageWithToken(Chat chat){
        var message= MessageBuilder.withPayload(chat.getMessage()).setHeader(HttpHeaders.AUTHORIZATION, getToken()).build();
        outbound.send(message);
        return chat;
    }
}
