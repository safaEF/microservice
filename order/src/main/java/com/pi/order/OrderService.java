package com.pi.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> updateOrder(Integer orderId, Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findById(orderId);

        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setState(updatedOrder.getState());
            order.setConsumerId(updatedOrder.getConsumerId());
            order.setRestaurantId(updatedOrder.getRestaurantId());

            return Optional.of(orderRepository.save(order));
        } else {
            return Optional.empty();
        }
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
