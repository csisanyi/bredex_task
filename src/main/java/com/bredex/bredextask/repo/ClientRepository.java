package com.bredex.bredextask.repo;

import com.bredex.bredextask.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByEmail(String email);

    boolean existsByApiKey(UUID apiKey);

}

