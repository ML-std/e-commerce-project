package com.ecommerce.paymentservice.util.mapper;

import com.ecommerce.paymentservice.dto.PaymentReceiptBaseDto;
import com.ecommerce.paymentservice.model.PaymentReceipt;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentReceiptMapper {
    PaymentReceipt paymentReceiptBaseDtoToPaymentReceipt(PaymentReceiptBaseDto paymentReceiptBaseDto);
}
