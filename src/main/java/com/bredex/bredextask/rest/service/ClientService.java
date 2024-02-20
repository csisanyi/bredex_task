package com.bredex.bredextask.rest.service;

import com.bredex.bredextask.model.entity.Client;
import com.bredex.bredextask.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public UUID registerClient(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient.getApiKey();
    }

    public boolean isEmailUnique(String email) {
        List<Client> existingClients = clientRepository.findByEmail(email);
        return existingClients.isEmpty();
    }
}
