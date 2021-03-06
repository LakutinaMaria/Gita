package it.modofelice.grandegita.explorer.mapper;

import it.modofelice.grandegita.explorer.dto.ExplorerDto;
import it.modofelice.grandegita.explorer.model.Explorer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExplorerDtoMapper {
    ExplorerDto toDto(Explorer explorers);
    Explorer toEntity(ExplorerDto explorers);
}
