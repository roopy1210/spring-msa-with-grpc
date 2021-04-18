package com.roopy.payment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roopy.model.SquareResponse;
import com.roopy.payment.approval.ApprovalResponse;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class OutputStreamingResponse implements StreamObserver<ApprovalResponse> {

    private final Map<String, Object> map;
    private final CompletableFuture<Map<String, Object>> completableFuture;

    public OutputStreamingResponse(Map<String, Object> map, CompletableFuture<Map<String, Object>> completableFuture) {
        this.map = map;
        this.completableFuture = completableFuture;
    }

    @Override
    public void onNext(ApprovalResponse output) {
        this.map.put("aprovalNo", output.getAprovalNo());
        this.map.put("amt", output.getAmt());
    }

    @Override
    public void onError(Throwable throwable) {
        completableFuture.cancel(true);
    }

    @Override
    public void onCompleted() {
        completableFuture.complete(this.map);
    }
}
