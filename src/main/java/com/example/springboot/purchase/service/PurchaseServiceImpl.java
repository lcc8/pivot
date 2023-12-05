package com.example.springboot.purchase.service;

import com.example.springboot.purchase.model.PurchaseRequest;
import com.example.springboot.purchase.model.PurchaseStatus;
import com.example.springboot.purchase.persistant.Storage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private List<ValidateRequestService> validateRequestServices;
    private Storage storage;

    public PurchaseServiceImpl(List<ValidateRequestService> validateRequestServices, Storage storage) {
        this.validateRequestServices = validateRequestServices;
        this.storage = storage;
    }

    @Override
    public String processPurchase(PurchaseRequest purchaseRequest) {
        purchaseRequest.setStatus(PurchaseStatus.PENDING.name());
        // good to store here before processing
        purchaseRequest.setId(storage.getNextId());

        for(ValidateRequestService validateRequestService : validateRequestServices){
            if(!validateRequestService.isValidate(purchaseRequest)){
                purchaseRequest.setStatus(PurchaseStatus.DECLINED.name());
                storage.storePurchase(purchaseRequest);
                return getPurchaseResponse(purchaseRequest);
            }
        }
        purchaseRequest.setStatus(PurchaseStatus.APPROVED.name());
        storage.storePurchase(purchaseRequest);
        return getPurchaseResponse(purchaseRequest);
    }

    @Override
    public List<PurchaseRequest> getPurchases() {
        return storage.getPurchaseRequests();
    }

    private String getPurchaseResponse(PurchaseRequest purchaseRequest) {
        return "Your purchase id" + purchaseRequest.getId() + " has been " + purchaseRequest.getStatus();
    }

}
