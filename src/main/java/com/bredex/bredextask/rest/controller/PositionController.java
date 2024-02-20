package com.bredex.bredextask.rest.controller;

import com.bredex.bredextask.model.entity.Position;
import javax.validation.Valid;

import com.bredex.bredextask.model.dto.PositionRegistrationRequest;
import com.bredex.bredextask.rest.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Validated
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/position")
    public ResponseEntity<String> createPosition(
            @RequestParam(required = true) String apiKey,
            @Valid @RequestBody PositionRegistrationRequest positionRequest
    ) {
        try {
            positionService.isValidApiKey(apiKey);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid API key");
        }

        Position position = new Position(positionRequest.getName(), positionRequest.getLocation());

        Position createdPosition = positionService.createPosition(position);

        String uri = "/position/" + createdPosition.getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(uri);
    }

    @GetMapping("/position/search")
    public ResponseEntity<List<String>> searchPositions(
            @RequestParam(required = true) String apiKey,
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String location
    ) {

        try {
            positionService.isValidApiKey(apiKey);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonList(e.toString()));
        }

        List<Position> positions = positionService.searchPositions(name, location);

        List<String> positionUrls = positionService.generatePositionUrls(positions);

        return ResponseEntity.ok(positionUrls);
    }

    @GetMapping("/position/{id}")
    public ResponseEntity<String> getPositionById(@PathVariable Long id) {
        Position position = positionService.getPositionById(id);
        if (position != null) {
            return ResponseEntity.ok(position.toString());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Position not found for id: " + id);
        }
    }

}
