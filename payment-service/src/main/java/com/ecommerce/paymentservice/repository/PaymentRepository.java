package com.ecommerce.paymentservice.repository;

import com.ecommerce.paymentservice.model.PaymentReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentReceipt,Long> {

}
