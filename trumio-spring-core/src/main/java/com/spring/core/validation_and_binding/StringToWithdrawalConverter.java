package com.spring.core.validation_and_binding;

import org.springframework.core.convert.converter.Converter;

public class StringToWithdrawalConverter implements Converter<String, WithdrawalRequest> {

    @Override
    public WithdrawalRequest convert(String source) {
        // Parse the string "101:500.0"
        String[] parts = source.split(":");
        int id = Integer.parseInt(parts[0]);
        double amt = Double.parseDouble(parts[1]);
        
        return new WithdrawalRequest(id, amt);
    }
}