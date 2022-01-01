package it.modofelice.grandegita.spot.service;

import it.modofelice.grandegita.spot.dto.SpotDto;
import it.modofelice.grandegita.spot.model.Spot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SpotService {

    Spot addSpot(Spot spot);
    Spot updateSpot(Spot spot);
    Spot findSpotById(UUID id);
    List<Spot> findAll();
    void deleteSpotById(UUID id);
    Page<SpotDto> findAll(Pageable page);
}
