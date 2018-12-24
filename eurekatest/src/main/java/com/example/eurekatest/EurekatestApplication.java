package com.example.eurekatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableEurekaServer
//@EnableElasticsearchRepositories
public class EurekatestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekatestApplication.class, args);
}

}

