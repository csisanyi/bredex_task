package com.bredex.bredextask.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID apiKey;

    private String name;

    private String email;

    public Client() {
        this.apiKey = UUID.randomUUID();
    }

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
        this.apiKey = UUID.randomUUID();
    }

    public Client(String name, String email, UUID apikey) {
        this.name = name;
        this.email = email;
        this.apiKey = apikey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getApiKey() {
        return apiKey;
    }

    public void setApiKey(UUID apiKey) {
        this.apiKey = apiKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



