package it.modofelice.grandegita.spot.service.imp;

import it.modofelice.grandegita.exception.DBObjectNotFoundException;
import it.modofelice.grandegita.spot.dto.SpotDto;
import it.modofelice.grandegita.spot.mapper.SpotDtoMapper;
import it.modofelice.grandegita.spot.model.Spot;
import it.modofelice.grandegita.spot.repository.SpotRepo;
import it.modofelice.grandegita.spot.service.SpotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpotServiceImp  implements SpotService {
    private final SpotRepo spotRepo;
    private final SpotDtoMapper spotDtoMapper;

    public Spot addSpot(Spot spot){
        return spotRepo.save(spot);
    }

    public Spot updateSpot(Spot spot) {return spotRepo.save(spot);}

    public Spot findSpotById(UUID id) {
        return spotRepo.findSpotById(id).orElseThrow(
                ()-> new DBObjectNotFoundException("Spot " + id + " was not found")
        );
    }

    public List<Spot> findAll(){ return spotRepo.findAll(); }

    public Page<SpotDto> findAll(Pageable page){
        var spotPage =  spotRepo.findAll(page);
        var dtos = spotPage.stream().map(spotDtoMapper::toDto).collect(Collectors.toList());
        return new PageImpl<>(dtos, spotPage.getPageable(),spotPage.getTotalElements());
    }

    public void deleteSpotById(UUID id) { spotRepo.deleteSpotById(id); }
}
