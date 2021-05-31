package com.quanld.ecommerce.controller;

import com.quanld.ecommerce.dto.PurChase;
import com.quanld.ecommerce.dto.PurchaseResponse;
import com.quanld.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody PurChase purChase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purChase);

        return purchaseResponse;
    }
}
