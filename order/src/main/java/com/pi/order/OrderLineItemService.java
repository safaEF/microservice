package com.pi.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;





@Service
public class OrderLineItemService {

    @Autowired
    private OrderLineItemRepository orderLineItemRepository;

    public List<OrderLineItem> getAllOrderLineItems() {
        return orderLineItemRepository.findAll();
    }

    public Optional<OrderLineItem> getOrderLineItemById(Integer orderLineItemId) {
        return orderLineItemRepository.findById(orderLineItemId);
    }

    public OrderLineItem createOrderLineItem(OrderLineItem orderLineItem) {
        return orderLineItemRepository.save(orderLineItem);
    }

    public Optional<OrderLineItem> updateOrderLineItem(Integer orderLineItemId, OrderLineItem updatedOrderLineItem) {
        Optional<OrderLineItem> existingOrderLineItem = orderLineItemRepository.findById(orderLineItemId);

        if (existingOrderLineItem.isPresent()) {
            OrderLineItem orderLineItem = existingOrderLineItem.get();
            orderLineItem.setQuantity(updatedOrderLineItem.getQuantity());
            orderLineItem.setMenuId(updatedOrderLineItem.getMenuId());

            return Optional.of(orderLineItemRepository.save(orderLineItem));
        } else {
            return Optional.empty();
        }
    }

    public void deleteOrderLineItem(Integer orderLineItemId) {
        orderLineItemRepository.deleteById(orderLineItemId);
    }
}
