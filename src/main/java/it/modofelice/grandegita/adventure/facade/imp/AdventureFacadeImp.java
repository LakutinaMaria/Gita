package it.modofelice.grandegita.adventure.facade.imp;

import it.modofelice.grandegita.adventure.model.Adventure;
import it.modofelice.grandegita.adventure.dto.AdventureDto;
import it.modofelice.grandegita.adventure.facade.AdventureFacade;
import it.modofelice.grandegita.adventure.mapper.AdventureDtoMapper;
import it.modofelice.grandegita.adventure.service.AdventureService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class AdventureFacadeImp implements AdventureFacade {

    private final AdventureService service;
    private final AdventureDtoMapper mapper;

    @Override
    public List<AdventureDto> findAll() {
        List<Adventure> entity = service.findAll();
        log.debug("Received a list of adventures: {}", entity.size());
        var result = entity.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        log.debug("List of adventures have been converted into list of dtos: {}", result.size());
        return result;
    }

    @Override
    public AdventureDto findAdventureById(UUID id) {
        Adventure entity = service.findAdventureById(id);
        log.debug("Received adventure id: {}", entity.getId());
        var result = mapper.toDto(entity);
        log.debug("Adventure entity haa been converted into dto: {}", result.getId());
        return result;
    }
}
