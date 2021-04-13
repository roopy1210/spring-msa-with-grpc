package com.roopy.benchmark.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class BenchmarkService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Object getUnaryResponse(int number){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= number ; i++) {
            ResponseEntity<Integer> responseEntity = this.restTemplate.getForEntity(String.format("http://localhost:8090/unary/%d", i), Integer.class);
            map.put(i, responseEntity.getBody());
        }
        return map;
    }

}
