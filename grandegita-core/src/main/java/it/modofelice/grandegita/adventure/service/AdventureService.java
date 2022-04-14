package it.modofelice.grandegita.adventure.service;

import it.modofelice.grandegita.adventure.model.Adventure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AdventureService {

    Adventure addAdventure(Adventure adventure);
    Adventure updateAdventure(Adventure adventure);
    List<Adventure> findAll();
    void deleteAdventure(UUID id);
    Adventure findAdventureById(UUID id);
}
