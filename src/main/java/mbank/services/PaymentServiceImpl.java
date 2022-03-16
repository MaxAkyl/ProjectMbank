package mbank.services;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import mBankProject.dto.PaymentRequest;
import mBankProject.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Slf4j
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Override
    public String payment(String request) {
        //convert json to object
        Gson gson = new Gson();
        PaymentRequest paymentRequest = gson.fromJson(request, PaymentRequest.class);

//        switch (paymentRequest.getCommand()) {
//            case CHECK -> {
//
//            }
//            case PAY -> {
//
//            }
//        }
        return null;
    }
}
