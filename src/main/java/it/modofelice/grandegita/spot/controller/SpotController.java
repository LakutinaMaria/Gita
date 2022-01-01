package it.modofelice.grandegita.spot.controller;

import it.modofelice.grandegita.spot.dto.SpotDto;
import it.modofelice.grandegita.spot.facade.SpotFacade;
import it.modofelice.grandegita.spot.model.Spot;
import it.modofelice.grandegita.spot.service.SpotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/spot")
public class SpotController {
    public final SpotService spotService;
    public final SpotFacade spotFacade;

    @GetMapping("/page")
    public ResponseEntity<Page<SpotDto>> findAll(Pageable page){
        Page<SpotDto> spots = spotFacade.findAll(page);
        log.debug(" {} ", spots.getTotalElements());

        return new ResponseEntity<>(spots, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Spot>> findAll(){
        List<Spot> spots = spotService.findAll();
        return  new ResponseEntity<>(spots, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spot> findSpotById(@PathVariable("id") UUID id){
        Spot spot = spotService.findSpotById(id);
        return new ResponseEntity<>(spot, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Spot> addSpot(@RequestBody Spot spot){
        Spot newSpot = spotService.addSpot(spot);
        return new ResponseEntity<>(spot, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Spot> updateSpot(@RequestBody Spot spot){
        Spot newSpot = spotService.updateSpot(spot);
        return new ResponseEntity<>(newSpot, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpot(@PathVariable("id") UUID id){
        spotService.deleteSpotById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
