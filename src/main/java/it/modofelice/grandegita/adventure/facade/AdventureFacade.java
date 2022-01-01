package it.modofelice.grandegita.adventure.facade;

import it.modofelice.grandegita.adventure.dto.AdventureDto;

import java.util.List;
import java.util.UUID;

public interface AdventureFacade {

    List<AdventureDto> findAll();
    AdventureDto findAdventureById(UUID id);
}
