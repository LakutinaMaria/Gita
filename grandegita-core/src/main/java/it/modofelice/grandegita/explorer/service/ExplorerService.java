package it.modofelice.grandegita.explorer.service;

import it.modofelice.grandegita.explorer.dto.ExplorerDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

@Service
public interface ExplorerService {

    ExplorerDto addExplorer(ExplorerDto explorer);
    Page<ExplorerDto> findAll(Pageable pageable);
    ExplorerDto findById(UUID id);
    ExplorerDto updateExplorer(ExplorerDto explorer);
    void deleteExplorer(UUID id);
}
