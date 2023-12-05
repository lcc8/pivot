package com.example.springboot.purchase.service;

import com.example.springboot.purchase.model.PurchaseCategory;
import com.example.springboot.purchase.model.PurchaseRequest;
import com.example.springboot.purchase.model.PurchaseStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class ValidatePurchaseService implements ValidateRequestService{
    @Override
    public boolean isValidate(PurchaseRequest purchaseRequest) {
        if(!PurchaseStatus.PENDING.name().equals(purchaseRequest.getStatus()) ||
                !Arrays.stream(PurchaseCategory.values()).toList().contains(purchaseRequest.getCategory()) ||
                purchaseRequest.getAmount().compareTo(BigDecimal.ZERO) == -1
        // also want to check the issuedate
         ){
            System.out.println("Validation for purchase request failed.");
            return false;
        }
        return true;
    }
}
