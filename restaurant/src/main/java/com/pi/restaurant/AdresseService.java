package com.pi.restaurant;

import com.pi.restaurant.Adresse;
import com.pi.restaurant.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService {

    private final AdresseRepository adresseRepository;

    @Autowired
    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    public List<Adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }

    public Optional<Adresse> getAdresseById(Long id) {
        return adresseRepository.findById(id);
    }

    public Adresse createAdresse(Adresse adresse) {
        // Ajoutez ici une logique de validation ou de traitement si nécessaire
        return adresseRepository.save(adresse);
    }

    public Adresse updateAdresse(Long id, Adresse updatedAdresse) {
        // Ajoutez ici une logique de validation ou de traitement si nécessaire
        if (adresseRepository.existsById(id)) {
            updatedAdresse.setId(id);
            return adresseRepository.save(updatedAdresse);
        } else {
            // Gérer le cas où l'adresse avec l'ID spécifié n'existe pas
            return null;
        }
    }

    public void deleteAdresse(Long id) {
        adresseRepository.deleteById(id);
    }
}
