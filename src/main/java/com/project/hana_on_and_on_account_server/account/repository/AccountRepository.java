package com.project.hana_on_and_on_account_server.account.repository;

import com.project.hana_on_and_on_account_server.account.domain.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUserUserId(Long userId);
}
