package com.cot.controller;

import com.cot.domain.Placement;
import com.cot.service.PlacementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/placement")
@AllArgsConstructor
public class PlacementController {

    private final PlacementService placementService;

    @GetMapping(value = "/{placementId}")
    public ResponseEntity<Placement> getPlacement(@PathVariable Long placementId) {
        return new ResponseEntity<>(placementService.findById(placementId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Placement>> getPlacements() {
        return new ResponseEntity<>(placementService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Placement> create(@RequestBody Placement placement) {
        return new ResponseEntity<>(placementService.save(placement), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{placementId}")
    public ResponseEntity<Placement> update(@RequestBody Placement placement) {
        return new ResponseEntity<>(placementService.save(placement), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{placementId}")
    public ResponseEntity<Void> delete(@PathVariable Long placementId) {
        placementService.delete(placementId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
