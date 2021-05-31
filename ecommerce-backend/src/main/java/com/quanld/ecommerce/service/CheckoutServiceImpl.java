package com.quanld.ecommerce.service;

import com.quanld.ecommerce.dto.PurChase;
import com.quanld.ecommerce.dto.PurchaseResponse;
import com.quanld.ecommerce.entity.Customer;
import com.quanld.ecommerce.entity.Order;
import com.quanld.ecommerce.entity.OrderItem;
import com.quanld.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurChase purChase) {
        //retrieve the order info from sto
        Order order = purChase.getOrder();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //populate order with orderItem
        Set<OrderItem> orderItems = purChase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purChase.getBillingAddress());
        order.setShippingAddress(purChase.getShippingAddress());
        //populate customer with order
        Customer customer = purChase.getCustomer();
        customer.add(order);
        //save to the database
        customerRepository.save(customer);
        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
