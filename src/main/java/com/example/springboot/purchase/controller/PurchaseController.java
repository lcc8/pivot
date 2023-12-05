package com.example.springboot.purchase.controller;

import com.example.springboot.purchase.model.PurchaseRequest;
import com.example.springboot.purchase.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/purchase")
    List<PurchaseRequest> getPurchases() {
        return purchaseService.getPurchases();
    }


    @PostMapping(path="/purchase", produces = MediaType.APPLICATION_JSON_VALUE)
    String newInvoice(@RequestBody @Valid PurchaseRequest purchaseRequest) {
        // client api -> application
        return purchaseService.processPurchase(purchaseRequest);
    }
    // /purchase/decline/{id} /purchase/approve/{id}
}
