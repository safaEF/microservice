package com.pi.restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    public Menu createMenu(Menu menu) {
        // Ajoutez ici une logique de validation ou de traitement si nécessaire
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu updatedMenu) {
        // Ajoutez ici une logique de validation ou de traitement si nécessaire
        if (menuRepository.existsById(id)) {
            updatedMenu.setId(id);
            return menuRepository.save(updatedMenu);
        } else {
            // Gérer le cas où le menu avec l'ID spécifié n'existe pas
            return null;
        }
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
