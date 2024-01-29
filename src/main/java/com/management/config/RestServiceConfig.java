package com.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestServiceConfig {

        @Bean
        public WebMvcConfigurer crosConfigurer(){
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry corsRegistry){
                    corsRegistry.addMapping("/**").allowedOrigins("http://localhost:5173").allowedMethods("*");
                }
            };
        }


}
