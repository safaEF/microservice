package com.pi.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}
