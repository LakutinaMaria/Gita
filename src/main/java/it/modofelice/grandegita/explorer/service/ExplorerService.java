package it.modofelice.grandegita.explorer.service;

import it.modofelice.grandegita.explorer.model.Explorer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExplorerService {

    Explorer addExplorer(Explorer explorer);
    List<Explorer> findAll();
    Explorer findById(Long id);
    Explorer updateExplorer(Explorer explorer);
    void deleteExplorer(Long id);
}
