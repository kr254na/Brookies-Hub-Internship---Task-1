package com.krishna.REST_API;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")   // all endpoints
                        .allowedOrigins("http://localhost:5500") // your frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // methods you allow
                        .allowedHeaders("*");
            }
        };
    }
}
