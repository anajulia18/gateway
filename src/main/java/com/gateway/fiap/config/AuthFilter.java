package com.gateway.fiap.config;

import com.gateway.fiap.filter.AuthenticationFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Override
    public GatewayFilter apply(AuthenticationFilter.Config config) {
        return (exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

            if (authHeader == null || authHeader.isEmpty()) {
                throw new MissingAuthorizationHeaderException("Missing authorization header");
            }

            // Continue with the filter chain if the header is present
            return chain.filter(exchange);
        };
    }

}