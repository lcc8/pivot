package com.example.springboot.purchase.persistant;

import com.example.springboot.purchase.model.PurchaseRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class Storage {
    private List<PurchaseRequest> purchaseRequests = new ArrayList<>();
    private List<Budget> budgets = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    public List<PurchaseRequest> getPurchaseRequests() {
        return purchaseRequests;
    }

    public void storePurchase(PurchaseRequest purchaseRequest){
        purchaseRequests.add(purchaseRequest);
    }

    public Long getNextId() {
        return id.incrementAndGet();
    }
}
