package com.example.springboot.purchase.model;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseRequest {
    private Long id;
    private String status;
    @NotNull
    private String description;
    @NotNull
    private PurchaseCategory category;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private String issueDate;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public PurchaseCategory getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getIssueDate() {
        return issueDate;
    }
}
