package com.example.springboot;

import com.example.springboot.purchase.service.ValidatePurchaseService;
import com.example.springboot.purchase.service.ValidateRequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidateRequestServiceUTest {
    private ValidateRequestService classToTest;

    @BeforeEach
    public void setup(){
        classToTest = new ValidatePurchaseService();
    }

    @Test
    public void shouldValidateRequest(){

    }
}