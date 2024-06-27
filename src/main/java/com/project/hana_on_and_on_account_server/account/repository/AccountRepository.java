package com.project.hana_on_and_on_account_server.account.repository;

import com.project.hana_on_and_on_account_server.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
}
