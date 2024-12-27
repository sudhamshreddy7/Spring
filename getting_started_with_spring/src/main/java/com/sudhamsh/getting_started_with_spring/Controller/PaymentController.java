package com.sudhamsh.getting_started_with_spring.Controller;

import com.sudhamsh.getting_started_with_spring.DTO.PaymentRequest;
import com.sudhamsh.getting_started_with_spring.DTO.User;
import com.sudhamsh.getting_started_with_spring.DTO.PaymentResponse;
import com.sudhamsh.getting_started_with_spring.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @InitBinder
    protected void initBinder(DataBinder binder){
        binder.registerCustomEditor(String.class,"client",new ClientNamePropertyEditor());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id, @RequestParam (name="client") String name){
        //mapping the incoming data to request DTO
        PaymentRequest internalRequestObj = new PaymentRequest();
        internalRequestObj.setPaymentId(id);
        //passing the internalReqObj to further layer for processing
        PaymentResponse paymentResponse = paymentService.getPaymentDetailsById(internalRequestObj);
        paymentResponse.setName(name);
        //return response dto
        return ResponseEntity.ok(paymentResponse);
    }
    @GetMapping(path = "/data")
    public String getData(@RequestBody User user){
        return (user.getName()+" "+user.getEmail()).toString();
    }
}
