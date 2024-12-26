package com.sudhamsh.getting_started_with_spring.Service;

import com.sudhamsh.getting_started_with_spring.DTO.PaymentRequest;
import com.sudhamsh.getting_started_with_spring.DTO.PaymentResponse;
import com.sudhamsh.getting_started_with_spring.Entity.PaymentEntity;
import com.sudhamsh.getting_started_with_spring.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj) {
        PaymentEntity paymentEntity = paymentRepository.getPaymentById(internalRequestObj);
        //map it to response obj
        PaymentResponse paymentResponse = mapModelToResponseDTO(paymentEntity);
        return paymentResponse;
    }
    private  PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity){
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentId(paymentEntity.getId());
        paymentResponse.setAmount(paymentEntity.getPaymentAmount());
        paymentResponse.setCurrency(paymentEntity.getPaymentCurrency());
        return paymentResponse;
    }
}
