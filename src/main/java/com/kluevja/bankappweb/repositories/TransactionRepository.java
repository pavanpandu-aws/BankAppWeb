package com.kluevja.bankappweb.repositories;

import com.kluevja.bankappweb.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
