package com.pi.order;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.order.OrderLineItem;

// OrderLineItemsRepository.java
public interface OrderLineItemsRepository extends JpaRepository<OrderLineItem, Integer> {
}