package com.roopy.benchmark.service;

import com.roopy.model.SquareResponse;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class OutputStreamingResponse implements StreamObserver<SquareResponse> {

    private final Map<Integer, Integer> map;
    private final CompletableFuture<Map<Integer, Integer>> completableFuture;

    public OutputStreamingResponse(Map<Integer, Integer> map, CompletableFuture<Map<Integer, Integer>> completableFuture) {
        this.map = map;
        this.completableFuture = completableFuture;
    }

    @Override
    public void onNext(SquareResponse output) {
        this.map.put(output.getNumber(), output.getResult());
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
