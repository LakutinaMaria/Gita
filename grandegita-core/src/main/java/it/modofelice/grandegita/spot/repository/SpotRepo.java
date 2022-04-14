package it.modofelice.grandegita.spot.repository;

import it.modofelice.grandegita.spot.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpotRepo extends JpaRepository<Spot, UUID> {

    void deleteSpotById(UUID id);

    Optional<Spot> findSpotById(UUID id);
}
