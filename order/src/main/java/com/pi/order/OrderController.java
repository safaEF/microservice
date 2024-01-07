package com.pi.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderLineItemRepository orderLineItemRepository;

    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElse(null);

        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer orderId, @RequestBody Order updatedOrder) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElse(null);

        if (existingOrder != null) {
            existingOrder.setState(updatedOrder.getState());
            existingOrder.setConsumerId(updatedOrder.getConsumerId());
            existingOrder.setRestaurantId(updatedOrder.getRestaurantId());

            Order savedOrder = orderRepository.save(existingOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElse(null);

        if (order != null) {
            orderRepository.delete(order);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Ajoutez des méthodes similaires pour OrderLineItem et DeliveryInfo

}
