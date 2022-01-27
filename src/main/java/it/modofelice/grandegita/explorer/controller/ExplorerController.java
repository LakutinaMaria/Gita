package it.modofelice.grandegita.explorer.controller;

import it.modofelice.grandegita.explorer.dto.ExplorerDto;
import it.modofelice.grandegita.explorer.model.Explorer;
import it.modofelice.grandegita.explorer.service.ExplorerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/explorer")
@Slf4j
public class ExplorerController {
    private final ExplorerService explorerService;

    @Autowired
    public ExplorerController(ExplorerService explorerService) {
        this.explorerService = explorerService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ExplorerDto>> getAllExplorers(Pageable page) {
        Page<ExplorerDto> explorers = explorerService.findAll(page);
        log.debug("Received {} explorers", explorers.getTotalElements());

        return new ResponseEntity<>(explorers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExplorerDto> getExplorerById(@PathVariable("id") UUID id) {
        ExplorerDto explorer = explorerService.findById(id);
        return new ResponseEntity<>(explorer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ExplorerDto> addExplorer(@RequestBody ExplorerDto explorer) {
        ExplorerDto newExplorer = explorerService.addExplorer(explorer);
        return new ResponseEntity<>(newExplorer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ExplorerDto> updateExplorer(@RequestBody ExplorerDto explorer) {
        ExplorerDto newExplorer = explorerService.updateExplorer(explorer);
        return new ResponseEntity<>(newExplorer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExplorer(@PathVariable("id") UUID id) {
        explorerService.deleteExplorer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
