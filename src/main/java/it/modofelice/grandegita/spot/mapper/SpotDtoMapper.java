package it.modofelice.grandegita.spot.mapper;

import org.mapstruct.Mapper;
import it.modofelice.grandegita.spot.dto.SpotDto;
import it.modofelice.grandegita.spot.model.Spot;

import java.util.List;


@Mapper(componentModel = "spring")
public interface SpotDtoMapper {
    SpotDto toDto(Spot spots);
    Spot toEntity(SpotDto spots);
}
