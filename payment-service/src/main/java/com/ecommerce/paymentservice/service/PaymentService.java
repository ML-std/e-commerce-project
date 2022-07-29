package com.ecommerce.paymentservice.service;

import com.ecommerce.paymentservice.dto.PaymentReceiptBaseDto;
import com.ecommerce.paymentservice.model.PaymentReceipt;
import com.ecommerce.paymentservice.model.Product;

import java.util.List;

public interface PaymentService {
    List<PaymentReceipt> getPaymentReceipts();

    PaymentReceipt addPaymentReceipt(List<Product> productList, boolean paid);

    PaymentReceipt getPaymentReceipt(Long id);

    void deletePaymentReceipt(Long id);
}
