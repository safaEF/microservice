package com.pi.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryInfoService {

    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;

    public Optional<DeliveryInfo> getDeliveryInfoByOrderId(Integer orderId) {
        return deliveryInfoRepository.findById(orderId);
    }

    public DeliveryInfo createDeliveryInfo(DeliveryInfo deliveryInfo) {
        return deliveryInfoRepository.save(deliveryInfo);
    }

    public Optional<DeliveryInfo> updateDeliveryInfo(Integer orderId, DeliveryInfo updatedDeliveryInfo) {
        Optional<DeliveryInfo> existingDeliveryInfo = deliveryInfoRepository.findById(orderId);

        if (existingDeliveryInfo.isPresent()) {
            DeliveryInfo deliveryInfo = existingDeliveryInfo.get();
            deliveryInfo.setDeliveryTime(updatedDeliveryInfo.getDeliveryTime());
            deliveryInfo.setDeliveryAddress(updatedDeliveryInfo.getDeliveryAddress());

            return Optional.of(deliveryInfoRepository.save(deliveryInfo));
        } else {
            return Optional.empty();
        }
    }

    public void deleteDeliveryInfo(Integer orderId) {
        deliveryInfoRepository.deleteById(orderId);
    }
}
