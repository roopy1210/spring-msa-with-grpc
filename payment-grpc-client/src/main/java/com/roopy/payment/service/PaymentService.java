package com.roopy.payment.service;

import com.roopy.payment.approval.ApprovalRequest;
import com.roopy.payment.approval.ApprovalResponse;
import com.roopy.payment.approval.ApprovalServiceGrpc;
import com.roopy.payment.controller.PaymentController;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    @GrpcClient("payment")
    private ApprovalServiceGrpc.ApprovalServiceStub approvalServiceStub;

    public Object approvalPayment(Map<String,Object> param)  {
        LOGGER.info("결재번호 : {}, 결제금액 : {} ", param.get("paymentNo") , param.get("amt"));

        CompletableFuture<Map<String, Object>> completableFuture = new CompletableFuture<>();
        OutputStreamingResponse outputStreamingResponse = new OutputStreamingResponse(
                new HashMap<>(),
                completableFuture
        );

        StreamObserver<ApprovalRequest> approvalStream = null;

        try {
            approvalStream = approvalServiceStub.approvalPayment(outputStreamingResponse);
        } catch (StatusRuntimeException e) {
            throw new RuntimeException("RPC failed: " + e.getStatus());
        }

        ApprovalRequest request = ApprovalRequest.newBuilder()
                .setPaymentNo((String) param.get("paymentNo"))
                .setAmt((Integer) param.get("amt"))
                .build();

        approvalStream.onNext(request);
        approvalStream.onCompleted();

        return completableFuture;
    }

}
