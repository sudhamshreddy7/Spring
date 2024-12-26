package com.sudhamsh.getting_started_with_spring.Repository;

import com.sudhamsh.getting_started_with_spring.DTO.PaymentRequest;
import com.sudhamsh.getting_started_with_spring.Entity.PaymentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {
    public PaymentEntity getPaymentById(PaymentRequest internalRequestObj) {
        PaymentEntity paymentEntity = executeQueury(internalRequestObj);
        return paymentEntity;
    }
    PaymentEntity executeQueury(PaymentRequest paymentRequest){
        //connect to DB
        PaymentEntity payment = new PaymentEntity();
        payment.setId(paymentRequest.getPaymentId());
        payment.setPaymentAmount(100);
        payment.setPaymentCurrency("INR");
        return payment;
    }

}
