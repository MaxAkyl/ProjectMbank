package mbank.controllers;

import lombok.RequiredArgsConstructor;
import mBankProject.services.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    //check
    //pay
    @PostMapping
    public String checkPayment(@RequestBody String request) {
        return paymentService.payment(request);
    }


}
