package it.modofelice.grandegita.explorer.mapper;

import it.modofelice.grandegita.explorer.dto.ExplorerDto;
import it.modofelice.grandegita.explorer.model.Explorer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ExplorerDtoMapper {
    ExplorerDto toDto(Explorer explorers);
    Explorer toEntity(ExplorerDto explorers);
}
