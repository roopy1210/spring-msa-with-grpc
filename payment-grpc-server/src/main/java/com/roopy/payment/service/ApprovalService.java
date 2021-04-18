package com.roopy.payment.service;

import com.roopy.domain.PaymentApproval;
import com.roopy.payment.approval.ApprovalRequest;
import com.roopy.payment.approval.ApprovalResponse;
import com.roopy.payment.approval.ApprovalServiceGrpc;
import com.roopy.repository.ApprovalRepository;
import com.roopy.util.DateUtil;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ApprovalService extends ApprovalServiceGrpc.ApprovalServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApprovalService.class);

    @Autowired
    private ApprovalRepository repository;

    /**+
     * 결제 승인 요청에 대한 승인 처리
     * 
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<ApprovalRequest> approvalPayment(StreamObserver<ApprovalResponse> responseObserver) {
        return new StreamObserver<ApprovalRequest>() {
            @Override
            public void onNext(ApprovalRequest request) {
                responseObserver.onNext(registerApproval(request));
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

    /**+
     * 결제승인 내역 저장
     * 
     * @param request
     * @return
     */
    private ApprovalResponse registerApproval(ApprovalRequest request) {
        LOGGER.info("결재번호 : {}, 결제금액 : {} ", request.getPaymentNo(), request.getAmt());

        String year = DateUtil.getCurrentYearAsString();
        String month = DateUtil.getCurrentMonthAsString();
        String day = DateUtil.getCurrentDayAsString();
        String hour = DateUtil.getCurrentHourAsString();
        String minute = DateUtil.getCurrentMinuteAsString();
        String second = DateUtil.getCurrentSecondAsString();

        String aprvalDtm = year + month + day + hour + minute + second;

        PaymentApproval paymentApproval = new PaymentApproval();
        paymentApproval.setAprvalNo(String.valueOf(RandomStringUtils.randomAlphanumeric(15)).toUpperCase());
        paymentApproval.setAprvalAmt(request.getAmt());
        paymentApproval.setAprvalDtm(aprvalDtm);

        paymentApproval = repository.save(paymentApproval);
        LOGGER.info("승인번호 : {}, 승인금액 : {} ", paymentApproval.getAprvalNo(), paymentApproval.getAprvalAmt());

        return ApprovalResponse.newBuilder()
                    .setAprovalNo(paymentApproval.getAprvalNo())
                    .setAmt(paymentApproval.getAprvalAmt())
                    .build();
    }
}