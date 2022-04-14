package it.modofelice.grandegita.spot.facade.imp;

import it.modofelice.grandegita.spot.dto.SpotDto;
import it.modofelice.grandegita.spot.facade.SpotFacade;
import it.modofelice.grandegita.spot.mapper.SpotDtoMapper;
import it.modofelice.grandegita.spot.service.SpotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SpotFacadeImp implements SpotFacade {

    private final SpotService service;
    private final SpotDtoMapper mapper;

    @Override
    public Page<SpotDto> findAll(Pageable page) {
        return service.findAll(page);
    }
}
