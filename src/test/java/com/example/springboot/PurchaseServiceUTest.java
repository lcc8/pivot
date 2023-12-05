package com.example.springboot;

import com.example.springboot.purchase.model.PurchaseRequest;
import com.example.springboot.purchase.persistant.Storage;
import com.example.springboot.purchase.service.PurchaseService;
import com.example.springboot.purchase.service.PurchaseServiceImpl;
import com.example.springboot.purchase.service.ValidateBudgetService;
import com.example.springboot.purchase.service.ValidateRequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchaseServiceUTest {

    private PurchaseService classToTest;
    private List<ValidateRequestService> validatePurchaseServices = new ArrayList<>();

    @Mock
    private ValidateBudgetService validateBudgetServiceMock;
    @Mock
    private ValidateRequestService validateRequestServiceMock;
    @Mock
    private Storage storage;
    @Mock
    private PurchaseRequest purchaseRequest;

    @BeforeEach
    public void setup(){
        validatePurchaseServices.add(validateRequestServiceMock);
        validatePurchaseServices.add(validateBudgetServiceMock);

        classToTest = new PurchaseServiceImpl(validatePurchaseServices, storage);
    }

    @Test
    public void shouldValidatePurchaseRequest(){
        when(validateRequestServiceMock.isValidate(purchaseRequest)).thenReturn(true);
        when(validateBudgetServiceMock.isValidate(purchaseRequest)).thenReturn(true);

        classToTest.processPurchase(purchaseRequest);
        verify(validateRequestServiceMock).isValidate(purchaseRequest);
        verify(validateBudgetServiceMock).isValidate(purchaseRequest);
    }
}