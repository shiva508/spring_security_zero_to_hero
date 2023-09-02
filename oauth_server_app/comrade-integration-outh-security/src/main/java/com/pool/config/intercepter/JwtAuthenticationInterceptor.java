package com.pool.config.intercepter;

import com.pool.model.User;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.util.Assert;

public class JwtAuthenticationInterceptor implements ChannelInterceptor {
    private final String headerName;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    public JwtAuthenticationInterceptor(String headerName, JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.headerName = headerName;
        this.jwtAuthenticationProvider=jwtAuthenticationProvider;
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        var jwtToken=(String)message.getHeaders().get(this.headerName);
        Assert.hasText(jwtToken,"Jwt token should not not empty");
        var authenticate=this.jwtAuthenticationProvider.authenticate (new BearerTokenAuthenticationToken(jwtToken));
        if (authenticate != null && authenticate.isAuthenticated()){
            var user=new User(authenticate.getName());
            var upa= UsernamePasswordAuthenticationToken.authenticated(user,null, AuthorityUtils.NO_AUTHORITIES);
            return MessageBuilder
                                .fromMessage(message)
                                .setHeader(this.headerName, upa)
                                .build();
        }
        return MessageBuilder.fromMessage(message).setHeader(this.headerName, null).build();
    }
}
