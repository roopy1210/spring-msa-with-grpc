package com.roopy.repository;

import com.roopy.domain.PaymentApproval;

public interface ApprovalRepositoryCustom {

    /**
     * 결제 승인 내역 저장
     * 
     * @param paymentApproval
     * @return
     */
    public PaymentApproval save(PaymentApproval paymentApproval);
    
}
