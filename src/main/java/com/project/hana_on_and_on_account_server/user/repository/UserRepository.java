package com.project.hana_on_and_on_account_server.user.repository;

import com.project.hana_on_and_on_account_server.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPassword(String password);
}
