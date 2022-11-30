package com.kluevja.bankappweb.repositories;

import com.kluevja.bankappweb.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findBySystemName(String systemName);
}
