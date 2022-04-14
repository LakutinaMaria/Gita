package it.modofelice.grandegita.adventure.repository;

import it.modofelice.grandegita.adventure.model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdventureRepo extends JpaRepository<Adventure, UUID> {

    void deleteAdventureById(UUID id);

    Optional <Adventure> findAdventureById(UUID id);
}
