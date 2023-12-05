package com.example.springboot.purchase.service;

import com.example.springboot.purchase.model.PurchaseRequest;

import java.util.List;

public interface PurchaseService {
    String processPurchase(PurchaseRequest purchaseRequest);

    List<PurchaseRequest> getPurchases();
}
