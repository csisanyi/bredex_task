package com.bredex.bredextask.rest.service;

import com.bredex.bredextask.model.entity.Position;
import com.bredex.bredextask.repo.ClientRepository;
import com.bredex.bredextask.repo.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PositionService {

    private final ClientRepository clientRepository;
    private  final PositionRepository positionRepository;

    @Autowired
    public PositionService(ClientRepository clientRepository, PositionRepository positionRepository) {
        this.clientRepository = clientRepository;
        this.positionRepository = positionRepository;
    }

    public boolean isValidApiKey(String apiKey) {
        UUID apiKeyUUID;
        try {
            apiKeyUUID = UUID.fromString(apiKey);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("invalid api key");
        }

        return clientRepository.existsByApiKey(apiKeyUUID);
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }


    public List<Position> searchPositions(String name, String location) {
        return positionRepository.findByNameContainingIgnoreCaseAndLocationContainingIgnoreCase(name, location);
    }

    public List<String> generatePositionUrls(List<Position> positions) {
        return positions.stream()
                .map(position -> "/position/" + position.getId())
                .collect(Collectors.toList());
    }

    public Position getPositionById(Long id) {
        Optional<Position> positionOptional = positionRepository.findById(id);
        return positionOptional.orElse(null);
    }
}
