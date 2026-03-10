package com.spring.core.validation_and_binding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

@Service
@Validated // This enables method-level validation
public class AtmService {



//    Spring will automatically find your converter and use it to turn a property string into your object.
    // Spring looks at the String "101:500.0", finds your Converter,
    // and injects a fully formed WithdrawalRequest!
    @Value("102:800.0")//accountId:amount (e.g., "101:500.0").
    private WithdrawalRequest defaultRequest;



    public void process(@Valid WithdrawalRequest request) {
        // If we reach here, the data is 100% valid.
        System.out.println(">> SUCCESS: Processing $" + request.getAmount() +
                " for Account #" + request.getAccountId());
    }

    public WithdrawalRequest getDefaultRequest() {
        return defaultRequest;
    }
}