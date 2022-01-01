package it.modofelice.grandegita.adventure.service.imp;

import it.modofelice.grandegita.adventure.model.Adventure;
import it.modofelice.grandegita.adventure.repository.AdventureRepo;
import it.modofelice.grandegita.adventure.service.AdventureService;
import it.modofelice.grandegita.exception.DBObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AdventureServiceImp implements AdventureService {
    private final AdventureRepo adventureRepo;

    public Adventure addAdventure(Adventure adventure){
        log.info("");
        return adventureRepo.save(adventure);
    }

    public Adventure updateAdventure(Adventure adventure){
        return adventureRepo.save(adventure);
    }

    public List<Adventure> findAll(){
        return adventureRepo.findAll();
    }

    public void deleteAdventure(UUID id){
        adventureRepo.deleteAdventureById(id);
    }

    public Adventure findAdventureById(UUID id){
        return adventureRepo.findAdventureById(id).orElseThrow(
                ()-> new DBObjectNotFoundException("Adventure with id " + id + " was not found"));
    }
}
