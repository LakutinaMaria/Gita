package it.modofelice.grandegita.explorer.service.imp;

import it.modofelice.grandegita.exception.DBObjectNotFoundException;
import it.modofelice.grandegita.explorer.model.Explorer;
import it.modofelice.grandegita.explorer.repository.ExplorerRepo;
import it.modofelice.grandegita.explorer.service.ExplorerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExplorerServiceImp  implements ExplorerService {
    private final ExplorerRepo explorerRepo;

    public Explorer addExplorer(Explorer explorer){ return explorerRepo.save(explorer);}

    public List<Explorer> findAll(){ return explorerRepo.findAll();}

    public Explorer findById(Long id) {
        return explorerRepo.findExplorerById(id).orElseThrow(
                ()-> new DBObjectNotFoundException("Explorer " + id + " was not found"));
    }

    public Explorer updateExplorer(Explorer explorer) {return this.explorerRepo.save(explorer);}

    public void deleteExplorer(Long id){this.explorerRepo.deleteExplorerById(id);}
}
