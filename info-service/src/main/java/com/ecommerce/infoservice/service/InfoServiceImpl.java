package com.ecommerce.infoservice.service;

import com.ecommerce.infoservice.model.Info;
import com.ecommerce.infoservice.model.PaymentReceipt;
import com.ecommerce.infoservice.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InfoServiceImpl implements InfoService{

    private final JavaMailSender mailSender;
    private final InfoRepository infoRepository;

    @Override
    public Info sendEmail(PaymentReceipt paymentReceipt) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("mbarisege@gmail.com");
        mailMessage.setTo("mbarisege@gmail.com");//normally this should be replaced with paymentReceipt.getOwnerMail()
        mailMessage.setSubject("Receipt:" + paymentReceipt.getId());
        mailMessage.setText(paymentReceipt.toString());
        mailSender.send(mailMessage);
        Info info = new Info();
        info.setSubject(mailMessage.getSubject());
        info.setContext(mailMessage.getText());
        info.setPaymentReceipt(paymentReceipt);

        return infoRepository.save(info);

    }
}
