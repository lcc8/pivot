package com.example.springboot.purchase.service;

import com.example.springboot.purchase.model.PurchaseRequest;
import com.example.springboot.purchase.persistant.Storage;
import org.springframework.stereotype.Service;

@Service
public class ValidateBudgetService implements ValidateRequestService {
    private Storage storage;

    public ValidateBudgetService(Storage storage) {
        this.storage = storage;
    }

    @Override
    public boolean isValidate(PurchaseRequest purchaseRequest) {
        // validation for budget
        return true;
    }
}
