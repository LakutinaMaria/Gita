package it.modofelice.grandegita.spot.facade;

import it.modofelice.grandegita.spot.dto.SpotDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpotFacade {
    Page<SpotDto> findAll(Pageable page);
}
