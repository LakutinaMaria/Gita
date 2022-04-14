package it.modofelice.grandegita.adventure.mapper;

import it.modofelice.grandegita.adventure.dto.AdventureDto;
import it.modofelice.grandegita.adventure.model.Adventure;
import it.modofelice.grandegita.spot.mapper.SpotDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {
        SpotDtoMapper.class,
})
public interface AdventureDtoMapper {
    AdventureDto toDto(Adventure adventures);
    Adventure toEntity(AdventureDto adventures);
}
