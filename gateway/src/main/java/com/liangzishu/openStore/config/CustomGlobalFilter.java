package com.liangzishu.openStore.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;

public class CustomGlobalFilter implements GlobalFilter, Ordered {
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.out.println("自定义全局过滤器");
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
// get all metadata properties
        Map<String, Object> metadata = route.getMetadata();
// get a single metadata property
//        route.getMetadata(someKey);
        return chain.filter(exchange);
    }

    public int getOrder() {
        return -1;
    }
}
