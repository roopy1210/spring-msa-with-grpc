package com.roopy.benchmark.service;

import com.roopy.model.SquareRequest;
import com.roopy.model.SquareResponse;
import com.roopy.model.SquareRpcGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BenchmarkService extends SquareRpcGrpc.SquareRpcImplBase {

    /**
     * Unary
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void findSquareUnary(SquareRequest request, StreamObserver<SquareResponse> responseObserver) {
        int number = request.getNumber();

        responseObserver.onNext(
                SquareResponse.newBuilder().setNumber(number).setResult(number * number).build()
        );
        responseObserver.onCompleted();
    }

    /**
     * Bi-Directional
     *
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<SquareRequest> findSquareBiStream(StreamObserver<SquareResponse> responseObserver) {
        return new StreamObserver<SquareRequest>() {

            @Override
            public void onNext(SquareRequest request) {
                int number = request.getNumber();
                SquareResponse response = SquareResponse.newBuilder()
                        .setNumber(number)
                        .setResult(number * number).build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
