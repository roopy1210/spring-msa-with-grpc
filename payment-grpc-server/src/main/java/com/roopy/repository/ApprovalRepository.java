package com.roopy.repository;

import com.roopy.domain.PaymentApproval;
import org.springframework.data.repository.Repository;

public interface ApprovalRepository extends Repository<PaymentApproval, String>, ApprovalRepositoryCustom {
}
