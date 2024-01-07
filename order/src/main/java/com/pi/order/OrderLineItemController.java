package com.pi.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderlineitems")

public class OrderLineItemController {

    @Autowired
    private OrderLineItemService orderLineItemService;

    @GetMapping
    public ResponseEntity<List<OrderLineItem>> getAllOrderLineItems() {
        List<OrderLineItem> orderLineItems = orderLineItemService.getAllOrderLineItems();
        return new ResponseEntity<>(orderLineItems, HttpStatus.OK);
    }

    @GetMapping("/{orderLineItemId}")
    public ResponseEntity<OrderLineItem> getOrderLineItemById(@PathVariable Integer orderLineItemId) {
        Optional<OrderLineItem> orderLineItem = orderLineItemService.getOrderLineItemById(orderLineItemId);

        if (orderLineItem.isPresent()) {
            return new ResponseEntity<>(orderLineItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OrderLineItem> createOrderLineItem(@RequestBody OrderLineItem orderLineItem) {
        OrderLineItem createdOrderLineItem = orderLineItemService.createOrderLineItem(orderLineItem);
        return new ResponseEntity<>(createdOrderLineItem, HttpStatus.CREATED);
    }

    @PutMapping("/{orderLineItemId}")
    public ResponseEntity<OrderLineItem> updateOrderLineItem(
            @PathVariable Integer orderLineItemId,
            @RequestBody OrderLineItem updatedOrderLineItem) {

        Optional<OrderLineItem> updated = orderLineItemService.updateOrderLineItem(orderLineItemId, updatedOrderLineItem);

        if (updated.isPresent()) {
            return new ResponseEntity<>(updated.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderLineItemId}")
    public ResponseEntity<Void> deleteOrderLineItem(@PathVariable Integer orderLineItemId) {
        orderLineItemService.deleteOrderLineItem(orderLineItemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
