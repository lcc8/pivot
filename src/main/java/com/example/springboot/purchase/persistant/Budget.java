package com.example.springboot.purchase.persistant;

import java.math.BigDecimal;

public record Budget(Long id, BigDecimal totalBudget, BigDecimal currentExpenditure, String lastUpdatedDate) {
}
