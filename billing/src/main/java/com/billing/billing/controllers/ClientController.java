package com.billing.billing.controllers;

import com.billing.billing.models.Client;
import com.billing.billing.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<Object> createClient(@RequestBody Client client) {
        try {
            Client createdClient = clientService.createClient(client);
            return ResponseEntity.ok(createdClient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el cliente: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody Client client) {
        try {
            Client updatedClient = clientService.updateClient(id, client);
            return ResponseEntity.ok(updatedClient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClientById(@PathVariable Long id) {
        try {
            clientService.deleteClientById(id);
            return ResponseEntity.ok("Cliente eliminado exitosamente con ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el cliente con ID: " + id);
        }
    }
}
