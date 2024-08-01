package com.bo.cabmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CabMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabMvcApplication.class, args);
    }


    @Bean
    public RestClient restClient(){
        return RestClient.builder().baseUrl("https://petstore.swagger.io/v2").build();
    }
}
