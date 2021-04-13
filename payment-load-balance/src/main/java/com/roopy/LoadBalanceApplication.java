package com.roopy;

import com.roopy.loadbalance.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name="/payment-service", configuration = RibbonConfiguration.class)
public class LoadBalanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate template() {
        return  new RestTemplate();
    }

}
