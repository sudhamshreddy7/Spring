package com.sudhamsh.getting_started_with_spring.Controller;

import com.sudhamsh.getting_started_with_spring.DTO.PaymentRequest;
import com.sudhamsh.getting_started_with_spring.DTO.PaymentResponse;
import com.sudhamsh.getting_started_with_spring.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id){
        //mapping the incoming data to request DTO
        PaymentRequest internalRequestObj = new PaymentRequest();
        internalRequestObj.setPaymentId(id);
        //passing the internalReqObj to further layer for processing
        PaymentResponse paymentResponse = paymentService.getPaymentDetailsById(internalRequestObj);
        //return response dto
        return ResponseEntity.ok(paymentResponse);
    }
}
