package com.kluevja.bankappweb.repositories;

import com.kluevja.bankappweb.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
