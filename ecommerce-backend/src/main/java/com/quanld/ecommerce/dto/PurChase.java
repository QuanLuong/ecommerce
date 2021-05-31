package com.quanld.ecommerce.dto;

import com.quanld.ecommerce.entity.Address;
import com.quanld.ecommerce.entity.Customer;
import com.quanld.ecommerce.entity.Order;
import com.quanld.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class PurChase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;
}
