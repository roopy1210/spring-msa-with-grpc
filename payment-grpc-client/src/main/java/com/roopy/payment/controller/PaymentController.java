package com.roopy.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roopy.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Value("${server.port}")
    private int port;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/approval")
    public Object order(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody HashMap<String,Object> param) throws Exception {

        // 결제 승인 요청
        Object retObj = paymentService.approvalPayment(param);

        return retObj;
    }

}
