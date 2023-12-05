package com.example.springboot.purchase.model;

public class PurchaseResponse {
    private Long id;
    private String status;
    private String message;

    public PurchaseResponse(Long id, String status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }
}
