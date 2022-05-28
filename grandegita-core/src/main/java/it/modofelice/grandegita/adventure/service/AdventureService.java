package it.modofelice.grandegita.adventure.service;

import it.modofelice.grandegita.adventure.model.Adventure;

import java.util.List;
import java.util.UUID;

public interface AdventureService {

    Adventure addAdventure(Adventure adventure);
    Adventure updateAdventure(Adventure adventure);
    List<Adventure> findAll();
    void deleteAdventure(UUID id);
    Adventure findAdventureById(UUID id);
}
