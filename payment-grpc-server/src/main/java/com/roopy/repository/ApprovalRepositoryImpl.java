package com.roopy.repository;

import com.roopy.domain.PaymentApproval;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ApprovalRepositoryImpl implements ApprovalRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public PaymentApproval save(PaymentApproval paymentApproval) {
        return em.merge(paymentApproval);
    }
}
