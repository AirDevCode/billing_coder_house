package com.billing.billing.services;

import com.billing.billing.models.Client;
import com.billing.billing.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setDocumentType(client.getDocumentType());
            existingClient.setDocument(client.getDocument());
            existingClient.setName(client.getName());
            existingClient.setLastName(client.getLastName());
            existingClient.setEmail(client.getEmail());
            return clientRepository.save(existingClient);
        } else {
            // Handle client not found
            return null;
        }
    }
}
