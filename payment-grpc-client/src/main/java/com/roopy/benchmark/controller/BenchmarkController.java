package com.roopy.benchmark.controller;

import com.roopy.benchmark.service.BenchmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BenchmarkController {

    @Value("${server.port}")
    private int port;

    @Autowired
    private BenchmarkService benchmarkService;

    @GetMapping("/unary/{number}")
    public Object getResponseUnary(@PathVariable int number) {
        return benchmarkService.getSquareResponseUnary(number);
    }

    @GetMapping("/stream/{number}")
    public Object getResponseStream(@PathVariable int number) {
        return benchmarkService.getSquareResponseStream(number);
    }

}
