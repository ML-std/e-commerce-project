package com.ecommerce.paymentservice.service;


import com.ecommerce.paymentservice.dto.PaymentReceiptBaseDto;
import com.ecommerce.paymentservice.model.PaymentReceipt;
import com.ecommerce.paymentservice.model.Product;
import com.ecommerce.paymentservice.repository.PaymentRepository;
import com.ecommerce.paymentservice.util.mapper.PaymentReceiptMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final PaymentReceiptMapper mapper;
    @Override
    public List<PaymentReceipt> getPaymentReceipts() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentReceipt addPaymentReceipt(List<Product> productList, boolean paid) {
        BigDecimal totalCost = BigDecimal.ZERO;
        PaymentReceipt paymentReceipt = new PaymentReceipt();
        paymentReceipt.setPaid(paid);
        for (Product product:productList) {
            log.info("product cost: " + product.getPrice());
            totalCost = totalCost.add(product.getPrice());
        }
        paymentReceipt.setTotalCost(totalCost);
        paymentReceipt.setProducts(productList);
        return paymentRepository.save(paymentReceipt);

    }

    @Override
    public PaymentReceipt getPaymentReceipt(Long id) {
        Optional<PaymentReceipt> paymentReceipt = paymentRepository.findById(id);
        if (paymentReceipt.isEmpty()){
            throw new EntityNotFoundException("Entity not found");
        }
        return paymentReceipt.get();
    }

    @Override
    public void deletePaymentReceipt(Long id) {
        paymentRepository.deleteById(id);
    }
}
