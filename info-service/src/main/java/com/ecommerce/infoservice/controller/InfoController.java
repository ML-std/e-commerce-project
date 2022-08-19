package com.ecommerce.infoservice.controller;

import com.ecommerce.infoservice.model.Info;
import com.ecommerce.infoservice.model.PaymentReceipt;
import com.ecommerce.infoservice.service.InfoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/info-service")
@RequiredArgsConstructor
@RestController
public class InfoController {

    private final InfoService infoService;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{receiptId}")
    public Info sendEmail(@PathVariable(value = "receiptId") Long receiptId){
        ResponseEntity<PaymentReceipt> paymentReceiptResponseEntity = new RestTemplate().getForEntity("http://localhost:8765/payment-service/" + receiptId, PaymentReceipt.class);
        return infoService.sendEmail(paymentReceiptResponseEntity.getBody());
    }
}
