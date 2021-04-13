package com.roopy.benchmark.service;

import org.springframework.stereotype.Service;

@Service
public class BanchmarkService {

    public Integer findSquare(int number) {
        return number * number;
    }

}
