package com.example.springboot.purchase.service;

import com.example.springboot.purchase.model.PurchaseRequest;

public interface ValidateRequestService {
    boolean isValidate(PurchaseRequest purchaseRequest);
}
