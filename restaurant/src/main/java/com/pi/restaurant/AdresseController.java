package com.pi.restaurant;
import com.pi.restaurant.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresses")
public class AdresseController {

    private final AdresseService adresseService;

    @Autowired
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping
    public List<Adresse> getAllAdresses() {
        return adresseService.getAllAdresses();
    }

    @GetMapping("/{id}")
    public Adresse getAdresseById(@PathVariable Long id) {
        return adresseService.getAdresseById(id).orElse(null);
    }

    @PostMapping
    public Adresse createAdresse(@RequestBody Adresse adresse) {
        return adresseService.createAdresse(adresse);
    }

    @PutMapping("/{id}")
    public Adresse updateAdresse(@PathVariable Long id, @RequestBody Adresse updatedAdresse) {
        return adresseService.updateAdresse(id, updatedAdresse);
    }

    @DeleteMapping("/{id}")
    public void deleteAdresse(@PathVariable Long id) {
        adresseService.deleteAdresse(id);
    }
}
