package it.modofelice.grandegita.explorer.controller;

import it.modofelice.grandegita.explorer.model.Explorer;
import it.modofelice.grandegita.explorer.service.ExplorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/explorer")
public class ExplorerController {
    private final ExplorerService explorerService;

    @Autowired
    public ExplorerController(ExplorerService explorerService) {
        this.explorerService = explorerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Explorer>> getAllExplorers(){
        List<Explorer> explorers = explorerService.findAll();
        return new ResponseEntity<>(explorers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Explorer> getExplorerById(@PathVariable("id") Long id){
        Explorer explorer = explorerService.findById(id);
        return new ResponseEntity<>(explorer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Explorer> addExplorer(@RequestBody Explorer explorer){
        Explorer newExplorer = explorerService.addExplorer(explorer);
        return new ResponseEntity<>(newExplorer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Explorer> updateExplorer(@RequestBody Explorer explorer){
        Explorer newExplorer = explorerService.updateExplorer(explorer);
        return new ResponseEntity<>(newExplorer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExplorer(@PathVariable("id") Long id){
        explorerService.deleteExplorer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
