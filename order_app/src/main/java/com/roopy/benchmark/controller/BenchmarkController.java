package com.roopy.benchmark.controller;

import com.roopy.benchmark.service.BenchmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**+
 * 성능 테스트를 위한 Controller
 */
@RestController
public class BenchmarkController {

    @Autowired
    private BenchmarkService benchmarkService;

    @Autowired
    private RestTemplate template;

    /**
     * RESTFul
     *
     * @param number
     * @return
     */
    @GetMapping("/rest/unary/square/{number}")
    public Object getRestResponseUnary(@PathVariable int number) {
        return this.benchmarkService.getUnaryResponse(number);
    }

    /**
     * gRPC
     *
     * @param number
     * @return
     */
    @GetMapping("/grpc/unary/square/{number}")
    public Object getGrpcResponseUnary(@PathVariable int number) {
        return template.getForObject("http://localhost:7000/unary/"+number, Object.class);
    }

    /**
     * gRPC
     *
     * @param number
     * @return
     */
    @GetMapping("/grpc/stream/square/{number}")
    public Object getResponseStream(@PathVariable int number) {
        return template.getForObject("http://localhost:7000/stream/"+number, Object.class);
    }

}
