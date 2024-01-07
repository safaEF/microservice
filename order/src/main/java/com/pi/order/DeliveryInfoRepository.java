package com.pi.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
