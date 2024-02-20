package com.bredex.bredextask.rest.controller;

import com.bredex.bredextask.model.entity.Client;
import com.bredex.bredextask.model.dto.ClientRegistrationRequest;
import com.bredex.bredextask.rest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<String> registerClient(@Valid @RequestBody ClientRegistrationRequest request) {
        if (!clientService.isEmailUnique(request.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email must be unique");
        }

        Client client = new Client(request.getName(), request.getEmail());
        UUID apiKey = clientService.registerClient(client);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiKey.toString());
    }

}


