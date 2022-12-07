package com.kluevja.bankappweb.services;

import com.kluevja.bankappweb.models.Client;
import com.kluevja.bankappweb.models.Role;
import com.kluevja.bankappweb.repositories.ClientRepository;
import com.kluevja.bankappweb.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createClient(Client client) {
        Role roleForNewClient = roleRepository.findBySystemName("USER");
        client.setRole(roleForNewClient);
        client.setAccounts(new ArrayList<>());
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setActive(true);
        clientRepository.save(client);
        return true;
    }

    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    public boolean updateClient(Client client) {
        Client clientForChange = clientRepository.findById(client.getId()).get();
        clientForChange.setName(client.getName());
        clientForChange.setSurname(client.getSurname());
        clientForChange.setPatronymic(client.getPatronymic());
        clientForChange.setPassword(client.getPassword());
        clientRepository.save(clientForChange);
        return true;
    }

    public boolean deleteClient(Long id) {
        clientRepository.delete(clientRepository.findById(id).get());
        return true;
    }
}
