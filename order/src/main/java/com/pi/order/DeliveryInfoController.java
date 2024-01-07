package com.pi.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/deliveryinfo")

public class DeliveryInfoController {

    @Autowired
    private DeliveryInfoService deliveryInfoService;

    @GetMapping("/{orderId}")
    public ResponseEntity<DeliveryInfo> getDeliveryInfoByOrderId(@PathVariable Integer orderId) {
        Optional<DeliveryInfo> deliveryInfo = deliveryInfoService.getDeliveryInfoByOrderId(orderId);

        if (deliveryInfo.isPresent()) {
            return new ResponseEntity<>(deliveryInfo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{orderId}")
    public ResponseEntity<DeliveryInfo> createDeliveryInfo(
            @PathVariable Integer orderId,
            @RequestBody DeliveryInfo deliveryInfo) {

        DeliveryInfo createdDeliveryInfo = deliveryInfoService.createDeliveryInfo(deliveryInfo);
        return new ResponseEntity<>(createdDeliveryInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<DeliveryInfo> updateDeliveryInfo(
            @PathVariable Integer orderId,
            @RequestBody DeliveryInfo updatedDeliveryInfo) {

        Optional<DeliveryInfo> updated = deliveryInfoService.updateDeliveryInfo(orderId, updatedDeliveryInfo);

        if (updated.isPresent()) {
            return new ResponseEntity<>(updated.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteDeliveryInfo(@PathVariable Integer orderId) {
        deliveryInfoService.deleteDeliveryInfo(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
