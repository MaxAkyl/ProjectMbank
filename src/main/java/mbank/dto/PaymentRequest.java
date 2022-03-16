package mbank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private String accountNumber;
    private BigDecimal amount;
    private Command command;
}
