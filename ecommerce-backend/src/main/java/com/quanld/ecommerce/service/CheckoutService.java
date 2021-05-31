package com.quanld.ecommerce.service;

import com.quanld.ecommerce.dto.PurChase;
import com.quanld.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(PurChase purChase);
}
