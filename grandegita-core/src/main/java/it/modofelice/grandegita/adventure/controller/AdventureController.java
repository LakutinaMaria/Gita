package it.modofelice.grandegita.adventure.controller;

import it.modofelice.grandegita.adventure.dto.AdventureDto;
import it.modofelice.grandegita.adventure.facade.AdventureFacade;
import it.modofelice.grandegita.adventure.model.Adventure;
import it.modofelice.grandegita.adventure.service.AdventureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/adventure")
public class AdventureController {
    private final AdventureService adventureService;
    private final AdventureFacade facade;


    @GetMapping("/all")
    public ResponseEntity<List<AdventureDto>> getAllAdventures(){
        log.debug("Request for a list of adventures has been accepted");
        List<AdventureDto> adventures = facade.findAll();
        log.debug("List of adventures of {} elements has been received", adventures.size());
        return new ResponseEntity<>(adventures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdventureDto> getAdventureById(@PathVariable("id") UUID id){
        log.debug("Request to find the adventure by id {}", id);
        AdventureDto adventure = facade.findAdventureById(id);
        log.debug("Adventure {} has been received", adventure.getId());

        return new ResponseEntity<>(adventure, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Adventure> addAdventure(@RequestBody Adventure adventure){
        Adventure newAdventure = adventureService.addAdventure(adventure);
        return new ResponseEntity<>(newAdventure, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Adventure> updateAdventure(@RequestBody Adventure adventure){
        Adventure updateAdventure = adventureService.updateAdventure(adventure);
        return new ResponseEntity<>(updateAdventure, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdventure(@PathVariable("id") UUID id){
        adventureService.deleteAdventure(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
