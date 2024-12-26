package com.sudhamsh.getting_started_with_spring.DTO;

public class PaymentRequest {
    private long paymentId;
    public long getPaymentId(){
        return paymentId;
    }
    public void setPaymentId(Long id) {
        this.paymentId = id;
    }
}
