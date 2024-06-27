package com.project.hana_on_and_on_account_server.account.repository;

import com.project.hana_on_and_on_account_server.account.domain.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
}
