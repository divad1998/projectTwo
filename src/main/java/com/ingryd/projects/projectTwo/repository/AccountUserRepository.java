package com.ingryd.projects.projectTwo.repository;

import com.ingryd.projects.projectTwo.model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountUserRepository extends JpaRepository<AccountUser, Integer> {
    Optional<AccountUser> findByUsername(String username);
}
