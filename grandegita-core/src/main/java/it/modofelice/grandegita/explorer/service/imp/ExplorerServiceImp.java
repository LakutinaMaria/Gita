package it.modofelice.grandegita.explorer.service.imp;

import it.modofelice.grandegita.exception.DBObjectNotFoundException;
import it.modofelice.grandegita.explorer.dto.ExplorerDto;
import it.modofelice.grandegita.explorer.mapper.ExplorerDtoMapper;
import it.modofelice.grandegita.explorer.repository.ExplorerRepo;
import it.modofelice.grandegita.explorer.service.ExplorerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExplorerServiceImp  implements ExplorerService {
    private final ExplorerRepo explorerRepo;
    private final ExplorerDtoMapper explorerDtoMapper;

    public ExplorerDto addExplorer(ExplorerDto explorer){
        var entity = explorerDtoMapper.toEntity(explorer);
        entity = explorerRepo.save(entity);
        return explorerDtoMapper.toDto(entity);
    }

    public Page<ExplorerDto> findAll(Pageable page){
        var listExplorerPage = explorerRepo.findAll(page);
        var listExplorerDto = listExplorerPage.stream()
                .map(explorerDtoMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(listExplorerDto, listExplorerPage.getPageable(), listExplorerPage.getTotalElements());
    }

    public ExplorerDto findById(UUID id) {
        var entity = explorerRepo.findExplorerById(id).orElseThrow(
                ()-> new DBObjectNotFoundException("Explorer " + id + " was not found"));
        return explorerDtoMapper.toDto(entity);
    }

    public ExplorerDto updateExplorer(ExplorerDto explorer) {
        var entity = explorerDtoMapper.toEntity(explorer);
        entity = explorerRepo.save(entity);
        return explorerDtoMapper.toDto(entity);
    }

    public void deleteExplorer(UUID id){
        this.explorerRepo.deleteExplorerById(id);
    }
}
