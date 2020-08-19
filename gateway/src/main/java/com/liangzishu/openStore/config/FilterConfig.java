package com.liangzishu.openStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public CustomGlobalFilter customGlobalFilter(){
        return new CustomGlobalFilter();
    }
}
