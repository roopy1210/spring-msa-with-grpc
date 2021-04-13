package com.roopy.benchmark.controller;

import com.roopy.benchmark.service.BanchmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BenchmarkController {

    @Autowired
    private BanchmarkService banchmarkService;

    @GetMapping("/unary/{number}")
    public Integer getSquareUnary(@PathVariable int number){
        return banchmarkService.findSquare(number);
    }

}
