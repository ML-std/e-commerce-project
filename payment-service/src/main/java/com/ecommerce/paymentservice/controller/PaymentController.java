package com.ecommerce.paymentservice.controller;

import com.ecommerce.paymentservice.dto.PaymentReceiptBaseDto;
import com.ecommerce.paymentservice.model.Cart;
import com.ecommerce.paymentservice.model.PaymentReceipt;
import com.ecommerce.paymentservice.model.Product;
import com.ecommerce.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.h2.util.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/payment-service")
@RequiredArgsConstructor
@RestController
public class PaymentController {
    private final PaymentService paymentService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public PaymentReceipt addPaymentReceipt(@RequestBody PaymentReceiptBaseDto paymentReceiptBaseDto){
        ResponseEntity<Cart> cartResponseEntity = new RestTemplate().getForEntity("http://localhost:8765/cart-service/" + paymentReceiptBaseDto.getOwnerEmail(), Cart.class);
        if(paymentReceiptBaseDto.isPaid()){
            new RestTemplate().put("http://localhost:8765/cart-service/" + paymentReceiptBaseDto.getOwnerEmail(),"" );
        }
        return paymentService.addPaymentReceipt(cartResponseEntity.getBody().getProducts(), paymentReceiptBaseDto.isPaid());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PaymentReceipt> getPaymentReceipts(){
        return paymentService.getPaymentReceipts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PaymentReceipt getPaymentReceipt(@PathVariable(value = "id") Long id){
        return paymentService.getPaymentReceipt(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletePaymentReceipt(@PathVariable(value = "id") Long id){
        paymentService.deletePaymentReceipt(id);

    }



}
