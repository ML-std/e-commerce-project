package com.ecommerce.infoservice.service;

import com.ecommerce.infoservice.model.Info;
import com.ecommerce.infoservice.model.PaymentReceipt;

public interface InfoService {
    Info sendEmail(PaymentReceipt paymentReceipt);
}
