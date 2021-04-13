package com.roopy.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalanceController {

    @Autowired
    private RestTemplate template;

    @GetMapping("/unary/{number}")
    public Object getResponseUnary(@PathVariable int number) {
        return template.getForObject("http://payment-service/unary/"+number, Object.class);
    }

    @GetMapping("/stream/{number}")
    public Object getResponseStream(@PathVariable int number) {
        return template.getForObject("http://payment-service/stream/"+number, Object.class);
    }
}
