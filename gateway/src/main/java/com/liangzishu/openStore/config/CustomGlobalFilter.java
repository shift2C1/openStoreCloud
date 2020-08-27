package com.liangzishu.openStore.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.multipart.Part;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.Map;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;

public class CustomGlobalFilter implements GlobalFilter, Ordered {
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.out.println("自定义全局过滤器");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        ApplicationContext applicationContext = exchange.getApplicationContext();
        Map<String, Object> attributeMap = exchange.getAttributes();
        Mono<MultiValueMap<String, String>> formData = exchange.getFormData();
        LocaleContext localeContext = exchange.getLocaleContext();
        Mono<MultiValueMap<String, Part>> multipartData = exchange.getMultipartData();
        Mono<Principal> principal = exchange.getPrincipal();
        Mono<WebSession> session = exchange.getSession();
        ServerWebExchange.Builder mutate = exchange.mutate();
        return chain.filter(exchange);
    }

    public int getOrder() {
        return -1;
    }
}
